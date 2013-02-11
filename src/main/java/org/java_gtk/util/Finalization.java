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

package org.java_gtk.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

import org.java_gtk.NativeObject;
import org.java_gtk.gobject.GObject;
import org.java_gtk.gtk.Gtk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles object finalization using PhantomReference.
 * 
 * @author Bill
 *
 */
public class Finalization {
	
	private static final List<PhantomReference<NativeObject>> phantomReferences = new LinkedList<PhantomReference<NativeObject>>();
	private static final ReferenceQueue<NativeObject> queue = new ReferenceQueue<NativeObject>();
	
	private static final Logger logger = LoggerFactory.getLogger(Finalization.class);

	/**
	 * Holds a reference to the object pointer that can be used after the 
	 * object has been finalized on the Java side.
	 * 
	 * @author Bill
	 *
	 */
	static class Finalizer extends PhantomReference<NativeObject> {

		private long pointer;
		
		public Finalizer(NativeObject referent) {
			super(referent, queue);
			this.pointer = referent.getPointer();
		}
		
		public void cleanup() {
			Gtk.cleanup(pointer);
		}
		
	}

	public static void addFinalizer(NativeObject object) {
		phantomReferences.add(new Finalizer(object));
	}
	
	/**
	 * Start a background thread that waits for a PhantomReference then 
	 * perform cleanup operations.
	 * 
	 */
	public static void setupFinalizer() {
		Thread referenceThread = new Thread() {
			public void run() {
				while (true) {
					try {
						Finalizer ref = (Finalizer)queue.remove();
						logger.debug("Finalizing: {}", ref.pointer);
						ref.cleanup();
						phantomReferences.remove(ref);
					} catch (Exception ex) {
						logger.error("Finalization error");
					}
				}
			}
		};
		referenceThread.setDaemon(true);
		referenceThread.start();
	}

}
