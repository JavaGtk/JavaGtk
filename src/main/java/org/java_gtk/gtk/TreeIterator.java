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

import org.java_gtk.NativeObject;

/**
 * TreeIterator represents a pointer to a specific node in a
 * TreeModel object.
 * 
 * @author Bill
 *
 */
public class TreeIterator extends NativeObject {

	private static native final long gtk_tree_iter_new();
	private static native final void gtk_tree_iter_free(long iterPointer);

	protected TreeIterator(long pointer) {
		super(pointer, true, true);
	}
	
	/**
	 * Construct a new TreeIterator
	 */
	public TreeIterator() {
		this(newTreeIterator());
	}
	
	private static long newTreeIterator() {
		lock.lock();
		try {
			return gtk_tree_iter_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void cleanup(long pointer) {
		lock.lock();
		try {
			gtk_tree_iter_free(pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
