package org.java_gtk.examples;

import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Button.ClickedEventHandler;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Fixed;
import org.java_gtk.gtk.StatusBar;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleStatusBar extends ExampleBase {

	public static void main(String[] args) {
		new ExampleStatusBar().runExample(args, "StatusBar Example", 280, 150, 15);
	}

	@Override
	protected void setupExample() {
		Box box = new Box(Orientation.VERTICAL, 2);
		Fixed fixed = new Fixed();
		mainWin.add(box);
		box.packStart(fixed, true, true, 1);
		
		Button button1 = new Button("OK");
		button1.setMinimumSize(80, 30);
		Button button2 = new Button("Apply");
		button2.setMinimumSize(80, 30);
		
		fixed.add(button1, 50, 50);
		fixed.add(button2, 150, 50);
		
		final StatusBar statusbar = new StatusBar();
		box.packStart(statusbar, false, true, 1);
		
		button1.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				String s = "Button " + source.getLabel() + " clicked";
				statusbar.push(statusbar.getContextId(s), s);
			}			
		});
		
		button2.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				String s = "Button " + source.getLabel() + " clicked";
				statusbar.push(statusbar.getContextId(s), s);
			}			
		});
	}

}
