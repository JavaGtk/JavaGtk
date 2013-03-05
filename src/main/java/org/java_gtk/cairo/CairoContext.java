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

package org.java_gtk.cairo;

import org.java_gtk.NativeObject;

public class CairoContext extends NativeObject {

	private static native final void cairo_show_text(long contextPointer, String text);
	private static native final void cairo_move_to(long contextPointer, double x, double y);
	
	public CairoContext(long pointer) {
		super(pointer, true, false);
	}
	
	public void showText(String text) {
		lock.lock();
		try {
			cairo_show_text(this.pointer, text);
		}
		finally {
			lock.unlock();
		}
	}

	public void moveTo(double x, double y) {
		lock.lock();
		try {
			cairo_move_to(this.pointer, x, y);
		}
		finally {
			lock.unlock();
		}
	}

}
