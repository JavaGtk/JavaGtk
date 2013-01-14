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
 * @author Bill
 *
 */
public class Window extends Bin {

	private static native final long gtk_window_new(int type);
	private static native final void gtk_window_set_title(long pointer, String title);
	private static native final String gtk_window_get_title(long pointer);
	
	public enum WindowType {
		TOPLEVEL(0),
		POPUP(1);
		
		private WindowType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	protected Window(long pointer) {
		super(pointer);
	}
	
	public Window () {
		this(gtk_window_new(WindowType.TOPLEVEL.getValue()));
	}
		
	public void setTitle(String title) {
		gtk_window_set_title(pointer, title);
	}
	
	public String getTitle() {
		return gtk_window_get_title(pointer);
	}
}
