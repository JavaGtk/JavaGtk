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
 * A widget which displays a list of icons in a grid.
 * 
 * @author Bill
 *
 */
public class IconView extends Container {

	private static final native long gtk_icon_view_new_with_model(long modelPointer);
	private static final native void gtk_icon_view_set_text_column(long iconviewPointer, int columnNum);
	private static final native void gtk_icon_view_set_pixbuf_column(long iconviewPointer, int columnNum);
	private static final native void gtk_icon_view_set_selection_mode(long iconviewPointer, int mode);
	
	protected IconView(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new Fixed widget.
	 */
	public IconView(TreeModel model) {
		this(newIconView(model));
	}
		
	private static long newIconView(TreeModel model) {
		lock.lock();
		try {
			return gtk_icon_view_new_with_model(model.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the column that will contain text for the IconView.
	 * 
	 * @param columnNum a column number in the current model or -1 to display no text
	 */
	public void setTextColumn(int columnNum) {
		lock.lock();
		try {
			gtk_icon_view_set_text_column(this.pointer, columnNum);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the column that will contain the image for the IconView.
	 * 
	 * @param columnNum a column number in the current model or -1 to disable
	 */
	public void setPixbufColumn(int columnNum) {
		lock.lock();
		try {
			gtk_icon_view_set_pixbuf_column(this.pointer, columnNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the selection mode of the IconView
	 * 
	 * @param mode the selection mode
	 */
	public void setSelectionMode(SelectionMode mode) {
		lock.lock();
		try {
			gtk_icon_view_set_selection_mode(this.pointer, mode.getValue());
		}
		finally {
			lock.unlock();
		}
	}

}
