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
	
	public void attach(Widget widget, int left, int top, int width, int height) {
		lock.lock();
		try {
			gtk_grid_attach(this.pointer, widget.getPointer(), left, top, width, height);
		}
		finally {
			lock.unlock();
		}
	}

	public void setRowSpacing(int spacing) {
		lock.lock();
		try {
			gtk_grid_set_row_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	public int getRowSpacing() {
		lock.lock();
		try {
			return gtk_grid_get_row_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	public void setColumnSpacing(int spacing) {
		lock.lock();
		try {
			gtk_grid_set_column_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	public int getColumnSpacing() {
		lock.lock();
		try {
			return gtk_grid_get_column_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	public void setRowHomogeneous(boolean homogeneous) {
		lock.lock();
		try {
			gtk_grid_set_row_homogeneous(this.pointer, homogeneous);
		}
		finally {
			lock.unlock();
		}
	}

	public boolean isRowHomogeneous() {
		lock.lock();
		try {
			return gtk_grid_get_row_homogeneous(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	public void setColumnHomogeneous(boolean homogeneous) {
		lock.lock();
		try {
			gtk_grid_set_column_homogeneous(this.pointer, homogeneous);
		}
		finally {
			lock.unlock();
		}
	}

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
