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
 * Utility methods for library initialization, main event loop and events.
 * 
 * @author Bill Hull
 *
 */
public class Gtk extends GObject {
	
	private static native final void gtk_init(Object argc, String[] argv);
	private static native final boolean gtk_init_check(Object argc, String[] argv);
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
	
	/**
	 * Call this function before using any other JavaGTK functions in your GUI applications. 
	 * It will initialize everything needed to operate the toolkit and parses some 
	 * standard command line options.
	 * 
	 * This function will terminate if it was unable to initialize the windowing system 
	 * for some reason. If you want your program to indicate success you want to call 
	 * <code>{@link initCheck}</code> instead.
	 *  
	 * @param argv command line arguments
	 */
	public static void init(String[] argv) {
		lock.lock();
		try {
			gtk_init(argv.length, argv);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * This function does the same work as <code>{@link init}</code> with only a single change: 
	 * It does not terminate the program if the windowing system can't be initialized. Instead it 
	 * returns <code>false</code> on failure.
	 *  
	 * @param argv command line arguments
	 * @return <code>true</code> if the windowing system has been successfully initialized, 
	 * <code>false</code> otherwise
	 */
	public static boolean initCheck(String[] argv) {
		lock.lock();
		try {
			return gtk_init_check(argv.length, argv);
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
	
	/**
	 * Runs a single iteration of the mainloop. If no events are available either 
	 * return or block depending on the value of blocking
	 * 
	 * @param blocking <code>true</code> if you want JavaGTK to block if no events are pending
	 */
	public static void mainIteration(boolean blocking) {
		lock.lock();
		try {
		   	gtk_main_iteration_do(blocking);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Checks if any events are pending.
	 * 
	 * @return <code>true</code> if any events are pending, <code>false</code> otherwise
	 */
	public static boolean hasEventsPending() {
		lock.lock();
		try {
		   	return gtk_events_pending();
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Makes the innermost invocation of the main loop return when it regains control. 
	 */
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
