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

package org.java_gtk.gobject;

import org.java_gtk.NativeObject;

/**
 *  
 * @author Bill Hull
 *
 */
public abstract class GObject extends NativeObject {

	private static native final void add_toggle_ref(long objectPointer, GObject me);
    private static native final void g_object_cleanup(long objectPointer);
	
	protected GObject(long pointer) {
		super(pointer, false, true);
		lock.lock();
		try {
			add_toggle_ref(pointer, this);
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void cleanup(long pointer) {
		NativeObject.cleanup(pointer);
		lock.lock();
		try {
			g_object_cleanup(pointer);
		}
		finally {
			lock.unlock();
		}
	}

}
