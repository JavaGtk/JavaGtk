package org.java_gtk.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NativeLibraries {
	
	public static void loadLibraries() {
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
