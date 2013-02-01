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
 * A CheckMenuItem is a menu item that maintains the state of a boolean 
 * value in addition to a MenuItem's usual role in activating application code.
 * <p>
 * A check box indicating the state of the boolean value is displayed at the 
 * left side of the MenuItem. Activating the MenuItem toggles the value. 
 * 
 * @author Bill
 *
 */
public class CheckMenuItem extends MenuItem {
	
	private static native final long gtk_check_menu_item_new();
	private static native final long gtk_check_menu_item_new_with_label(String label);
	private static native final long gtk_check_menu_item_new_with_mnemonic(String label);
	private static native final void gtk_check_menu_item_set_active(long checkmenuitemPointer, boolean active);
	private static native final boolean gtk_check_menu_item_get_active(long checkmenuitemPointer);
	
	protected CheckMenuItem(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a CheckMenuItem widget with an empty label.
	 */
	public CheckMenuItem() {
		super(newCheckMenuItem());
	}
	
	private static long newCheckMenuItem() {
		lock.lock();
		try {
			return gtk_check_menu_item_new();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Constructs a new CheckMenuItem whose child is a Label
	 * 
	 * @param label the text of the label.
	 */
	public CheckMenuItem(String label) {
		this(label, false);
	}
	
	/**
	 * Constructs a new CheckMenuItem whose child is a Label
	 * 
	 * @param label the text of the label, optionally with an underscore in front of the 
	 * mnemonic character
	 * @param hasMnenomic if <code>true</code> then the label will be created with mnemonics, 
	 * so underscores in label indicate the mnemonic for the menu item.
	 */
	public CheckMenuItem(String label, boolean hasMnemonic) {
		this(newCheckMenuItem(label, hasMnemonic));
	}
	
	private static long newCheckMenuItem(String label, boolean hasMnemonic) {
		lock.lock();
		try {
			if (hasMnemonic)
				return gtk_check_menu_item_new_with_mnemonic(label);
			else
				return gtk_check_menu_item_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the active state of the menu item's check box. 
	 * 
	 * @param active boolean value indicating whether the check box is active.
	 */
	public void setActive(boolean active) {
		lock.lock();
		try {
			gtk_check_menu_item_set_active(this.pointer, active);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns whether the check menu item is active.
	 * 
	 * @return <code>true</code> if the menu item is active.
	 */
	public boolean isActive() {
		lock.lock();
		try {
			return gtk_check_menu_item_get_active(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
