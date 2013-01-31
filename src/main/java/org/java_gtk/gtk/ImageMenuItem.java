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
 * An ImageMenuItem is a menu item which has an icon next to the text label.
 * 
 * @author Bill
 *
 */
public class ImageMenuItem extends MenuItem {
	
	private static native final long gtk_image_menu_item_new();
	private static native final long gtk_image_menu_item_new_with_label(String label);
	private static native final long gtk_image_menu_item_new_with_mnemonic(String label);
	private static native final long gtk_image_menu_item_new_from_stock(String label, long accelGroupPointer);
	
	protected ImageMenuItem(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs an ImageMenuItem widget with an empty label.
	 */
	public ImageMenuItem() {
		super(newImageMenuItem());
	}
	
	private static long newImageMenuItem() {
		lock.lock();
		try {
			return gtk_image_menu_item_new();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Constructs a new MenuItem whose child is a Label
	 * 
	 * @param label the text of the label.
	 */
	public ImageMenuItem(String label) {
		this(label, false);
	}
	
	/**
	 * Constructs a new MenuItem whose child is a Label
	 * 
	 * @param label the text of the label, optionally with an underscore in front of the 
	 * mnemonic character
	 * @param hasMnenomic if <code>true</code> then the label will be created with mnenonics, 
	 * so underscores in label indicate the mnemonic for the menu item.
	 */
	public ImageMenuItem(String label, boolean hasMnemonic) {
		this(newImageMenuItem(label, hasMnemonic));
	}
	
	private static long newImageMenuItem(String label, boolean hasMnemonic) {
		lock.lock();
		try {
			if (hasMnemonic)
				return gtk_image_menu_item_new_with_mnemonic(label);
			else
				return gtk_image_menu_item_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Constructs a new ImageMenuItem containing the image and text from a stock item.
	 * 
	 * @param stockItem the stock item.
	 */
	public ImageMenuItem(StockItems stockItem) {
		this(newImageMenuItemFromStock(stockItem, null));
	}

	/**
	 * Constructs a new ImageMenuItem containing the image and text from a stock item and
	 * adds it to the specified AccelGroup.
	 * 
	 * @param stockItem the stock item.
	 * @param accelGroup the AccelGroup to add the menu items accelerator to, or <code>null</code>
	 */
	public ImageMenuItem(StockItems stockItem, AccelGroup accelGroup) {
		this(newImageMenuItemFromStock(stockItem, accelGroup));
	}
	
	private static long newImageMenuItemFromStock(StockItems stockItem, AccelGroup accelGroup) {
		lock.lock();
		try {
			return gtk_image_menu_item_new_from_stock(stockItem.getValue(), accelGroup==null?0:accelGroup.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
}
