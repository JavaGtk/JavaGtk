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

import org.java_gtk.gdk.Pixbuf;
import org.java_gtk.gobject.GType;

/**
 * A list-like data structure that can be used with TreeView or IconView
 * 
 * @author Bill
 *
 */
public class ListStore extends TreeModel {

	private static final native long gtk_list_store_new(int columns, long[] types);
	private static final native void gtk_list_store_append(long liststorePointer, long iterPointer);
	private static final native boolean gtk_list_store_remove(long liststorePointer, long iterPointer);
	private static final native void gtk_list_store_clear(long liststorePointer);
	private static final native void gtk_list_store_set_string(long liststorePointer, long iterPointer, int columnNum, String value);
	private static final native void gtk_list_store_set_pixbuf(long liststorePointer, long iterPointer, int columnNum, long pixbufPointer);
	
	protected ListStore(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new ListStore with columns of the types passed in. 
	 * Note that only Java primitives, Strings, and types derived from  
	 * standard GObject types are supported.
	 * 
	 * @param types class types for each column in order
	 */
	public ListStore (Class<?>...types) {
		this(newListStore(types));
	}
		
	private static long newListStore(Class<?>...types) {
		long[] data_types = new long[types.length];
		int index = 0;
		for (Class<?> clazz: types) {
			data_types[index++] = GType.lookup(clazz).getValue();
		}
		lock.lock();
		try {
			return gtk_list_store_new(data_types.length, data_types);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Appends a new row to ListStore.  The row will be empty.
	 * 
	 * @param iter a TreeIterator to set to the appended row
	 */
	public void append(TreeIterator iter) {
		lock.lock();
		try {
			gtk_list_store_append(this.pointer, iter.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Removes the given row from the list store. After being removed, 
	 * iter is set to be the next valid row, or invalidated if it pointed 
	 * to the last row in the list store.
	 * 
	 * @param iter pointer to the row to remove
	 * @return {@code true} if iter is valid
	 */
	public boolean remove(TreeIterator iter) {
		lock.lock();
		try {
			return gtk_list_store_remove(this.pointer, iter.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Removes all rows from the list store.
	 */
	public void clear() {
		lock.lock();
		try {
			gtk_list_store_clear(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the data in the cell specified by iter and columnNum.
	 * The column type must have been configured to accept Strings.
	 * 
	 * @param iter A valid TreeIterator for the row being modified
	 * @param columnNum column number to modify
	 * @param value new String value for the cell
	 */
	public void set(TreeIterator iter, int columnNum, String value) {
		lock.lock();
		try {
			gtk_list_store_set_string(this.pointer, iter.getPointer(), columnNum, value);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the data in the cell specified by iter and columnNum.
	 * The column type must have been configured to accept a Pixbuf.
	 * 
	 * @param iter A valid TreeIterator for the row being modified
	 * @param columnNum column number to modify
	 * @param value new Pixbuf value for the cell
	 */
	public void set(TreeIterator iter, int columnNum, Pixbuf value) {
		lock.lock();
		try {
			gtk_list_store_set_pixbuf(this.pointer, iter.getPointer(), columnNum, value.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
		
}
