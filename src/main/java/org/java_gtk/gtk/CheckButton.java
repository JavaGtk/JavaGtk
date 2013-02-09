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
 * A CheckButton places a discrete ToggleButton next to a widget.
 * 
 * @author Bill
 *
 */
public class CheckButton extends ToggleButton {

	private static native final long gtk_check_button_new();
	private static native final long gtk_check_button_new_with_label(String label);
	private static native final long gtk_check_button_new_with_mnemonic(String label);

	protected CheckButton(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a CheckButton widget.
	 */
	public CheckButton() {
		super(newCheckButton());
	}
	
	private static long newCheckButton() {
		lock.lock();
		try {
			return gtk_check_button_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Constructs a new CheckButton with a Label to the right of it
	 * 
	 * @param label the text of the Label.
	 */
	public CheckButton(String label) {
		this(label, false);
	}
	
	/**
	 * Constructs a new CheckButton with a Label to the right of it
	 * 
	 * @param label the text of the label, optionally with an underscore in front of the 
	 * mnemonic character
	 * @param hasMnenomic if <code>true</code> then the label will be created with mnemonics, 
	 * so underscores in label indicate the mnemonic for the check button.
	 */
	public CheckButton(String label, boolean hasMnemonic) {
		this(newCheckButton(label, hasMnemonic));
	}
	
	private static long newCheckButton(String label, boolean hasMnemonic) {
		lock.lock();
		try {
			if (hasMnemonic)
				return gtk_check_button_new_with_mnemonic(label);
			else
				return gtk_check_button_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}

}
