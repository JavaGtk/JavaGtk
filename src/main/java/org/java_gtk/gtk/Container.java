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
 * 
 * @author Bill
 *
 */
public class Container extends Widget {
	
	private static native final void gtk_container_add(long container_id, long widget_id);
	private static native final void gtk_container_set_border_width(long container_id, int border_width);
	private static native final int gtk_container_get_border_width(long container_id);

	protected Container(long pointer) {
		super(pointer);
	}
	
	public void add(Widget widget) {
		gtk_container_add(this.pointer, widget.getPointer());
	}
	
	public void setBorderWidth(int width) {
		gtk_container_set_border_width(this.pointer, width);
	}

	public int getBorderWidth() {
		return gtk_container_get_border_width(this.pointer);
	}
}
