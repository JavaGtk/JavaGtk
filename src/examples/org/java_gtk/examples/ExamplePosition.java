package org.java_gtk.examples;

import org.java_gtk.gdk.EventConfigure;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Widget.ConfigureEventHandler;
import org.java_gtk.gtk.Window;

public class ExamplePosition extends ExampleBase {

	public static void main(String[] args) {
		new ExamplePosition().runExample(args, "Window Position Example", 230, 150, 15);
	}

	@Override
	protected void setupExample() {
		mainWin.addConfigureHandler(new ConfigureEventHandler() {
			public boolean handle(Widget source, EventConfigure event) {
				((Window)source).setTitle(event.getX() + ", " + event.getY());
				return false;
			}
		});
	}

}
