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

public class Box extends Container {

	private static native final long gtk_box_new(int orientation, int spacing);
	private static native final void gtk_box_set_spacing(long boxPointer, int spacing);
	private static native final int gtk_box_get_spacing(long boxPointer);
	private static native final void gtk_box_pack_start(long boxPointer, long widgetPointer, boolean expand, boolean fill, int padding);
	private static native final void gtk_box_pack_end(long boxPointer, long widgetPointer, boolean expand, boolean fill, int padding);

	protected Box(long pointer) {
		super(pointer);
	}
	
	public Box(Orientation orientation, int spacing) {
		super(newBox(orientation, spacing));
	}

	private static long newBox(Orientation orientation, int spacing) {
		lock.lock();
		try {
			return gtk_box_new(orientation.getValue(), spacing);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setSpacing(int spacing) {
		lock.lock();
		try {
			gtk_box_set_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	public int getSpacing() {
		lock.lock();
		try {
			return gtk_box_get_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void packStart(Widget child, boolean expand, boolean fill, int padding) {
		lock.lock();
		try {
			gtk_box_pack_start(this.pointer, child.getPointer(), expand, fill, padding);
		}
		finally {
			lock.unlock();
		}
	}

	public void packEnd(Widget child, boolean expand, boolean fill, int padding) {
		lock.lock();
		try {
			gtk_box_pack_end(this.pointer, child.getPointer(), expand, fill, padding);
		}
		finally {
			lock.unlock();
		}
	}
	
}
