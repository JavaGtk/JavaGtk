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

import org.java_gtk.gobject.GObject;
/**
 * The Adjustment object represents a value which has an associated 
 * lower and upper bound, together with step and page increments, 
 * and a page size. It is used within several GTK+ widgets.
 * 
 * @author Bill
 *
 */
public class Adjustment extends GObject {

	private static final native long gtk_adjustment_new(double value, double lower, double upper, double step_increment, double page_increment, double page_size);
	
	protected Adjustment(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new Adjustment.
	 * 
	 * @param value the initial value.
	 * @param lower the minimum value.
	 * @param upper the maximum value.
	 * @param step_increment the step increment.
	 * @param page_increment the page increment.
	 * @param page_size the page size.
	 */
	public Adjustment(double value, double lower, double upper, double step_increment, double page_increment, double page_size) {
		this(newAdjustment(value, lower, upper, step_increment, page_increment, page_size));
	}

	private static long newAdjustment(double value, double lower, double upper, double step_increment, double page_increment, double page_size) {
		lock.lock();
		try {
			return gtk_adjustment_new(value, lower, upper, step_increment, page_increment, page_size);
		}
		finally {
			lock.unlock();
		}
	}
	
}
