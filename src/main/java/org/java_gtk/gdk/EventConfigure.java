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

package org.java_gtk.gdk;

/**
 * Generated when a window size or position has changed.
 * 
 * @author Bill
 *
 */
public class EventConfigure extends Event {

	private static native final int gtk_event_configure_get_x(long eventPointer);
	private static native final int gtk_event_configure_get_y(long eventPointer);
	private static native final int gtk_event_configure_get_width(long eventPointer);
	private static native final int gtk_event_configure_get_height(long eventPointer);
	
	public EventConfigure(long pointer) {
		super(pointer);
	}
	
	/**
	 * Gets the new x coordinate of the window.
	 * 
	 * @return the new x coordinate of the window, relative to its parent.
	 */
	public int getX() {
		lock.lock();
		try {
			return gtk_event_configure_get_x(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Gets the new y coordinate of the window.
	 * 
	 * @return the new y coordinate of the window, relative to its parent.
	 */
	public int getY() {
		lock.lock();
		try {
			return gtk_event_configure_get_y(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Gets the new width of the window.
	 * 
	 * @return the new width of the window
	 */
	public int getWidth() {
		lock.lock();
		try {
			return gtk_event_configure_get_width(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
	
	/**
	 * Gets the new height of the window.
	 * 
	 * @return the new height of the window
	 */
	public int getHeight() {
		lock.lock();
		try {
			return gtk_event_configure_get_height(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}

}
