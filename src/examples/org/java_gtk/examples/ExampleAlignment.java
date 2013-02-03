package org.java_gtk.examples;

import org.java_gtk.gtk.Alignment;
import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Container.Orientation;

public class ExampleAlignment extends ExampleBase {

	public static void main(String[] args) {
		new ExampleAlignment().runExample(args, "Alignment Example", 350, 200, 10);
	}

	@Override
	protected void setupExample() {
		
		Box vbox = new Box(Orientation.VERTICAL, 5);
		vbox.setHomogeneous(false);
		
		Alignment valign = new Alignment(1, 1, 0, 0);
		vbox.packStart(valign, true, true, 0);
		mainWin.add(vbox);
		
		Box hbox = new Box(Orientation.HORIZONTAL, 3);
		hbox.setHomogeneous(true);
		
		Button ok = new Button("OK");
		ok.setMinimumSize(70, 30);
		hbox.add(ok);
		
		Button close = new Button("Close");
		hbox.add(close);
		
		Alignment halign = new Alignment(1, 0, 0, 0);
		halign.add(hbox);
		valign.add(halign);
	}

}
