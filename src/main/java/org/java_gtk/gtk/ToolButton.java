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
 * ToolButtons are ToolItems containing buttons. 
 * 
 * @author Bill
 *
 */
public class ToolButton extends ToolItem {
	
	private static native final long gtk_tool_button_new(long widgetPointer, String label);
	private static native final long gtk_tool_button_new_from_stock(String stock_id);
	private static native final void gtk_tool_button_add_clicked_event_handler(long widgetPointer, ClickedEventHandler handler, ToolButton receiver);

	protected ToolButton(long pointer) {
		super(pointer);
	}
	
	/**
	 * Creates a new ToolButton using <code>icon</code> as contents and <code>label</code> as label.
	 * 
	 * @param icon a widget that will be used as the button contents, or <code>null</code>.
	 * @param label a string that will be used as label, or <code>null</code>.
	 */
	public ToolButton(Widget icon, String label) {
		super(newToolItem(icon, label));
	}
	
	private static long newToolItem(Widget icon, String label) {
		lock.lock();
		try {
			return gtk_tool_button_new(icon.getPointer(), label);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Constructs a new ToolButton containing the image and text from a stock item.
	 * 
	 * @param stockItem the stock item.
	 */
	public ToolButton(StockItems stockItem) {
		super(newToolButtonFromStock(stockItem));
	}
	
	private static long newToolButtonFromStock(StockItems stockItem) {
		lock.lock();
		try {
			return gtk_tool_button_new_from_stock(stockItem.getValue());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Adds the specified handler to receive clicked events from this ToolButton.  
	 * This event is fired when the tool button is clicked with the mouse or 
	 * activated with the keyboard.
	 * 
	 * @param handler the handler to be added.
	 */
	public void addClickedHandler(ClickedEventHandler handler) {
		lock.lock();
		try {
			gtk_tool_button_add_clicked_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * The listener interface for receiving clicked events.
	 */
	public interface ClickedEventHandler {
		boolean handle(ToolButton source);
	}
	
	static boolean clickedEventReceiver(ClickedEventHandler handler, long sourcePointer) {
		return handler.handle((ToolButton)ObjectCache.lookup(sourcePointer));
	}

}
