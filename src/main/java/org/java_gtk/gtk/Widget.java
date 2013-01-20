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

import org.java_gtk.ObjectCache;
import org.java_gtk.gdk.Event;
import org.java_gtk.gobject.GObject;

/**
 * 
 * @author Bill Hull
 *
 */
public class Widget extends GObject {
	
	private static native final void gtk_widget_show_all(long widget_id);
	private static native final void gtk_widget_destroy(long widget_id);
	private static native final void gtk_widget_add_delete_event_handler(long widget_id, DeleteEventHandler handler, Widget receiver);
	private static native final void gtk_widget_add_destroy_handler(long widget_id, DestroyHandler handler, Widget receiver);

	protected Widget(long pointer) {
		super(pointer);
		this.addDestroyHandler(new DestroyHandler() {
			@Override
			public boolean handle(Widget source) {
				source.cleanup();
				return true;
			}
			
		});
	}
	
	public void showAll() {
		lock.lock();
		try {
			gtk_widget_show_all(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void destroy() {
		lock.lock();
		try {
			gtk_widget_destroy(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void addDeleteHandler(DeleteEventHandler handler) {
		lock.lock();
		try {
			gtk_widget_add_delete_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	public interface DeleteEventHandler {
        boolean handle(Widget source, Event event);
    }
	
	static boolean deleteEventReceiver(DeleteEventHandler handler, long sourcePointer, long eventPointer) {
		return handler.handle((Widget)ObjectCache.lookup(sourcePointer), new Event(eventPointer));
	}

	public void addDestroyHandler(DestroyHandler handler) {
		lock.lock();
		try {
			gtk_widget_add_destroy_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	public interface DestroyHandler {
        boolean handle(Widget source);
    }

	static void destroyReceiver(DestroyHandler handler, long sourcePointer) {
		handler.handle((Widget)ObjectCache.lookup(sourcePointer));
	}

}
