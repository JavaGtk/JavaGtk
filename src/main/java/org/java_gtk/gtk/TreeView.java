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
 * A widget for displaying both trees and lists
 * 
 * @author Bill
 *
 */
public class TreeView extends Container {

	private static native final long gtk_tree_view_new();
	private static native final void gtk_tree_view_set_headers_visible(long treeviewPointer, boolean visible);
	private static native final void gtk_tree_view_set_model(long treeviewPointer, long modelPointer);
	private static native final long gtk_tree_view_get_model(long treeviewPointer);
	private static native final int gtk_tree_view_append_column(long treeviewPointer, long columnPointer);
	private static native final long gtk_tree_view_get_selection(long treeviewPointer);
	
	private TreeSelection treeSelection; 

	protected TreeView(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new TreeView.
	 */
	public TreeView () {
		this(newTreeView());
	}
		
	private static long newTreeView() {
		lock.lock();
		try {
			return gtk_tree_view_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the visibility state of the headers.
	 * 
	 * @param visible {@code true} if the headers are visible
	 */
	public void setHeadersVisible(boolean visible) {
		lock.lock();
		try {
			gtk_tree_view_set_headers_visible(this.pointer, visible);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the model for a TreeView. If the TreeView already has a model set, 
	 * it will remove it before setting the new model. If model is {@code null}, 
	 * then it will unset the old model.
	 * 
	 * @param model the model or {@code null} to remove
	 */
	public void setModel(TreeModel model) {
		long m = (model == null ? 0 : model.getPointer());
		lock.lock();
		try {
			gtk_tree_view_set_model(this.pointer, m);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the model the TreeView is based on. Returns {@code null} if the model is unset.
	 * 
	 * @return the model or {@code null} if no model is used.
	 */
	public TreeModel getModel() {
		long model;
		lock.lock();
		try {
			model = gtk_tree_view_get_model(this.pointer);
		}
		finally {
			lock.unlock();
		}
		return (TreeModel)ObjectCache.lookup(model);
	}

	/**
	 * Adds a column to the list of columns.
	 * 
	 * @param column the column to add
	 * @return the number of columns in the TreeView after adding
	 */
	public int addColumn(TreeViewColumn column) {
		lock.lock();
		try {
			return gtk_tree_view_append_column(this.pointer, column.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the TreeSelection associated with the TreeView
	 * 
	 * @return the TreeSelection
	 */
	public TreeSelection getSelection() {
		if (treeSelection == null) {
			long selection;
			lock.lock();
			try {
				selection = gtk_tree_view_get_selection(this.pointer);
			}
			finally {
				lock.unlock();
			}
			treeSelection = new TreeSelection(selection);
		}
		return treeSelection;
	}

}
