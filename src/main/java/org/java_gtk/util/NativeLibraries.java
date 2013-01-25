package org.java_gtk.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NativeLibraries {
	
	public static void loadLibraries() {
		Properties props = new Properties();

		String gtkLibPath = "";
		String javaGtkLibPath = "";
		String libraryExtension = ".dll";
		
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
		if (in != null) {
			try {
				props.load(in);
				String property = props.getProperty("GTKLibraryPath");
				if (property != null && !property.isEmpty())
					gtkLibPath = getAbsolutePath(property) + File.separator;
				property = props.getProperty("JavaGtkLibraryPath");
				if (property != null && !property.isEmpty())
					javaGtkLibPath = getAbsolutePath(property) + File.separator;
				property = props.getProperty("LibraryExtension");
				if (property != null && !property.isEmpty())
					libraryExtension = "." + property;
			} catch (IOException e) {

			}
		}
		if (gtkLibPath == null || gtkLibPath.isEmpty())
			loadGtkFromSystem();
		else
			loadGtkFromConfig(gtkLibPath, libraryExtension);
		System.load(javaGtkLibPath + "libjava-gtk" + libraryExtension);
	}
	
	private static void loadGtkFromConfig(String gtkLibPath, String libExtension) {
		System.load(gtkLibPath + "libintl-8" + libExtension);
		System.load(gtkLibPath + "zlib1" + libExtension);
		System.load(gtkLibPath + "libffi-6" + libExtension);
		System.load(gtkLibPath + "libglib-2.0-0" + libExtension);
		System.load(gtkLibPath + "libgmodule-2.0-0" + libExtension);
		System.load(gtkLibPath + "libgthread-2.0-0" + libExtension);
		System.load(gtkLibPath + "libgobject-2.0-0" + libExtension);
		System.load(gtkLibPath + "libgio-2.0-0" + libExtension);
		System.load(gtkLibPath + "libatk-1.0-0" + libExtension);
//		System.load(gtkLibPath + "libexpat-1" + libExtension);
		System.load(gtkLibPath + "libpng15-15" + libExtension);
//		System.load(gtkLibPath + "libfreetype-6" + libExtension);
//		System.load(gtkLibPath + "libfontconfig-1" + libExtension);
		System.load(gtkLibPath + "libpango-1.0-0" + libExtension);
		System.load(gtkLibPath + "libpangowin32-1.0-0" + libExtension);
		System.load(gtkLibPath + "libpixman-1-0" + libExtension);
		System.load(gtkLibPath + "libcairo-2" + libExtension);
		System.load(gtkLibPath + "libcairo-gobject-2" + libExtension);
//		System.load(gtkLibPath + "libpangoft2-1.0-0" + libExtension);
		System.load(gtkLibPath + "libpangocairo-1.0-0" + libExtension);
		System.load(gtkLibPath + "libgdk_pixbuf-2.0-0" + libExtension);
		System.load(gtkLibPath + "libgdk-3-0" + libExtension);
		System.load(gtkLibPath + "libgtk-3-0" + libExtension);
	}
	
	private static void loadGtkFromSystem() {
		System.loadLibrary("intl-8");
		System.loadLibrary("zlib1");
		System.loadLibrary("expat-1");
		System.loadLibrary("png14-14");
		System.loadLibrary("freetype-6");
		System.loadLibrary("fontconfig-1");
		System.loadLibrary("glib-2.0-0");
		System.loadLibrary("gmodule-2.0-0");
		System.loadLibrary("gthread-2.0-0");
		System.loadLibrary("gobject-2.0-0");
		System.loadLibrary("pango-1.0-0");
		System.loadLibrary("pangowin32-1.0-0");
		System.loadLibrary("cairo-2");
		System.loadLibrary("atk-1.0-0");
		System.loadLibrary("pangoft2-1.0-0");
		System.loadLibrary("pangocairo-1.0-0");
		System.loadLibrary("gio-2.0-0");
		System.loadLibrary("gdk_pixbuf-2.0-0");
		System.loadLibrary("gdk-win32-2.0-0");
		System.loadLibrary("gtk-win32-2.0-0");
	}
	
	private static String getAbsolutePath(String path) {
		File f = new File(path);
		return f.getAbsolutePath();
	}
}
