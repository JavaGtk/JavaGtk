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
import org.java_gtk.util.NativeLibraries;

/**
 * 
 * @author Bill Hull
 *
 */
public class Gtk extends GObject {
	
	private static native final void gtk_init(Object argc, String[] argv);
	private static native final void gtk_main();
	private static native final boolean gtk_main_iteration_do(boolean blocking);
	private static native final boolean gtk_events_pending();
	private static native final void gtk_main_quit();
	    
	static {
		NativeLibraries.loadLibraries();
	}

	private Gtk() {
		super(0);
	}
	
	public static void init(String[] argv) {
		lock.lock();
		try {
			gtk_init(argv.length, argv);
		}
		finally {
			lock.unlock();
		}
	}

	public static void main() {
		lock.lock();
		try {
		   	gtk_main();
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void mainIteration(boolean blocking) {
		lock.lock();
		try {
		   	gtk_main_iteration_do(blocking);
		}
		finally {
			lock.unlock();
		}
	}
	
	public static boolean hasEventsPending() {
		lock.lock();
		try {
		   	return gtk_events_pending();
		}
		finally {
			lock.unlock();
		}
	}

	public static void mainQuit() {
		lock.lock();
		try {
			gtk_main_quit();
		}
		finally {
			lock.unlock();
		}
	}

}
