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
 * A container box
 * <p>
 * The Box widget organizes child widgets into a rectangular area.
 * <p>
 * The rectangular area of a Box is organized into either a single 
 * row or a single column of child widgets depending upon the orientation. 
 * Thus, all children of a Box are allocated one dimension in common, 
 * which is the height of a row, or the width of a column.
 * <p>
 * Box uses a notion of packing. Packing refers to adding widgets with 
 * reference to a particular position in a Container. For a Box, there are 
 * two reference positions: the start and the end of the box. For a vertical 
 * Box, the start is defined as the top of the box and the end is defined as
 * the bottom. For a horizontal Box the start is defined as the left side 
 * and the end is defined as the right side. 
 * 
 * @author Bill
 *
 */
public class Box extends Container {

	private static native final long gtk_box_new(int orientation, int spacing);
	private static native final void gtk_box_set_spacing(long boxPointer, int spacing);
	private static native final int gtk_box_get_spacing(long boxPointer);
	private static native final void gtk_box_pack_start(long boxPointer, long widgetPointer, boolean expand, boolean fill, int padding);
	private static native final void gtk_box_pack_end(long boxPointer, long widgetPointer, boolean expand, boolean fill, int padding);
	private static native final void gtk_box_set_homogeneous(long boxPointer, boolean homogeneous);
	private static native final boolean gtk_box_get_homogeneous(long boxPointer);

	protected Box(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new Box with the specified Orientation and spacing.
	 * 
	 * @param orientation the box's orientation.
	 * @param spacing the number of pixels to place by default between children.
	 */
	public Box(Orientation orientation, int spacing) {
		super(newBox(orientation, spacing));
	}

	private static long newBox(Orientation orientation, int spacing) {
		lock.lock();
		try {
			return gtk_box_new(orientation.getValue(), spacing);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the number of pixels to place between children.
	 * 
	 * @param spacing the number of pixels to put between children.
	 */
	public void setSpacing(int spacing) {
		lock.lock();
		try {
			gtk_box_set_spacing(this.pointer, spacing);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Gets the number of pixels to place between children.
	 * 
	 * @return spacing between children.
	 */
	public int getSpacing() {
		lock.lock();
		try {
			return gtk_box_get_spacing(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Adds a child widget to the box packed with reference to the start of box. 
	 * The child is packed after any other child packed with reference to the start of box.
	 * 
	 * @param child the Widget to be added to the box
	 * @param expand <code>true</code> if the new child is to be given extra space allocated to box. 
	 * The extra space will be divided evenly between all children that use this option
	 * @param fill <code>true</code> if space given to child by the expand option is actually allocated 
	 * to child, rather than just padding it. This parameter has no effect if expand is set to 
	 * <code>false</code>. A child is always allocated the full height of a horizontal Box and 
	 * the full width of a vertical Box. This option affects the other dimension.
	 * @param padding extra space in pixels to put between this child and its neighbors, over and 
	 * above the global amount specified by "spacing" property. If child is a widget at one of 
	 * the reference ends of box, then padding pixels are also put between child and the 
	 * reference edge of box
	 */
	public void packStart(Widget child, boolean expand, boolean fill, int padding) {
		lock.lock();
		try {
			gtk_box_pack_start(this.pointer, child.getPointer(), expand, fill, padding);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Adds a child widget to the box, packed with reference to the end of box. 
	 * The child is packed after (away from end of) any other child packed with 
	 * reference to the end of box.
	 *  
	 * @param child the Widget to be added to the box
	 * @param expand <code>true</code> if the new child is to be given extra space allocated to box. 
	 * The extra space will be divided evenly between all children that use this option
	 * @param fill <code>true</code> if space given to child by the expand option is actually allocated 
	 * to child, rather than just padding it. This parameter has no effect if expand is set to 
	 * <code>false</code>. A child is always allocated the full height of a horizontal Box and 
	 * the full width of a vertical Box. This option affects the other dimension.
	 * @param padding extra space in pixels to put between this child and its neighbors, over and 
	 * above the global amount specified by "spacing" property. If child is a widget at one of 
	 * the reference ends of box, then padding pixels are also put between child and the 
	 * reference edge of box
	 */
	public void packEnd(Widget child, boolean expand, boolean fill, int padding) {
		lock.lock();
		try {
			gtk_box_pack_end(this.pointer, child.getPointer(), expand, fill, padding);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setHomogeneous(boolean homogeneous) {
		lock.lock();
		try {
			gtk_box_set_homogeneous(this.pointer, homogeneous);
		}
		finally {
			lock.unlock();
		}
	}
	
	public boolean isHomogeneous() {
		lock.lock();
		try {
			return gtk_box_get_homogeneous(this.pointer);
		}
		finally {
			lock.unlock();
		}
		
	}
}
