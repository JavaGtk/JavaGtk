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
 * 
 * @author Bill Hull
 *
 */
public class Label extends Misc {

	private static native final long gtk_label_new(String label);
	private static native final String gtk_label_get_text(long labelPointer);
	private static native final void gtk_label_set_text(long labelPointer, String label);
	
	protected Label(long pointer) {
		super(pointer);
	}
	
	public Label(String label) {
		this(newLabel(label));
	}
	
	private static long newLabel(String label) {
		lock.lock();
		try {
			return gtk_label_new(label);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setText(String text) {
		lock.lock();
		try {
			gtk_label_set_text(this.pointer, text);
		}
		finally {
			lock.unlock();
		}
	}
	
	public String getText() {
		lock.lock();
		try {
			return gtk_label_get_text(pointer);
		}
		finally {
			lock.unlock();
		}
	}
}
