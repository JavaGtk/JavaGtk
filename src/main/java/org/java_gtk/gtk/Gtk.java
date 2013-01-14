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

/**
 * 
 * @author Bill
 *
 */
public class Gtk {
	
	private static native final void gtk_init(java.lang.Object argc, String[] argv);
    private static native final void gtk_main();
    private static native final void gtk_main_quit();
	
	static {
		System.loadLibrary("libintl-8");
		System.loadLibrary("zlib1");
		System.loadLibrary("libexpat-1");
		System.loadLibrary("libpng14-14");
		System.loadLibrary("libfreetype-6");
		System.loadLibrary("libfontconfig-1");
		System.loadLibrary("libglib-2.0-0");
		System.loadLibrary("libgmodule-2.0-0");
		System.loadLibrary("libgthread-2.0-0");
		System.loadLibrary("libgobject-2.0-0");
		System.loadLibrary("libpango-1.0-0");
		System.loadLibrary("libpangowin32-1.0-0");
		System.loadLibrary("libcairo-2");
		System.loadLibrary("libatk-1.0-0");
		System.loadLibrary("libpangoft2-1.0-0");
		System.loadLibrary("libpangocairo-1.0-0");
		System.loadLibrary("libgio-2.0-0");
		System.loadLibrary("libgdk_pixbuf-2.0-0");
		System.loadLibrary("libgdk-win32-2.0-0");
		System.loadLibrary("libgtk-win32-2.0-0");
		System.loadLibrary("libjava-gtk");
	}

	private Gtk() {}
	
	public static void init(String[] argv) {
		gtk_init(argv.length, argv);
	}

    public static void main() {
    	gtk_main();
    }
    
	public static void mainQuit() {
		gtk_main_quit();
	}

}
