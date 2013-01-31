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
 * An AccelGroup represents a group of keyboard accelerators, typically 
 * attached to a toplevel Window
 * 
 * @author Bill
 *
 */
public class AccelGroup extends GObject {

	private static native final long gtk_accel_group_new();

	protected AccelGroup(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs an AccelGroup.
	 */
	public AccelGroup() {
		super(newAccelGroup());
	}
	
	private static long newAccelGroup() {
		lock.lock();
		try {
			return gtk_accel_group_new();
		}
		finally {
			lock.unlock();
		}
	}
	

}
