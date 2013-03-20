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

import org.java_gtk.gtk.Dialog.ResponseType;

/**
 * A widget that displays a small to medium amount of text
 * <p>
 * The Label widget displays a small amount of text. As the name implies, 
 * most labels are used to label another widget such as a Button, 
 * a MenuItem, or a ComboBox. 
 * 
 * @author Bill Hull
 *
 */
public class Label extends Misc {

	private static native final long gtk_label_new(String label);
	private static native final String gtk_label_get_text(long labelPointer);
	private static native final void gtk_label_set_text(long labelPointer, String label);
	private static native final boolean gtk_label_get_line_wrap(long labelPointer);
	private static native final void gtk_label_set_line_wrap(long labelPointer, boolean wrap);
	private static native final int gtk_label_get_justification(long labelPointer);
	private static native final void gtk_label_set_justification(long labelPointer, int justification);
	
	/**
	 * Used for justifying the text inside a Label widget.
	 */
	public enum Justification {
		LEFT(0),
		RIGHT(1),
		CENTER(2),
		FILL(3);
		
		private Justification(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
		
		public static Justification getJustification(int value) {
			for (Justification justification: Justification.values()) {
				if (justification.getValue() == value)
					return justification;
			}
			return Justification.LEFT;
		}
	}
	
	protected Label(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new label with the specified text inside it. You can pass <code>null</code> 
	 * to get an empty label widget.
	 * 
	 * @param label the text of the label.
	 */
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
	
	/**
	 * Sets the text within the Label widget. It overwrites any text that was there before.
	 * 
	 * @param text the new text of the label
	 */
	public void setText(String text) {
		lock.lock();
		try {
			gtk_label_set_text(this.pointer, text);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the text from the Label widget.
	 * 
	 * @return the text in the label widget
	 */
	public String getText() {
		lock.lock();
		try {
			return gtk_label_get_text(pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Toggles line wrapping within the Label widget
	 * 
	 * @param wrap {@code true} to enable line wrapping
	 */
	public void setLineWrap(boolean wrap) {
		lock.lock();
		try {
			gtk_label_set_line_wrap(this.pointer, wrap);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns whether lines in the label are automatically wrapped.
	 * 
	 * @return {@code true} if the lines of the label are automatically wrapped.
	 */
	public boolean getLineWrap() {
		lock.lock();
		try {
			return gtk_label_get_line_wrap(pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the alignment of the lines in the text of the label relative to each other.
	 * Has no effect on labels containing only a single line.
	 * 
	 * @param justification Justification value
	 */
	public void setJustification(Justification justification) {
		lock.lock();
		try {
			gtk_label_set_justification(this.pointer, justification.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the justification of the label.
	 * 
	 * @return the justification
	 */
	public Justification getJustification() {
		int value;
		lock.lock();
		try {
			value = gtk_label_get_justification(pointer);
		}
		finally {
			lock.unlock();
		}
		return Justification.getJustification(value);
	}
	
}
