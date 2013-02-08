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

import java.util.EnumSet;

import org.java_gtk.gdk.ModifierType;
import org.java_gtk.gobject.GObject;

/**
 * Accelerator maps are used to define runtime configurable accelerators.
 * All accelerators are stored inside one global AccelMap.
 * 
 * @author Bill
 *
 */
public class AccelMap extends GObject {

	private static native final void gtk_accel_map_add_entry(String path, int key, int modType);
	
	protected AccelMap(long pointer) {
		super(0);
	}

	/**
	 * Registers a new accelerator with the global accelerator map. This function 
	 * should only be called once per <code>path</code> with the canonical 
	 * <code>key</code> and <code>modType</code> for this path.
	 * 
	 * Set <code>key</code> and <code>modType</code> to 0 to request a removal 
	 * of the accelerator. 
	 * 
	 * @param path valid accelerator path.
	 * @param key the accelerator key.
	 * @param modType the accelerator modifiers.
	 */
	public static void addEntry(String path, int key, EnumSet<ModifierType> modType) {
		int value = 0;
		for (ModifierType mtype: modType) {
			value += mtype.getValue();
		}
		
		lock.lock();
		try {
			gtk_accel_map_add_entry(path, key, value);
		}
		finally {
			lock.unlock();
		}
	}
}
