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
 * A Window is a toplevel window which can contain other widgets.
 * 
 * @author Bill Hull
 *
 */
public class Window extends Bin {

	private static native final long gtk_window_new(int type);
	private static native final void gtk_window_set_title(long windowPointer, String title);
	private static native final String gtk_window_get_title(long windowPointer);
	
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
	
	/**
	 * Constructs a new Window, which is a toplevel window that can contain other widgets
	 */
	public Window () {
		this(newWindow());
	}
		
	private static long newWindow() {
		lock.lock();
		try {
			return gtk_window_new(WindowType.TOPLEVEL.getValue());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the title of the Window. The title of a window will be displayed in its title bar.
	 * 
	 * @param title the title of the window
	 */
	public void setTitle(String title) {
		lock.lock();
		try {
			gtk_window_set_title(pointer, title);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the title of the window.
	 * 
	 * @return the title of the window or <code>null<code> if none has been set explicitly
	 */
	public String getTitle() {
		lock.lock();
		try {
			return gtk_window_get_title(pointer);
		}
		finally {
			lock.unlock();
		}
	}
}
