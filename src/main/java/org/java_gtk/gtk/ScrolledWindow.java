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

import org.java_gtk.gtk.Frame.ShadowType;

/**
 * ScrolledWindow adds scrollbars to the child widget and 
 * optionally draws a beveled frame around the child widget.
 * 
 * @author Bill
 *
 */
public class ScrolledWindow extends Bin {

	private static native final long gtk_scrolled_window_new(long hadjustmentPointer, long vadjustmentPointer);
	private static native final void gtk_scrolled_window_set_policy(long swPointer, int hPolicy, int vPolicy);
	private static native final void gtk_scrolled_window_set_shadow_type(long swPointer, int shadowType);

	/**
	 * Determines when a scroll bar will be visible.
	 * 
	 */
	public enum PolicyType {
		ALWAYS(0),
		AUTOMATIC(1),
		NEVER(3);
		
		private PolicyType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}

	protected ScrolledWindow(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new ScrolledWindow
	 * 
	 * @param hadjustment horizontal adjustment.
	 * @param vadjustment vertical adjustment.
	 */
	public ScrolledWindow (Adjustment hadjustment, Adjustment vadjustment) {
		this(newScrolledWindow(hadjustment, vadjustment));
	}
		
	private static long newScrolledWindow(Adjustment hadjustment, Adjustment vadjustment) {
		lock.lock();
		try {
			return gtk_scrolled_window_new(hadjustment.getPointer(), vadjustment.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the scrollbar policy for the horizontal and vertical scrollbars.
	 * 
	 * @param hpolicy policy for horizontal bar
	 * @param vpolicy policy for vertical bar
	 */
	public void setPolicy(PolicyType hpolicy, PolicyType vpolicy) {
		lock.lock();
		try {
			gtk_scrolled_window_set_policy(this.pointer, hpolicy.getValue(), vpolicy.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Changes the type of shadow drawn around the contents of ScrolledWindow.
	 * 
	 * @param type kind of shadow to draw around scrolled window contents
	 */
	public void setShadowType(ShadowType type) {
		lock.lock();
		try {
			gtk_scrolled_window_set_shadow_type(this.pointer, type.getValue());
		}
		finally {
			lock.unlock();
		}
	}

}
