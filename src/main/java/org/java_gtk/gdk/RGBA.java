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

package org.java_gtk.gdk;

import org.java_gtk.NativeObject;

/**
 * RGBA is used to represent a (possibly translucent) color, 
 * in a way that is compatible with cairo's notion of color.
 *  
 * @author Bill
 *
 */
public class RGBA extends NativeObject {
	
	private static native final long gdk_rgba_new(double red, double green, double blue, double alpha);
	private static native final void gdk_rgba_free(long rgbaPointer);

	protected RGBA(long pointer) {
		super(pointer, true, true);
	}
	
	/**
	 * Construct a new RGBA color
	 * 
	 * @param red The intensity of the red channel from 0.0 to 1.0 inclusive
	 * @param green The intensity of the green channel from 0.0 to 1.0 inclusive
	 * @param blue The intensity of the blue channel from 0.0 to 1.0 inclusive
	 * @param alpha The opacity of the color from 0.0 for completely translucent to 1.0 for opaque
	 */
	public RGBA(double red, double green, double blue, double alpha) {
		this(newRGBA(red, green, blue, alpha));
	}
	
	private static long newRGBA(double red, double green, double blue, double alpha) {
		lock.lock();
		try {
			return gdk_rgba_new(red, green, blue, alpha);
		}
		finally {
			lock.unlock();
		}
	}

	public static void cleanup(long pointer) {
		lock.lock();
		try {
			gdk_rgba_free(pointer);
		}
		finally {
			lock.unlock();
		}
	}
}
