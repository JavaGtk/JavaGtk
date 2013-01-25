package org.java_gtk.examples;

import org.java_gtk.gdk.Event;
import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Window;

public class ExampleButtons {
	
	public static void main(String[] args) {
		Gtk.init(args);
		Window mainWin = new Window();
		mainWin.addDeleteHandler(new Widget.DeleteEventHandler() {
			public boolean handle(Widget source, Event event) {
				Gtk.mainQuit();
				return false;
			}
		});
		mainWin.setTitle("Hello World!");
		mainWin.setBorderWidth(10);
		
		Box box = new Box(Orientation.HORIZONTAL, 10);
		mainWin.add(box);
		
		Button b1 = new Button("This is a button.\nClick me to close.");
		b1.addClickedHandler(new Button.ClickedEventHandler() {
			public boolean handle(Button source) {
				Gtk.mainQuit();
				return false;
			}
		});
		box.add(b1);
		
		Button b2 = new Button("This is another button.\nClick me to see something special.");
		b2.addClickedHandler(new Button.ClickedEventHandler() {
			public boolean handle(Button source) {
				source.setLabel("You clicked me!!\nThat was special.");
				return false;
			}
		});
		box.add(b2);
		
		mainWin.showAll();
		Gtk.main();
	}

}
