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

/**
 * TreeModel represents a hierarchical tree of strongly-typed, 
 * columned data.
 * 
 * @author Bill
 *
 */
public abstract class TreeModel extends GObject {

	private static final native long gtk_tree_model_get_long(long treemodelPointer, long iterPointer, int column);
	private static final native String gtk_tree_model_get_string(long treemodelPointer, long iterPointer, int column);
	private static final native boolean gtk_tree_model_get_iter_first(long treemodelPointer, long iterPointer);
	
	protected TreeModel(long pointer) {
		super(pointer);
	}

	/**
	 * Retrieves a long value from the model
	 * 
	 * @param iter pointer to the row containing the value
	 * @param columnNum column number of the value
	 * @return the value
	 */
	public long getLong(TreeIterator iter, int columnNum) {
		lock.lock();
		try {
			return gtk_tree_model_get_long(this.pointer, iter.getPointer(), columnNum);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Retrieves a String value from the model
	 * 
	 * @param iter pointer to the row containing the value
	 * @param columnNum column number of the value
	 * @return the value
	 */
	public String getString(TreeIterator iter, int columnNum) {
		lock.lock();
		try {
			return gtk_tree_model_get_string(this.pointer, iter.getPointer(), columnNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets iter to the first Iterator in the tree.
	 *  
	 * @param iter the TreeIterator to set
	 * @return {@code true} if iter was set
	 */
	public boolean getFirstIterator(TreeIterator iter) {
		lock.lock();
		try {
			return gtk_tree_model_get_iter_first(this.pointer, iter.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

}
