package org.java_gtk.gtk;

import java.util.EnumSet;

import org.java_gtk.gdk.ModifierType;
import org.java_gtk.gobject.GObject;

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
