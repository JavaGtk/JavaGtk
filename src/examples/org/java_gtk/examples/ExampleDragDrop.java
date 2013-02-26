package org.java_gtk.examples;

import java.util.EnumSet;

import org.java_gtk.gdk.EventButton;
import org.java_gtk.gdk.EventMasks;
import org.java_gtk.gdk.EventType;
import org.java_gtk.gtk.Widget;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkevents/
 * 
 * @author Bill
 *
 */
public class ExampleDragDrop extends ExampleBase {

	public static void main(String[] args) {
		new ExampleDragDrop().runExample(args, "Drag and Drop Example", 230, 150, 0);
	}

	@Override
	protected void setupExample() {
		mainWin.setDecorated(false);
		mainWin.addEvents(EnumSet.of(EventMasks.BUTTON_PRESS_MASK));
		
		mainWin.addButtonPressHandler(new Widget.ButtonPressEventHandler() {
			public boolean handle(Widget source, EventButton event) {
				if (event.getEventType() == EventType.BUTTON_PRESS) {
					if (event.getButton() == 1) {
						int x,y;
						x = Double.valueOf(event.getXroot()).intValue();
						y = Double.valueOf(event.getYroot()).intValue();
						mainWin.beginMoveDrag(event.getButton(), x, y, event.getTime());
					}
				}
				return false;
			}
		});
	}

}
