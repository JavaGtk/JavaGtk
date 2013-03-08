package org.java_gtk.examples;

import org.java_gtk.gdk.Pixbuf;
import org.java_gtk.gdk.PixbufError;
import org.java_gtk.glib.GError;
import org.java_gtk.glib.GFileError;
import org.java_gtk.gtk.Frame.ShadowType;
import org.java_gtk.gtk.IconView;
import org.java_gtk.gtk.ListStore;
import org.java_gtk.gtk.ScrolledWindow;
import org.java_gtk.gtk.ScrolledWindow.PolicyType;
import org.java_gtk.gtk.SelectionMode;
import org.java_gtk.gtk.TreeIterator;
import org.java_gtk.gtk.TreeModel;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleIconView extends ExampleBase {

	public static void main(String[] args) {
		new ExampleIconView().runExample(args, "IconView Example", 550, 330, 10);
	}

	@Override
	protected void setupExample() {
		ScrolledWindow sw = new ScrolledWindow(null, null);
		mainWin.add(sw);
		sw.setPolicy(PolicyType.AUTOMATIC, PolicyType.AUTOMATIC);
		sw.setShadowType(ShadowType.IN);
		
		IconView iconView;
		try {
			iconView = new IconView(initModel());
			sw.add(iconView);
			
			iconView.setTextColumn(0);
			iconView.setPixbufColumn(1);
			iconView.setSelectionMode(SelectionMode.MULTIPLE);
		} catch (GError e) {
			logger.error("Example Error:", e);
		}
		
	}

	public TreeModel initModel() throws PixbufError, GFileError {
		Pixbuf pic1, pic2, pic3, pic4;
		ListStore ls = null;
		pic1 = new Pixbuf("bin/apple-red.png");
		pic2 = new Pixbuf("bin/gnome-gsame.png");
		pic3 = new Pixbuf("bin/gnome-gmush.png");
		pic4 = new Pixbuf("bin/gnome-calendar.png");
	
		ls = new ListStore(String.class, Pixbuf.class);
		TreeIterator iter = new TreeIterator();
		for (int i = 0; i < 50; i++) {
			ls.append(iter);
			ls.set(iter, 0, "Apple");
			ls.set(iter, 1, pic1);
			ls.append(iter);
			ls.set(iter, 0, "Planets");
			ls.set(iter, 1, pic2);
			ls.append(iter);
			ls.set(iter, 0, "Mushroom");
			ls.set(iter, 1, pic3);
			ls.append(iter);
			ls.set(iter, 0, "Calendar");
			ls.set(iter, 1, pic4);
		}
			
		return ls;
	}
}
