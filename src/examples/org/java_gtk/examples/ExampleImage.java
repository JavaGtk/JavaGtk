package org.java_gtk.examples;

import org.java_gtk.gtk.Image;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleImage extends ExampleBase {

	public static void main(String[] args) {
		new ExampleImage().runExample(args, "Image Example", 230, 150, 2);
	}

	@Override
	protected void setupExample() {
		Image image = new Image("bin/gnome-gsame.png");
		mainWin.add(image);
	}

}
