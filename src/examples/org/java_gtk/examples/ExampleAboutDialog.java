package org.java_gtk.examples;

import org.java_gtk.gdk.EventButton;
import org.java_gtk.gdk.Pixbuf;
import org.java_gtk.gtk.AboutDialog;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Widget.ButtonPressEventHandler;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkdialogs/
 * 
 * @author Bill
 *
 */
public class ExampleAboutDialog extends ExampleBase {

	public static void main(String[] args) {
		new ExampleAboutDialog().runExample(args, "About Dialog Example", 220, 150, 15);
	}

	@Override
	protected void setupExample() {
		try {
			final Pixbuf icon = new Pixbuf("bin/gnome-gsame.png");
			mainWin.addButtonPressHandler(new ButtonPressEventHandler() {
				@Override
				public boolean handle(Widget source, EventButton event) {
					AboutDialog dialog = new AboutDialog();
					dialog.setName("Example About Dialog");
					dialog.setVersion("1.0.0");
					dialog.setCopyright("Copyright 2013 JavaGtk");
					dialog.setComments("This is an example of an AboutDialog");
					dialog.setWebsite("https://github.com/JavaGtk/JavaGtk");
					dialog.setLogo(icon);
					dialog.run();
					dialog.destroy();
					return true;
				}
			});
		}
		catch (Exception ex) {
			
		}
	}

}
