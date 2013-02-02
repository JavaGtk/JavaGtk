set JAVA_HOME="C:\Program Files\Java\jdk1.6.0_25"
%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\include" ^
	org.java_gtk.gtk.Gtk ^
	org.java_gtk.gtk.Widget ^
	org.java_gtk.gtk.Container ^
	org.java_gtk.gtk.Window ^
	org.java_gtk.gtk.Button ^
	org.java_gtk.gtk.Label ^
	org.java_gtk.gtk.Box ^
	org.java_gtk.gtk.Fixed ^
	org.java_gtk.gtk.MenuShell ^
	org.java_gtk.gtk.MenuBar ^
	org.java_gtk.gtk.Menu ^
	org.java_gtk.gtk.MenuItem ^
	org.java_gtk.gtk.ImageMenuItem ^
	org.java_gtk.gtk.CheckMenuItem ^
	org.java_gtk.gtk.SeparatorMenuItem ^
	org.java_gtk.gtk.AccelGroup ^
	org.java_gtk.gtk.AccelMap ^
	org.java_gtk.gtk.StatusBar ^
	org.java_gtk.gtk.Toolbar ^
	org.java_gtk.gtk.ToolItem ^
	org.java_gtk.gtk.ToolButton ^
	org.java_gtk.gtk.SeparatorToolItem ^
	org.java_gtk.gtk.Grid ^
	