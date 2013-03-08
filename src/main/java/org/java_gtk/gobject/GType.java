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

import java.util.TreeMap;

import org.java_gtk.NativeObject;
import org.java_gtk.gdk.Pixbuf;

public enum GType {

	INVALID("Invalid"),
	NONE("None"),
	INT("Int"),
	LONG("Long"),
	BOOLEAN("Bool"),
	FLOAT("Float"),
	DOUBLE("Double"), 
	STRING("String"),
	PIXBUF("Pixbuf"),
	GOBJECT("GObject");

	private static final native long get_type(String name);
	
	private GType(String name) {
		NativeObject.getLock().lock();
		try {
			this.value = (int)get_type(name);
		}
		finally {
			NativeObject.getLock().unlock();
		}
	}
	
	private long value;
	
	public long getValue() {
		return value;
	}

	// cache values in a map for lookups
	private static TreeMap<Long, GType> map;
	
	static {
		map = new TreeMap<Long, GType>();
		for (GType type: GType.values()) {
			map.put(new Long(type.value), type);
		}
	}
	
	public static GType lookup(long value) {
		return map.get(new Long(value));
	}

	public static GType lookup(Class<?> clazz) {
		if (clazz == String.class)
			return GType.STRING;
		if (clazz == Pixbuf.class)
			return GType.PIXBUF;
		if (clazz.isAssignableFrom(GObject.class))
			return GType.GOBJECT;
		if (clazz == Integer.class || clazz == int.class)
			return GType.INT;
		if (clazz == Long.class || clazz == long.class)
			return GType.LONG;
		if (clazz == Boolean.class || clazz == boolean.class)
			return GType.BOOLEAN;
		if (clazz == Float.class || clazz == float.class)
			return GType.FLOAT;
		if (clazz == Double.class || clazz == double.class)
			return GType.DOUBLE;
		return GType.INVALID;
	}
}
