set JAVA_HOME="C:\Program Files\Java\jdk1.6.0_25"
%JAVA_HOME%\bin\javah.exe ^
	-classpath "target\classes" ^
	-d "src\main\c\include" ^
	org.java_gtk.gobject.GObject ^
	org.java_gtk.gtk.Gtk ^
	org.java_gtk.gtk.Widget ^
	org.java_gtk.gtk.Container ^
	org.java_gtk.gtk.Window ^
	org.java_gtk.gtk.Button ^
	org.java_gtk.gtk.Label
