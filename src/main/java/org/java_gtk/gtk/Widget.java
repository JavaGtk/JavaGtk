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

import java.util.TreeMap;

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
	private static native final String gtk_widget_get_name(long widgetPointer);
	private static native final void gtk_widget_set_name(long widgetPointer, String name);
	private static native final boolean gtk_widget_get_sensitive(long widgetPointer);
	private static native final void gtk_widget_set_sensitive(long widgetPointer, boolean sensitive);
	private static native final int gtk_widget_get_halign(long widgetPointer);
	private static native final void gtk_widget_set_halign(long widgetPointer, int align);
	private static native final int gtk_widget_get_valign(long widgetPointer);
	private static native final void gtk_widget_set_valign(long widgetPointer, int align);
	private static native final int gtk_widget_get_margin_left(long widgetPointer);
	private static native final void gtk_widget_set_margin_left(long widgetPointer, int margin);
	private static native final int gtk_widget_get_margin_right(long widgetPointer);
	private static native final void gtk_widget_set_margin_right(long widgetPointer, int margin);
	private static native final int gtk_widget_get_margin_top(long widgetPointer);
	private static native final void gtk_widget_set_margin_top(long widgetPointer, int margin);
	private static native final int gtk_widget_get_margin_bottom(long widgetPointer);
	private static native final void gtk_widget_set_margin_bottom(long widgetPointer, int margin);
	private static native final boolean gtk_widget_get_hexpand(long widgetPointer);
	private static native final void gtk_widget_set_hexpand(long widgetPointer, boolean expand);
	private static native final boolean gtk_widget_get_vexpand(long widgetPointer);
	private static native final void gtk_widget_set_vexpand(long widgetPointer, boolean expand);

	public enum Align {
		FILL(0),
		START(1),
		END(2),
		CENTER(3);
		
		private Align(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
		
		private static TreeMap<Integer, Align> map;
		
		static {
			map = new TreeMap<Integer, Align>();
			for (Align align: Align.values()) {
				map.put(new Integer(align.value), align);
			}
		}
		
		public static Align lookup(int value) {
			return map.get(new Integer(value));
		}
	}
	
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
	
	/**
	 * Flags a widget to be displayed. Any widget that isn't shown will not appear on the screen.
	 */
	public void show() {
		lock.lock();
		try {
			gtk_widget_show(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Causes the widget to be hidden (invisible to the user). 
	 */
	public void hide() {
		lock.lock();
		try {
			gtk_widget_hide(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Retrieves the name of a widget.
	 * 
	 * @return name of the widget
	 */
	public String getName() {
		lock.lock();
		try {
			return gtk_widget_get_name(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Widgets can be named, which allows you to refer to them from a CSS file. You can 
	 * apply a style to widgets with a particular name in the CSS file.
	 * 
	 * @param name name for the widget
	 */
	public void setName(String name) {
		lock.lock();
		try {
			gtk_widget_set_name(this.pointer, name);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Retrieves the enabled state of a widget.
	 * 
	 * @return enabled state of the widget.
	 */
	public boolean isEnable() {
		lock.lock();
		try {
			return gtk_widget_get_sensitive(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the enabled state of a widget. A widget is enabled if the user can 
	 * interact with it. Disabled widgets are "grayed out" and the user can't 
	 * interact with them.
	 * 
	 * @param enabled enabled state of the widget.
	 */
	public void setEnabled(boolean enabled) {
		lock.lock();
		try {
			gtk_widget_set_sensitive(this.pointer, enabled);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the horizontal alignment.
	 * 
	 * @return the horizontal alignment
	 */
	public Align getHalign() {
		lock.lock();
		try {
			return Align.lookup(gtk_widget_get_halign(this.pointer));
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the horizontal alignment.
	 * 
	 * @param align the horizontal alignment
	 */
	public void setHalign(Align align) {
		lock.lock();
		try {
			gtk_widget_set_halign(this.pointer, align.getValue());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the vertical alignment.
	 * 
	 * @return the vertical alignment
	 */
	public Align getValign() {
		lock.lock();
		try {
			return Align.lookup(gtk_widget_get_valign(this.pointer));
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the vertical alignment.
	 * 
	 * @param align the vertical alignment
	 */
	public void setValign(Align align) {
		lock.lock();
		try {
			gtk_widget_set_valign(this.pointer, align.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the left margin.
	 * 
	 * @return The left margin
	 */
	public int getMarginLeft() {
		lock.lock();
		try {
			return gtk_widget_get_margin_left(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the left margin.
	 * 
	 * @param margin the left margin
	 */
	public void setMarginLeft(int margin) {
		lock.lock();
		try {
			gtk_widget_set_margin_left(this.pointer, margin);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the right margin.
	 * 
	 * @return The right margin
	 */
	public int getMarginRight() {
		lock.lock();
		try {
			return gtk_widget_get_margin_right(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the right margin.
	 * 
	 * @param margin the right margin
	 */
	public void setMarginRight(int margin) {
		lock.lock();
		try {
			gtk_widget_set_margin_right(this.pointer, margin);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the top margin.
	 * 
	 * @return The top margin
	 */
	public int getMarginTop() {
		lock.lock();
		try {
			return gtk_widget_get_margin_top(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the top margin.
	 * 
	 * @param margin the top margin
	 */
	public void setMarginTop(int margin) {
		lock.lock();
		try {
			gtk_widget_set_margin_top(this.pointer, margin);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the bottom margin.
	 * 
	 * @return The bottom margin
	 */
	public int getMarginBottom() {
		lock.lock();
		try {
			return gtk_widget_get_margin_bottom(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets the bottom margin.
	 * 
	 * @param margin the bottom margin
	 */
	public void setMarginBottom(int margin) {
		lock.lock();
		try {
			gtk_widget_set_margin_bottom(this.pointer, margin);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets whether the widget would like any available extra horizontal space. 
	 * When a user resizes a Window, widgets with expand=TRUE generally receive 
	 * the extra space.
	 * 
	 * @return whether hexpand flag is set
	 */
	public boolean getHexpand() {
		lock.lock();
		try {
			return gtk_widget_get_hexpand(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets whether the widget would like any available extra horizontal space. 
	 * When a user resizes a Window, widgets with expand=TRUE generally receive 
	 * the extra space.
	 * 
	 * @param expand whether to expand
	 */
	public void setHexpand(boolean expand) {
		lock.lock();
		try {
			gtk_widget_set_hexpand(this.pointer, expand);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets whether the widget would like any available extra vertical space. 
	 * When a user resizes a Window, widgets with expand=TRUE generally receive 
	 * the extra space.
	 * 
	 * @return whether vexpand flag is set
	 */
	public boolean getVexpand() {
		lock.lock();
		try {
			return gtk_widget_get_vexpand(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Sets whether the widget would like any available extra vertical space. 
	 * When a user resizes a Window, widgets with expand=TRUE generally receive 
	 * the extra space.
	 * 
	 * @param expand whether to expand
	 */
	public void setVexpand(boolean expand) {
		lock.lock();
		try {
			gtk_widget_set_vexpand(this.pointer, expand);
		}
		finally {
			lock.unlock();
		}
	}

}
