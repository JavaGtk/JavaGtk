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

import org.java_gtk.ObjectCache;

/**
 * 
 * @author Bill Hull
 *
 */
public class Button extends Bin {

	private static native final long gtk_button_new();
	private static native final long gtk_button_new_with_label(String label);
	private static native final void gtk_button_add_clicked_event_handler(long widget_id, ClickedEventHandler handler, Button receiver);

	protected Button(long pointer) {
		super(pointer);
	}

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
	
	public void addClickedHandler(ClickedEventHandler handler) {
		lock.lock();
		try {
			gtk_button_add_clicked_event_handler(this.pointer, handler, this);
		}
		finally {
			lock.unlock();
		}
	}

	public interface ClickedEventHandler {
		boolean handle(Button source);
	}
	
	static boolean clickedEventReceiver(ClickedEventHandler handler, long sourcePointer) {
		return handler.handle((Button)ObjectCache.lookup(sourcePointer));
	}
	
}
