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

import org.java_gtk.gobject.Handler;
import org.java_gtk.gtk.Button.ClickedEventHandler;
import org.java_gtk.util.ObjectCache;

/**
 * ComboBox is a widget that allows the user to choose from a list of 
 * valid choices. The ComboBox displays the selected choice. When activated, 
 * the ComboBox displays a popup which allows the user to make a new choice.
 * 
 * @author Bill
 *
 */
public class ComboBox extends Bin {

	private static native final long gtk_combo_box_new();
	private static native final void gtk_combo_box_add_changed_event_handler(long widgetPointer, ChangedEventHandler handler, Class<ComboBox> receiverClass);

	protected ComboBox(long pointer) {
		super(pointer);
	}

	/**
	 * Adds the specified handler to receive changed events from this ComboBox.  
	 * The changed event is fired when the active item is changed.
	 * 
	 * @param handler the handler to be added.
	 */
	public void addChangedHandler(ChangedEventHandler handler) {
		lock.lock();
		try {
			gtk_combo_box_add_changed_event_handler(this.pointer, handler, ComboBox.class);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Removes the specified handler for changed events from this Button.  
	 * 
	 * @param handler the handler to be removed.
	 */
	public void removeChangedHandler(ChangedEventHandler handler) {
		Gtk.removeHandler(pointer, handler.getHandleId());
	}

	/**
	 * The listener for receiving changed events.
	 */
	public static abstract class ChangedEventHandler extends Handler {
		/**
		 * 
		 * @param source the object which received the event
		 */
		public abstract void handle(ComboBox source);
	}
	
	static void changedEventReceiver(ChangedEventHandler handler, long sourcePointer) {
		handler.handle((ComboBox)ObjectCache.lookup(sourcePointer));
	}

}
