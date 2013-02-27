set JAVA_HOME="C:\Program Files\Java\jdk1.6.0_25"
%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\gtk\include" ^
	org.java_gtk.gtk.Gtk ^
	org.java_gtk.gtk.Widget ^
	org.java_gtk.gtk.Container ^
	org.java_gtk.gtk.Window ^
	org.java_gtk.gtk.Button ^
	org.java_gtk.gtk.ToggleButton ^
	org.java_gtk.gtk.CheckButton ^
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
	org.java_gtk.gtk.Alignment ^
	org.java_gtk.gtk.DrawingArea ^
	org.java_gtk.gtk.TextView ^
	org.java_gtk.gtk.Dialog ^
	org.java_gtk.gtk.MessageDialog ^
	org.java_gtk.gtk.AboutDialog ^
	org.java_gtk.gtk.Frame ^
	org.java_gtk.gtk.ComboBox ^
	org.java_gtk.gtk.ComboBoxText ^
	org.java_gtk.gtk.Separator ^
	org.java_gtk.gtk.Entry

%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\gdk\include" ^
	org.java_gtk.gdk.Pixbuf ^
	org.java_gtk.gdk.Event ^
	org.java_gtk.gdk.EventButton ^
	org.java_gtk.gdk.EventConfigure ^
	org.java_gtk.gdk.RGBA

	%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\gobject\include" ^
	org.java_gtk.gobject.GObject
	
%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\glib\include" ^
	org.java_gtk.glib.Timer
	
%JAVA_HOME%\bin\javah.exe ^
	-classpath "bin" ^
	-d "src\main\c\cairo\include" ^
	org.java_gtk.cairo.CairoContext