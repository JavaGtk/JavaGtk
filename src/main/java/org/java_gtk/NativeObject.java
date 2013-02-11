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

package org.java_gtk;

import java.util.concurrent.locks.ReentrantLock;

import org.java_gtk.util.Finalization;
import org.java_gtk.util.ObjectCache;

/**
 * 
 * Base class for all objects in JavaGtk.  Contains lock and pointer properties.
 * <p>
 * lock is used to ensure that methods are not called from multiple threads
 * at the same time since GTK is not thread safe (however it is thread aware).
 * <p>
 * pointer is used to maintain a reference to the underlying GTK object.
 * 
 * @author Bill Hull
 *
 */
public abstract class NativeObject {
	
	protected final long pointer;
	
	protected static final ReentrantLock lock = new ReentrantLock(true);

	/**
	 * Create a new GObject with the specified address as its pointer.
	 * GObjects are cached in {@link org.java_gtk.util.ObjectCache ObjectCache} upon instantiation.
	 * 
	 * @param pointer address of c object
	 */
	protected NativeObject(long pointer) {
		this(pointer, false);
	}
	
	/**
	 * Create a new GObject with the specified address as its pointer.
	 * If the {@code isTransient} parameter is {@code false} the the
	 * GObject is cached in {@link org.java_gtk.util.ObjectCache ObjectCache} 
	 * upon instantiation.
	 * 
	 * @param pointer address of c object
	 * @param isTransient {@code true} if object will not be cached
	 */
	protected NativeObject(long pointer, boolean isTransient) {
		this.pointer = pointer;
		if (pointer != 0 && !isTransient) {
			ObjectCache.cache(this);
			Finalization.addFinalizer(this);
		}
	}

	public long getPointer() {
		return pointer;
	}

}