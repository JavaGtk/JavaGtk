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
 * Widget that displays a TextBuffer
 * 
 * @author Bill
 *
 */
public class TextView extends Container {

	private static native final long gtk_text_view_new();
	private static native final void gtk_text_view_set_editable(long textviewPointer, boolean editable);
	private static native final boolean gtk_text_view_get_editable(long textviewPointer);
	private static native final void gtk_text_view_set_cursor_visible(long textviewPointer, boolean visible);
	private static native final boolean gtk_text_view_get_cursor_visible(long textviewPointer);

	protected TextView(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new TextView.
	 */
	public TextView () {
		this(newTextView());
	}
		
	private static long newTextView() {
		lock.lock();
		try {
			return gtk_text_view_new();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the default editability of the TextView. 
	 * 
	 * @param editable {@code true} to make editable
	 */
	public void setEditable(boolean editable) {
		lock.lock();
		try {
			gtk_text_view_set_editable(this.pointer, editable);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Returns whether text is editable by default.
	 * 
	 * @return whether text is editable by default.
	 */
	public boolean isEditable() {
		lock.lock();
		try {
			return gtk_text_view_get_editable(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Toggles whether the insertion point is displayed. 
	 * 
	 * @param visible {@code true} to make cursor visible.
	 */
	public void setCursorVisible(boolean visible) {
		lock.lock();
		try {
			gtk_text_view_set_cursor_visible(this.pointer, visible);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Find out whether the cursor is being displayed.
	 * 
	 * @return whether the insertion mark is visible.
	 */
	public boolean isCursorVisible() {
		lock.lock();
		try {
			return gtk_text_view_get_cursor_visible(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
