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
 * MenuShell is the abstract base class used to derive the Menu and 
 * MenuBar subclasses.
 * <p> 
 * MenuShell is a container of MenuItem objects arranged in a list 
 * which can be navigated, selected, and activated by the user to 
 * perform application functions. A MenuItem can have a submenu 
 * associated with it, allowing for nested hierarchical menus.
 *  
 * @author Bill
 *
 */
public abstract class MenuShell extends Container {

	private static native final void gtk_menu_shell_append(long menushellPointer, long widgetPointer);
	private static native final void gtk_menu_shell_prepend(long menushellPointer, long widgetPointer);
	private static native final void gtk_menu_shell_insert(long menushellPointer, long widgetPointer, int position);
	
	protected MenuShell(long pointer) {
		super(pointer);
	}

	/**
	 * Adds a new MenuItem to the end of the menu shell's item list.
	 * 
	 * @param child The MenuItem to add
	 */
	public void append(MenuItem child) {
		lock.lock();
		try {
			gtk_menu_shell_append(this.pointer, child.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Adds a new MenuItem to the beginning of the menu shell's item list.
	 * 
	 * @param child The MenuItem to add
	 */
	public void prepend(MenuItem child) {
		lock.lock();
		try {
			gtk_menu_shell_prepend(this.pointer, child.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds a new MenuItem to the menu shell's item list at the position 
	 * indicated by position.
	 * 
	 * @param child The MenuItem to add
	 * @param position The position in the item list where child is added. 
	 * Positions are numbered from 0 to n-1
	 */
	public void insert(MenuItem child, int position) {
		lock.lock();
		try {
			gtk_menu_shell_insert(this.pointer, child.getPointer(), position);
		}
		finally {
			lock.unlock();
		}
	}
}
