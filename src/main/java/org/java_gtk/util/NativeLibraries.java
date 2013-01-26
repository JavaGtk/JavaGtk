package org.java_gtk.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class NativeLibraries {
	
	public static void loadLibraries() {
		Properties props = new Properties();

		String gtkLibPath = "";
		String javaGtkLibPath = "";
		List<String> gtkLibraries = null;
		
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
				property = props.getProperty("GTKLibraries");
				if (property != null && !property.isEmpty())
					gtkLibraries = Arrays.asList(property.split(","));
			} catch (IOException e) {

			}
		}
		if (gtkLibraries != null && !gtkLibraries.isEmpty() && gtkLibPath != null && !gtkLibPath.isEmpty())
			loadGtk(gtkLibraries, gtkLibPath);
		System.load(javaGtkLibPath);
	}
	
	private static void loadGtk(List<String> libraries, String gtkLibPath) {
		for (String library: libraries) {
			System.load(gtkLibPath + library);
		}
	}
		
	private static String getAbsolutePath(String path) {
		File f = new File(path);
		return f.getAbsolutePath();
	}
}
