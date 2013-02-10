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
 * Button press and button release events.
 * 
 * @author Bill
 *
 */
public class EventButton extends Event {
	
	private static native final double gtk_event_button_get_x_root(long eventPointer);
	private static native final double gtk_event_button_get_y_root(long eventPointer);
	private static native final long gtk_event_button_get_time(long eventPointer);
	private static native final int gtk_event_button_get_button(long eventPointer);

	public EventButton(long pointer) {
		super(pointer);
	}

	/**
	 * 
	 * @return the x coordinate of the pointer relative to the root of the screen.
	 */
	public double getXroot() {
		lock.lock();
		try {
			return gtk_event_button_get_x_root(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * 
	 * @return the y coordinate of the pointer relative to the root of the screen.
	 */
	public double getYroot() {
		lock.lock();
		try {
			return gtk_event_button_get_y_root(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * 
	 * @return the time of the event in milliseconds.
	 */
	public long getTime() {
		lock.lock();
		try {
			return gtk_event_button_get_time(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * 
	 * @return the button which was pressed or released, numbered from 1 
	 *         to 5. Normally button 1 is the left mouse button, 2 is the 
	 *         middle button, and 3 is the right button. On 2-button mice, 
	 *         the middle button can often be simulated by pressing both 
	 *         mouse buttons together.
	 */
	public int getButton() {
		lock.lock();
		try {
			return gtk_event_button_get_button(this.pointer);
		}
		finally {
			lock.unlock();
		}		
	}
}
