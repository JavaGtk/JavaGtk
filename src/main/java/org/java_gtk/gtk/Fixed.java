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

/**
 * The Fixed widget is a container which can place child widgets at 
 * fixed positions and with fixed sizes, given in pixels. Fixed performs 
 * no automatic layout management.
 * 
 * @author Bill
 *
 */
public class Fixed extends Container {

	private static native final long gtk_fixed_new();
	private static native final void gtk_fixed_put(long fixedPointer, long widgetPointer, int x, int y);

	protected Fixed(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new Fixed widget.
	 */
	public Fixed () {
		this(newFixed());
	}
		
	private static long newFixed() {
		lock.lock();
		try {
			return gtk_fixed_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds a widget to a Fixed container at the given position.
	 * 
	 * @param widget the widget to add.
	 * @param x the horizontal position to place the widget at.
	 * @param y the vertical position to place the widget at.
	 */
	public void add(Widget widget, int x, int y) {
		lock.lock();
		try {
			gtk_fixed_put(this.pointer, widget.getPointer(), x, y);
		}
		finally {
			lock.unlock();
		}
	}

}
