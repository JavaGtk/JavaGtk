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
import org.java_gtk.glib.GFileError;

/**
 * Pixbuf contains information that describes an image in memory. 
 * 
 * @author Bill
 *
 */
public class Pixbuf extends NativeObject {

	private static native final long gdk_pixbuf_new_from_file(String filename) throws PixbufError, GFileError;
	
	protected Pixbuf(long pointer) {
		super(pointer);
	}
	
	/**
	 * Creates a new {@code Pixbuf} by loading an image from a file. The file 
	 * format is detected automatically.
	 * 
	 * @param filename Name of file to load
	 * @throws PixbufError
	 * @throws GFileError
	 */
	public Pixbuf(String filename) throws PixbufError, GFileError {
		super(newPixBuf(filename));
	}
	
	private static long newPixBuf(String filename) throws PixbufError, GFileError {
		lock.lock();
		try {
			return gdk_pixbuf_new_from_file(filename);
		}
		finally {
			lock.unlock();
		}
	}

}
