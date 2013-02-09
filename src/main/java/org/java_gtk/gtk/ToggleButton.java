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
 * A ToggleButton is a Button which will remain 'pressed-in' when clicked. 
 * Clicking again will cause the toggle button to return to its normal state.
 * 
 * @author Bill
 *
 */
public class ToggleButton extends Button {

	private static native final long gtk_toggle_button_new();
	private static native final long gtk_toggle_button_new_with_label(String label);
	private static native final long gtk_toggle_button_new_with_mnemonic(String label);
	private static native final void gtk_toggle_button_set_active(long togglebuttonPointer, boolean active);
	private static native final boolean gtk_toggle_button_get_active(long togglebuttonPointer);

	protected ToggleButton(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a ToggleButton widget.
	 */
	public ToggleButton() {
		super(newToggleButton());
	}
	
	private static long newToggleButton() {
		lock.lock();
		try {
			return gtk_toggle_button_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Constructs a new Button whose child is a Label
	 * 
	 * @param label the text of the label.
	 */
	public ToggleButton(String label) {
		this(label, false);
	}
	
	/**
	 * Constructs a new ToggleButton whose child is a Label
	 * 
	 * @param label the text of the label, optionally with an underscore in front of the 
	 * mnemonic character
	 * @param hasMnenomic if <code>true</code> then the label will be created with mnemonics, 
	 * so underscores in label indicate the mnemonic for the toggle button.
	 */
	public ToggleButton(String label, boolean hasMnemonic) {
		this(newToggleButton(label, hasMnemonic));
	}
	
	private static long newToggleButton(String label, boolean hasMnemonic) {
		lock.lock();
		try {
			if (hasMnemonic)
				return gtk_toggle_button_new_with_mnemonic(label);
			else
				return gtk_toggle_button_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the status of the toggle button. Set to {@code true} if you want 
	 * the ToggleButton to be 'pressed in', and {@code false} to raise it. 
	 * This action caused the toggled and the clicked events to fire. 
	 * 
	 * @param active boolean value indicating whether the toggle button is active.
	 */
	public void setActive(boolean active) {
		lock.lock();
		try {
			gtk_toggle_button_set_active(this.pointer, active);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns whether the toggle button is active.
	 * 
	 * @return {@code true} if the toggle button is pressed in and {@code false} 
	 *         if it is raised
	 */
	public boolean isActive() {
		lock.lock();
		try {
			return gtk_toggle_button_get_active(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
