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
 * ComboBoxText is a simple variant of ComboBox for simple text-only 
 * use cases.
 * 
 * @author Bill
 *
 */
public class ComboBoxText extends ComboBox {

	private static native final long gtk_combo_box_text_new();
	private static native final void gtk_combo_box_text_append(long comboboxPointer, String id, String text);
	private static native final void gtk_combo_box_text_append_text(long comboboxPointer, String text);
	private static native final String gtk_combo_box_text_get_active_text(long comboboxPointer);
	
	protected ComboBoxText(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a ComboBoxText widget.
	 */
	public ComboBoxText() {
		super(newComboBoxText());
	}
	
	private static long newComboBoxText() {
		lock.lock();
		try {
			return gtk_combo_box_text_new();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Appends a string and an ID to the list of strings stored in
	 * the ComboBox
	 * 
	 * @param id a string ID for this value or {@code null}
	 * @param text a string
	 */
	public void appendText(String id, String text) {
		lock.lock();
		try {
			gtk_combo_box_text_append(this.pointer, id, text);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Appends a string to the list of strings stored in the ComboBox
	 * 
	 * @param text a string
	 */
	public void appendText(String text) {
		lock.lock();
		try {
			gtk_combo_box_text_append_text(this.pointer, text);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the currently active string, or {@code null} if none is selected.
	 * 
	 * @return the currently active text
	 */
	public String getActiveText() {
		lock.lock();
		try {
			return gtk_combo_box_text_get_active_text(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
}
