package org.java_gtk.examples;

import org.java_gtk.gtk.Entry;
import org.java_gtk.gtk.Grid;
import org.java_gtk.gtk.Label;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleEntry extends ExampleBase {

	public static void main(String[] args) {
		new ExampleEntry().runExample(args, "Entry Example", 200, 100, 10);
	}

	@Override
	protected void setupExample() {
		Grid grid = new Grid();
		grid.setColumnSpacing(2);
		grid.setRowSpacing(2);
		grid.setColumnHomogeneous(true);
		grid.setRowHomogeneous(true);
		mainWin.add(grid);
		
		Label label1 = new Label("Name");
		Label label2 = new Label("Age");
		Label label3 = new Label("Occupation");
		
		grid.attach(label1, 0, 0, 1, 1);
		grid.attach(label2, 0, 1, 1, 1);
		grid.attach(label3, 0, 2, 1, 1);
		
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();
		Entry entry3 = new Entry();
		
		grid.attach(entry1, 1, 0, 1, 1);
		grid.attach(entry2, 1, 1, 1, 1);
		grid.attach(entry3, 1, 2, 1, 1);
		
	}

}
