package org.java_gtk.examples;

import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Button.ClickedEventHandler;
import org.java_gtk.gtk.Container.Orientation;

public class ExampleMemory extends ExampleBase {

	public static void main(String[] args) {
		new ExampleMemory().runExample(args, "Memory Example", 250, 200, 0);
	}

	ClickedEventHandler h;
	Box box;
	
	@Override
	protected void setupExample() {
		
		box = new Box(Orientation.VERTICAL, 5);
		
		Button b1 = new Button("Click to remove handler");
		h = new ClickedEventHandler(){
			public void handle(Button source) {
				source.removeClickedHandler(h);
				h = null;
			}
		};
		
		Button b2 = new Button("GC");
		b2.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				System.gc();
			}
		});
		
		Button b3 = new Button("Click to add button");
		b3.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				createButton();
			}
		});

		b1.addClickedHandler(h);
		box.add(b2);
		box.add(b1);
		box.add(b3);
		
		mainWin.add(box);
	}
	
	private void createButton() {
		Button b = new Button("Click to remove");
		b.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				box.remove(source);
				box.showAll();
			}
		});
		box.add(b);
		box.showAll();
	}

}
