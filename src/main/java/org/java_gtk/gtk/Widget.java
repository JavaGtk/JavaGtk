/* 
 * Copyright (c) 2012 - 2013, JavaGTK and Bill Hull
 *
 * Permission to use, copy, modify, and/or distribute this software
 * for any purpose with or without fee is hereby granted, provided 
 * that the above copyright notice and this permission notice appear 
 * in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL 
 * WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE 
 * AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL
 * DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA 
 * OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER 
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR 
 * PERFORMANCE OF THIS SOFTWARE.
 */

package org.java_gtk.gtk;

import org.java_gtk.gdk.Event;
import org.java_gtk.gobject.GObject;
import org.java_gtk.util.ObjectCache;

/**
 * Widget is the base class for all widgets in JavaGTK. It manages the widget lifecycle, states and style.
 * 
 * @author Bill Hull
 *
 */
public abstract class Widget extends GObject {
	
	private static native final void gtk_widget_show_all(long widgetPointer);
	private static native final void gtk_widget_destroy(long widgetPointer);
	private static native final void gtk_widget_add_delete_event_handler(long widgetPointer, DeleteEventHandler handler, Widget receiver);
	private static native final void gtk_widget_add_destroy_handler(long widgetPointer, DestroyHandler handler, Widget receiver);
	private static native final void gtk_widget_set_size_request(long widgetPointer, int width, int height);
	private static native final void gtk_widget_set_accel_path(long widgetPointer, String path, long accelgroupPointer);
	private static native final void gtk_widget_show(long widgetPointer);
	private static native final void gtk_widget_hide(long widgetPointer);	

	protected Widget(long pointer) {
		super(pointer);
		
		// this default destroy handler is used to ensure that objects are removed from the
		// object cache when they are no longer needed
		this.addDestroyHandler(new DestroyHandler() {
			@Override
			public boolean handle(Widget source) {
				source.cleanup();
				return true;
			}
			
		});
	}
	
	/**
	 * Recursively shows a widget, and any child widgets (if the widget is a container).
	 * 
	 * 
	 */
	public void showAll() {
		lock.lock();
		try {
			gtk_widget_show_all(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Destroys a widget. 
	 * <p>
	 * When a widget is destroyed, it will break any references it holds to other objects. 
	 * If the widget is inside a container, the widget will be removed from the container.
	 * <p>
	 * In most cases, only toplevel widgets (windows) require explicit destruction, 
	 * because when you destroy a toplevel its children will be destroyed as well.
	 * 
	 */
	public void destroy() {
		lock.lock();
		try {
			gtk_widget_destroy(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds the specified handler to receive delete events from this Widget.  
	 * The delete event is fired when a toplevel <code>{@link Window}</code>
	 * is closed.
	 * 
	 * @param handler the handler to be added
	 */
	public void addDeleteHandler(DeleteEventHandler handler) {
		lock.lock();
		try {
			gtk_widget_add_delete_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * The listener interface for receiving delete events.
	 */
	public interface DeleteEventHandler {
        boolean handle(Widget source, Event event);
    }
	
	static boolean deleteEventReceiver(DeleteEventHandler handler, long sourcePointer, long eventPointer) {
		return handler.handle((Widget)ObjectCache.lookup(sourcePointer), new Event(eventPointer));
	}

	/**
	 * Adds the specified handler to receive destroy events from this Widget.  
	 * The destroy event is fired when a widget is destroyed.
	 * 
	 * @param handler the handler to be added
	 */
	public void addDestroyHandler(DestroyHandler handler) {
		lock.lock();
		try {
			gtk_widget_add_destroy_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * The listener interface for receiving destroy events.
	 */
	public interface DestroyHandler {
        boolean handle(Widget source);
    }

	static void destroyReceiver(DestroyHandler handler, long sourcePointer) {
		handler.handle((Widget)ObjectCache.lookup(sourcePointer));
	}
	
	/**
	 * Sets the minimum size of a widget; that is, the widget's size request will 
	 * be at least width by height. You can use this function to force a widget 
	 * to be larger than it normally would be.
	 * 
	 * If the size request in a given direction is -1 (unset), then the "natural" 
	 * size request of the widget will be used instead.
	 * 
	 * @param width minimum width, or -1 to unset
	 * @param height minimum height, or -1 to unset
	 */
	public void setMinimumSize(int width, int height) {
		lock.lock();
		try {
			gtk_widget_set_size_request(this.pointer, width, height);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Given an accelerator group, <code>accelGroup</code>, and an accelerator path, 
	 * <code>path</code>, sets up an accelerator in <code>accelGroup</code> so 
	 * whenever the key binding that is defined for <code>path</code> is pressed, 
	 * widget will be activated. This removes any accelerators (for any accelerator 
	 * group) installed by previous calls to setAccelPath().
	 * 
	 * @param path path used to look up the accelerator
	 * @param accelGroup a AccelGroup
	 */
	public void setAccelPath(String path, AccelGroup accelGroup) {
		lock.lock();
		try {
			gtk_widget_set_accel_path(this.pointer, path, accelGroup.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	public void show() {
		lock.lock();
		try {
			gtk_widget_show(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	public void hide() {
		lock.lock();
		try {
			gtk_widget_hide(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
}
