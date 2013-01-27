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
 * A widget that fires an event when clicked on.
 * 
 * @author Bill Hull
 *
 */
public class Button extends Bin {

	private static native final long gtk_button_new();
	private static native final long gtk_button_new_with_label(String label);
	private static native final void gtk_button_add_clicked_event_handler(long widgetPointer, ClickedEventHandler handler, Button receiver);
	private static native final String gtk_button_get_label(long buttonPointer);
	private static native final void gtk_button_set_label(long buttonPointer, String label);

	protected Button(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a Button widget.
	 */
	public Button() {
		super(newButton());
	}
	
	private static long newButton() {
		lock.lock();
		try {
			return gtk_button_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Constructs a Button widget with a Label child containing the given text.
	 * 
	 * @param label The text you want the Label to hold.
	 */
	public Button(String label) {
		this(newButtonWithLabel(label));
	}
	
	private static long newButtonWithLabel(String label) {
		lock.lock();
		try {
			return gtk_button_new_with_label(label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds the specified handler to receive clicked events from this Button.  
	 * The clicked event is fired when the Button has been activated (pressed 
	 * and released).
	 * 
	 * @param handler the handler to be added.
	 */
	public void addClickedHandler(ClickedEventHandler handler) {
		lock.lock();
		try {
			gtk_button_add_clicked_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * The listener interface for receiving clicked events.
	 */
	public interface ClickedEventHandler {
		boolean handle(Button source);
	}
	
	static boolean clickedEventReceiver(ClickedEventHandler handler, long sourcePointer) {
		return handler.handle((Button)ObjectCache.lookup(sourcePointer));
	}
	
	/**
	 * Sets the text of the label of the button to the specified string.
	 * 
	 * @param label The new text of the label widget.
	 */
	public void setLabel(String label) {
		lock.lock();
		try {
			gtk_button_set_label(this.pointer, label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Fetches the text from the label of the button, as set by the Button(String label) 
	 * constructor. If the label text has not been set the return value will be 
	 * <code>null</code>. This will be the case if you create an empty Button with 
	 * the Button() constructor to use as a container. 
	 * 
	 * @return The text of the label widget.
	 */
	public String getLabel() {
		lock.lock();
		try {
			return gtk_button_get_label(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
}
