package org.java_gtk.examples;

import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Button.ClickedEventHandler;
import org.java_gtk.gtk.Dialog.DialogFlags;
import org.java_gtk.gtk.Grid;
import org.java_gtk.gtk.MessageDialog;
import org.java_gtk.gtk.MessageDialog.ButtonsType;
import org.java_gtk.gtk.MessageDialog.MessageType;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkdialogs/
 * 
 * @author Bill
 *
 */
public class ExampleMessageDialog extends ExampleBase {

	public static void main(String[] args) {
		new ExampleMessageDialog().runExample(args, "Message Dialog Example", 220, 150, 0);
	}

	@Override
	protected void setupExample() {
		Grid grid = new Grid();
		grid.setColumnSpacing(2);
		grid.setRowSpacing(2);
		grid.setColumnHomogeneous(true);
		grid.setRowHomogeneous(true);
		
		Button info = new Button("Info");
		Button warn = new Button("Warning");
		Button que = new Button("Question");
		Button err = new Button("Error");
		
		grid.attach(info, 0, 0, 1, 1);
		grid.attach(warn, 0, 1, 1, 1);
		grid.attach(que, 1, 0, 1, 1);
		grid.attach(err, 1, 1, 1, 1);
		
		mainWin.add(grid);
		
		info.addClickedHandler(new ClickedEventHandler(){
			public void handle(Button source) {
				MessageDialog dialog = new MessageDialog(mainWin, DialogFlags.DESTROY_WITH_PARENT, MessageType.INFO, ButtonsType.OK, "Download Complete", "title");
				dialog.setTitle("Information");
				dialog.run();
				dialog.destroy();
			}
		});

		warn.addClickedHandler(new ClickedEventHandler(){
			public void handle(Button source) {
				MessageDialog dialog = new MessageDialog(mainWin, DialogFlags.DESTROY_WITH_PARENT, MessageType.WARNING, ButtonsType.OK, "Unallowed operation");
				dialog.setTitle("Warning");
				dialog.run();
				dialog.destroy();
			}
		});
	
		que.addClickedHandler(new ClickedEventHandler(){
			public void handle(Button source) {
				MessageDialog dialog = new MessageDialog(mainWin, DialogFlags.DESTROY_WITH_PARENT, MessageType.QUESTION, ButtonsType.YES_NO, "Are you sure to quit?");
				dialog.setTitle("Question");
				dialog.run();
				dialog.destroy();
			}
		});

		err.addClickedHandler(new ClickedEventHandler(){
			public void handle(Button source) {
				MessageDialog dialog = new MessageDialog(mainWin, DialogFlags.DESTROY_WITH_PARENT, MessageType.ERROR, ButtonsType.OK, "Error loading file");
				dialog.setTitle("Error");
				dialog.run();
				dialog.destroy();
			}
		});
	
	}

}
