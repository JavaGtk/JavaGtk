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

import java.lang.ref.WeakReference;
import java.util.HashMap;

import org.java_gtk.gobject.GObject;

/**
 * 
 * @author Bill
 *
 */
public class ObjectCache {

	private static final HashMap<Long, WeakReference<GObject>> objects = new HashMap<Long, WeakReference<GObject>>();
	
	public static GObject lookup(long id) {
		if (!objects.containsKey(id)) {
			return null;
		}
		GObject val = objects.get(id).get();
		if (val == null) {
			objects.remove(id);
		}
		return val;
	}
	
	public static void cache(GObject object) {
		if (!objects.containsKey(object.getPointer())) {
			objects.put(object.getPointer(), new WeakReference<GObject>(object));
		}
	}
	
	public static void remove(GObject object) {
		objects.remove(object.getPointer());
	}
}
