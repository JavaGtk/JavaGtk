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

import org.java_gtk.gobject.GObject;
import org.java_gtk.gobject.Handler;
import org.java_gtk.util.ObjectCache;

/**
 * TreeSelection object is a helper object to manage the selection 
 * for a TreeView widget. The TreeSelection object is automatically 
 * created when a new TreeView widget is created, and cannot exist 
 * independently of this widget.
 * 
 * @author Bill
 *
 */
public class TreeSelection extends GObject {

	private static native final long gtk_tree_selection_get_selected(long treeselectionPointer);
	private static native final void gtk_tree_selection_add_changed_event_handler(long widgetPointer, ChangedEventHandler handler, Class<TreeSelection> receiverClass);

	/**
	 * Constructs a new TreeSelection object.
	 * 
	 * @param pointer
	 */
	public TreeSelection(long pointer) {
		super(pointer);
	}

	/**
	 * Returns a TreeIterator that points to the currently selected node.
	 * 
	 * @return pointer to the selected node
	 */
	public TreeIterator getSelected() {
		long iterator;
		lock.lock();
		try {
			iterator = gtk_tree_selection_get_selected(this.pointer);
		}
		finally {
			lock.unlock();
		}
		if (iterator != 0) {
			return new TreeIterator(iterator);
		}
		return null;
	}
	
	/**
	 * Adds the specified handler to receive changed events from this TreeSelection.  
	 * The changed event is fired whenever the selection has (possibly) changed.
	 * 
	 * @param handler the handler to be added.
	 */
	public void addChangedHandler(ChangedEventHandler handler) {
		lock.lock();
		try {
			gtk_tree_selection_add_changed_event_handler(this.pointer, handler, TreeSelection.class);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Removes the specified handler for changed events from this TreeSelection.  
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
		public abstract void handle(TreeSelection source);
	}
	
	static void changedEventReceiver(ChangedEventHandler handler, long sourcePointer) {
		handler.handle((TreeSelection)ObjectCache.lookup(sourcePointer));
	}
		
}
