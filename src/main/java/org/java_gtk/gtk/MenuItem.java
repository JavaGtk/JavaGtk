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

import org.java_gtk.util.ObjectCache;

/**
 * The MenuItem widget and the derived widgets are the only valid children 
 * for menus. Their function is to correctly handle highlighting, alignment, 
 * events and submenus.
 *  
 * @author Bill
 *
 */
public class MenuItem extends Bin {

	private static native final long gtk_menu_item_new();
	private static native final long gtk_menu_item_new_with_label(String label);
	private static native final void gtk_menu_item_set_label(long menuitemPointer, String label);
	private static native final String gtk_menu_item_get_label(long menuitemPointer);
	private static native final void gtk_menu_item_set_submenu(long menuitemPointer, long widgetPointer);
	private static native final long gtk_menu_item_get_submenu(long menuitemPointer);
	private static native final void gtk_menu_item_add_activated_event_handler(long widgetPointer, ActivatedEventHandler handler, MenuItem receiver);

	protected MenuItem(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a MenuItem widget.
	 */
	public MenuItem() {
		super(newMenuItem());
	}
	
	private static long newMenuItem() {
		lock.lock();
		try {
			return gtk_menu_item_new();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Creates a new MenuItem whose child is a Label
	 * 
	 * @param label the text of the label.
	 */
	public MenuItem(String label) {
		this(newMenuItem(label));
	}
	
	private static long newMenuItem(String label) {
		lock.lock();
		try {
			return gtk_menu_item_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets or replaces the menu item's submenu, or removes it when a <code>null</code> 
	 * submenu is passed.
	 *  
	 * @param submenu
	 */
	public void setSubMenu(Widget submenu) {
		lock.lock();
		try {
			gtk_menu_item_set_submenu(this.pointer, submenu.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the submenu underneath this menu item, if any.
	 * 
	 * @return submenu for this menu item, or <code>null</code> if none.
	 */
	public Widget getSubMenu() {
		lock.lock();
		try {
			long widget = gtk_menu_item_get_submenu(this.pointer);
			if (widget != 0) {
				return (Widget) ObjectCache.lookup(widget);
			}
			return null;
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets text on the MenuItem label.
	 * 
	 * @param label The text in the MenuItem label.
	 */
	public void setLabel(String label) {
		lock.lock();
		try {
			gtk_menu_item_set_label(this.pointer, label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Fetches the text from the label of the MenuItem, as set by the MenuItem(String label) 
	 * constructor. If the label text has not been set the return value will be 
	 * <code>null</code>. This will be the case if you create an empty MenuItem with 
	 * the MenuItem() constructor. 
	 * 
	 * @return The text of the label widget.
	 */
	public String getLabel() {
		lock.lock();
		try {
			return gtk_menu_item_get_label(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Adds the specified handler to receive activated events from this MenuItem.  
	 * The activated event is fired when the MenuItem has been activated.
	 * 
	 * @param handler the handler to be added.
	 */
	public void addActivatedHandler(ActivatedEventHandler handler) {
		lock.lock();
		try {
			gtk_menu_item_add_activated_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * The listener interface for receiving clicked events.
	 */
	public interface ActivatedEventHandler {
		boolean handle(MenuItem source);
	}
	
	static boolean activatedEventReceiver(ActivatedEventHandler handler, long sourcePointer) {
		return handler.handle((MenuItem)ObjectCache.lookup(sourcePointer));
	}

}