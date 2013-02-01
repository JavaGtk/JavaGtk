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
 * Create bars of buttons and other widgets
 * 
 * @author Bill
 *
 */
public class Toolbar extends Container {

	private static native final long gtk_toolbar_new();
	private static native final void gtk_toolbar_set_style(long toolbarPointer, int style);
	private static native final void gtk_toolbar_insert(long toolbarPointer, long toolItemPointer, int pos);

	public enum ToolbarStyle {
		ICONS(0),
		TEXT(1),
		BOTH(2),
		BOTH_HORIZ(3);
		
		private ToolbarStyle(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	protected Toolbar(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new toolbar.
	 */
	public Toolbar () {
		this(newToolbar());
	}
		
	private static long newToolbar() {
		lock.lock();
		try {
			return gtk_toolbar_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setStyle(ToolbarStyle style) {
		lock.lock();
		try {
			gtk_toolbar_set_style(this.pointer, style.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	public void insert(ToolItem item, int pos) {
		lock.lock();
		try {
			gtk_toolbar_insert(this.pointer, item.getPointer(), pos);
		}
		finally {
			lock.unlock();
		}
	}

}
