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
 * Grid is a container which arranges its child widgets in rows and columns.
 * 
 * @author Bill
 *
 */
public class Grid extends Container {

	private static native final long gtk_grid_new();
	private static native final void gtk_grid_attach(long gridPointer, long widgetPointer, int left, int top, int width, int height);
	private static native final void gtk_grid_set_row_spacing (long gridPointer, int spacing);
	private static native final int gtk_grid_get_row_spacing(long gridPointer);
	private static native final void gtk_grid_set_column_spacing(long gridPointer, int spacing);
	private static native final int gtk_grid_get_column_spacing(long gridPointer);
	private static native final void gtk_grid_set_row_homogeneous (long gridPointer, boolean homogeneous);
	private static native final boolean gtk_grid_get_row_homogeneous(long gridPointer);
	private static native final void gtk_grid_set_column_homogeneous(long gridPointer, boolean homogeneous);
	private static native final boolean gtk_grid_get_column_homogeneous(long gridPointer);

	protected Grid(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new grid.
	 */
	public Grid () {
		this(newGrid());
	}
		
	private static long newGrid() {
		lock.lock();
		try {
			return gtk_grid_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds a widget to the grid.
	 * <p>
	 * The position of child is determined by left and top. The number 
	 * of 'cells' that child will occupy is determined by width and height. 
	 *
	 * @param widget the widget to add
	 * @param left the column number to attach the left side of child to
	 * @param top the row number to attach the top side of child to
	 * @param width the number of columns that child will span
	 * @param height the number of rows that child will span
	 */
	public void attach(Widget widget, int left, int top, int width, int height) {
		lock.lock();
		try {
			gtk_grid_attach(this.pointer, widget.getPointer(), left, top, width, height);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the amount of space between rows
	 * 
	 * @param spacing the amount of space to insert between rows
	 */
	public void setRowSpacing(int spacing) {
		lock.lock();
		try {
			gtk_grid_set_row_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Returns the amount of space between the rows
	 * 
	 * @return the row spacing
	 */
	public int getRowSpacing() {
		lock.lock();
		try {
			return gtk_grid_get_row_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the amount of space between columns
	 * 
	 * @param spacing the amount of space to insert between columns
	 */
	public void setColumnSpacing(int spacing) {
		lock.lock();
		try {
			gtk_grid_set_column_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Returns the amount of space between the columns
	 * 
	 * @return the column spacing
	 */
	public int getColumnSpacing() {
		lock.lock();
		try {
			return gtk_grid_get_column_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets whether all rows of grid will have the same width. 
	 * 
	 * @param homogeneous {@code true} to make rows homogeneous
	 */
	public void setRowHomogeneous(boolean homogeneous) {
		lock.lock();
		try {
			gtk_grid_set_row_homogeneous(this.pointer, homogeneous);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Returns whether all rows of grid have the same width.
	 * 
	 * @return whether all rows of grid have the same width.
	 */
	public boolean isRowHomogeneous() {
		lock.lock();
		try {
			return gtk_grid_get_row_homogeneous(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets whether all columns of grid will have the same width.
	 * 
	 * @param homogeneous {@code true} to make columns homogeneous
	 */
	public void setColumnHomogeneous(boolean homogeneous) {
		lock.lock();
		try {
			gtk_grid_set_column_homogeneous(this.pointer, homogeneous);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Returns whether all columns of grid have the same width.
	 * 
	 * @return whether all columns of grid have the same width.
	 */
	public boolean isColumnHomogeneous() {
		lock.lock();
		try {
			return gtk_grid_get_column_homogeneous(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
