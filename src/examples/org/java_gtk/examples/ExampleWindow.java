package org.java_gtk.examples;

import org.java_gtk.gdk.Event;
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Window;

public class ExampleWindow {

	public static void main(String[] args) {
		Gtk.init(args);
		Window mainWin = new Window();
		mainWin.addDeleteHandler(new Widget.DeleteEventHandler() {
			public boolean handle(Widget source, Event event) {
				Gtk.mainQuit();
				return false;
			}
		});
		mainWin.setTitle("Example Window");
				
		mainWin.showAll();
		Gtk.main();

	}
}
