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
 * The Alignment widget controls the alignment and size of its child 
 * widget. It has four settings: xscale, yscale, xalign, and yalign.
 * <p>
 * The scale settings are used to specify how much the child widget 
 * should expand to fill the space allocated to the Alignment. The 
 * values can range from 0 (meaning the child doesn't expand at all) 
 * to 1 (meaning the child expands to fill all of the available space).
 * <p>
 * The align settings are used to place the child widget within the 
 * available area. The values range from 0 (top or left) to 1 (bottom 
 * or right). Of course, if the scale settings are both set to 1, the 
 * alignment settings have no effect. 
 * 
 * @author Bill
 *
 */
public class Alignment extends Bin {

	private static native final long gtk_alignment_new(float xalign, float yalign, float xscale, float yscale);
	private static native final void gtk_alignment_set(long alignmentPointer, float xalign, float yalign, float xscale, float yscale);
	private static native final void gtk_alignment_set_padding(long alignmentPointer, int top, int bottom, int left, int right);
	
	protected Alignment(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new Alignment.
	 * 
	 * @param xalign the horizontal alignment of the child widget, from 0 (left) to 1 (right).
	 * @param yalign the vertical alignment of the child widget, from 0 (top) to 1 (bottom).
	 * @param xscale the amount that the child widget expands horizontally to fill up unused 
	 * space, from 0 to 1. A value of 0 indicates that the child widget should never expand. 
	 * A value of 1 indicates that the child widget will expand to fill all of the space 
	 * allocated for the Alignment.
	 * @param yscale the amount that the child widget expands vertically to fill up unused 
	 * space, from 0 to 1. The values are similar to xscale.
	 */
	public Alignment(float xalign, float yalign, float xscale, float yscale) {
		this(newAlignment(xalign, yalign, xscale, yscale));
	}
		
	private static long newAlignment(float xalign, float yalign, float xscale, float yscale) {
		lock.lock();
		try {
			return gtk_alignment_new(xalign, yalign, xscale, yscale);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the Alignment values.
	 * 
	 * @param xalign the horizontal alignment of the child widget, from 0 (left) to 1 (right).
	 * @param yalign the vertical alignment of the child widget, from 0 (top) to 1 (bottom).
	 * @param xscale the amount that the child widget expands horizontally to fill up unused 
	 * space, from 0 to 1. A value of 0 indicates that the child widget should never expand. 
	 * A value of 1 indicates that the child widget will expand to fill all of the space 
	 * allocated for the Alignment.
	 * @param yscale the amount that the child widget expands vertically to fill up unused 
	 * space, from 0 to 1. The values are similar to xscale.
	 */
	public void setAlignment(int top, int bottom, int left, int right) {
		lock.lock();
		try {
			gtk_alignment_set(this.pointer, top, bottom, left, right);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the padding on the different sides of the widget. The padding adds blank space to 
	 * the sides of the widget. For instance, this can be used to indent the child widget 
	 * towards the right by adding padding on the left.
	 * 
	 * @param top the padding at the top of the widget
	 * @param bottom the padding at the bottom of the widget
	 * @param left the padding at the left of the widget
	 * @param right the padding at the right of the widget
	 */
	public void setPadding(int top, int bottom, int left, int right) {
		lock.lock();
		try {
			gtk_alignment_set_padding(this.pointer, top, bottom, left, right);
		}
		finally {
			lock.unlock();
		}
	}

}
