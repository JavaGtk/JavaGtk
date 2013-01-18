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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
		loadLibraries();
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
	
	private static void loadLibraries() {
	    Properties props = new Properties();
		String gtkLibPath = System.getProperty("java.library.path");
		String javaGtkLibPath = System.getProperty("java.library.path");
		String libraryExtension = ".dll";
		
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
		if (in != null) {
			try {
				props.load(in);
				String property = props.getProperty("GTKLibraryPath");
				if (property != null)
					gtkLibPath = getAbsolutePath(property) + File.separator;
				property = props.getProperty("JavaGtkLibraryPath");
				if (property != null)
					javaGtkLibPath = getAbsolutePath(property) + File.separator;
				property = props.getProperty("LibraryExtension");
				if (property != null)
					libraryExtension = "." + property;
			} catch (IOException e) {

			}
		}
		System.load(gtkLibPath + "libintl-8" + libraryExtension);
		System.load(gtkLibPath + "zlib1" + libraryExtension);
		System.load(gtkLibPath + "libexpat-1" + libraryExtension);
		System.load(gtkLibPath + "libpng14-14" + libraryExtension);
		System.load(gtkLibPath + "libfreetype-6" + libraryExtension);
		System.load(gtkLibPath + "libfontconfig-1" + libraryExtension);
		System.load(gtkLibPath + "libglib-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgmodule-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgthread-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgobject-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libpango-1.0-0" + libraryExtension);
		System.load(gtkLibPath + "libpangowin32-1.0-0" + libraryExtension);
		System.load(gtkLibPath + "libcairo-2" + libraryExtension);
		System.load(gtkLibPath + "libatk-1.0-0" + libraryExtension);
		System.load(gtkLibPath + "libpangoft2-1.0-0" + libraryExtension);
		System.load(gtkLibPath + "libpangocairo-1.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgio-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgdk_pixbuf-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgdk-win32-2.0-0" + libraryExtension);
		System.load(gtkLibPath + "libgtk-win32-2.0-0" + libraryExtension);
		System.load(javaGtkLibPath + "libjava-gtk" + libraryExtension);
	}
	
	private static String getAbsolutePath(String path) {
		File f = new File(path);
		return f.getAbsolutePath();
	}

}
