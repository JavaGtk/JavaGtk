package org.java_gtk.examples;

import org.java_gtk.gtk.Alignment;
import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Grid;
import org.java_gtk.gtk.Label;
import org.java_gtk.gtk.TextView;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtklayoutmanagement/
 * 
 * @author Bill
 *
 */
public class ExampleWindowsDialog extends ExampleBase {

	public static void main(String[] args) {
		new ExampleWindowsDialog().runExample(args, "Windows Dialog Example", 300, 250, 15);
	}

	@Override
	protected void setupExample() {
		
		mainWin.setMinimumSize(300, 250);
		mainWin.setResizable(false);
		
		Grid grid = new Grid();
		grid.setColumnSpacing(5);
		grid.setColumnHomogeneous(false);
		grid.setRowHomogeneous(false);
		
		Label title = new Label("Windows");
		title.setMarginBottom(5);
		Alignment halign = new Alignment(0, 0, 0, 0);
		halign.add(title);
		grid.attach(halign, 0, 0, 1, 1);
		
		TextView wins = new TextView();
		wins.setEditable(false);
		wins.setCursorVisible(false);
		wins.setHexpand(true);
		wins.setVexpand(true);
		grid.attach(wins, 0, 1, 3, 2);
		
		Button activate = new Button("Activate");
		activate.setMinimumSize(70, 30);
		
		Button close = new Button("Close");
		close.setMinimumSize(70, 30);
		close.setMarginTop(5);

		Box vbox = new Box(Orientation.VERTICAL, 0);
		vbox.packStart(activate, false, false, 0);
		vbox.packStart(close, false, false, 0);
		grid.attach(vbox, 4, 1, 1, 1);
		
		Alignment halign2 = new Alignment(0, 1, 0, 0);
		Button help = new Button("Help");
		halign2.add(help);
		help.setMinimumSize(70, 30);
		help.setMarginTop(5);
		grid.attach(halign2, 0, 4, 1, 1);
		
		Button ok = new Button("OK");
		ok.setMinimumSize(70, 30);
		ok.setMarginTop(5);
		grid.attach(ok, 4, 4, 1, 1);
		
		mainWin.add(grid);
	}

}
