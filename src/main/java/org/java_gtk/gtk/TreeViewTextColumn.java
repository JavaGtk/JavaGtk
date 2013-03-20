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
 * A TreeViewColumn that handles text values.
 * 
 * @author Bill
 *
 */
public class TreeViewTextColumn extends TreeViewColumn {

	private static native final long gtk_tree_view_text_column_new(String title, long rendererPointer, int column);

	protected TreeViewTextColumn(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new TreeViewTextColumn with the specified title 
	 * and renderer, bound to the specified column number in the underlying model.
	 * 
	 * @param title column title
	 * @param renderer the CellRenderer
	 * @param columnNum column number in the model
	 */
	public TreeViewTextColumn(String title, CellRendererText renderer, int columnNum) {
		this(newTreeViewTextColumn(title, renderer, columnNum));
	}
		
	private static long newTreeViewTextColumn(String title, CellRendererText renderer, int columnNum) {
		lock.lock();
		try {
			return gtk_tree_view_text_column_new(title, renderer.getPointer(), columnNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Packs the cell into the beginning of the column. If expand is {@code false}, 
	 * then the cell is allocated no more space than it needs. Any unused space is 
	 * divided evenly between cells for which expand is {@code true}.
	 * 
	 * @param renderer a CellRendererText
	 * @param expand {@code true} if cell is to be given extra space allocated to this
	 */
	public void packStart(CellRendererText renderer, boolean expand) {
		lock.lock();
		try {
			gtk_tree_view_column_pack_start(this.pointer, renderer.getPointer(), expand);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Packs the cell into the end of the column. If expand is {@code false}, 
	 * then the cell is allocated no more space than it needs. Any unused space is 
	 * divided evenly between cells for which expand is {@code true}.
	 * 
	 * @param renderer a CellRendererText
	 * @param expand {@code true} if cell is to be given extra space allocated to this
	 */
	public void packEnd(CellRendererText renderer, boolean expand) {
		lock.lock();
		try {
			gtk_tree_view_column_pack_end(this.pointer, renderer.getPointer(), expand);
		}
		finally {
			lock.unlock();
		}
	}
	
}
