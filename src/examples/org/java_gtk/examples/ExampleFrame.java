package org.java_gtk.examples;

import org.java_gtk.gtk.Frame;
import org.java_gtk.gtk.Frame.ShadowType;
import org.java_gtk.gtk.Grid;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgets/
 * 
 * @author Bill
 *
 */
public class ExampleFrame extends ExampleBase {

	public static void main(String[] args) {
		new ExampleFrame().runExample(args, "Frame Example", 250, 250, 10);
	}

	@Override
	protected void setupExample() {
		Grid grid = new Grid();
		grid.setColumnSpacing(2);
		grid.setRowSpacing(2);
		grid.setColumnHomogeneous(true);
		grid.setRowHomogeneous(true);

		Frame frame1 = new Frame();
		frame1.setShadowType(ShadowType.IN);
		Frame frame2 = new Frame("Shadow Out");
		frame2.setShadowType(ShadowType.OUT);
		Frame frame3 = new Frame("Shadow Etched In");
		frame3.setShadowType(ShadowType.ETCHED_IN);
		Frame frame4 = new Frame("Shadow Etched Out");
		frame4.setShadowType(ShadowType.ETCHED_OUT);
		
		grid.attach(frame1, 0, 0, 1, 1);
		grid.attach(frame2, 0, 1, 1, 1);
		grid.attach(frame3, 1, 0, 1, 1);
		grid.attach(frame4, 1, 1, 1, 1);

		mainWin.add(grid);
	}

}
