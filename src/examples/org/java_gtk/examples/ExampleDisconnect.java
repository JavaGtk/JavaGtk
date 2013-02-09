package org.java_gtk.examples;

import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.CheckButton;
import org.java_gtk.gtk.Fixed;

public class ExampleDisconnect extends ExampleBase {

	public static void main(String[] args) {
		new ExampleDisconnect().runExample(args, "Disconnect Example", 250, 150, 0);
	}

	@Override
	protected void setupExample() {
		Fixed fixed = new Fixed();
		mainWin.add(fixed);
		
		final Button button = new Button("Click");
		button.setMinimumSize(80, 30);
		fixed.add(button, 30, 50);
		
		CheckButton check = new CheckButton("Connect");
		check.setActive(true);
		fixed.add(check, 130, 50);
		
		final Button.ClickedEventHandler handler = new Button.ClickedEventHandler() {
			public void handle(Button source) {
				System.out.println("clicked\n");
			}
		};
		
		button.addClickedHandler(handler);
		
		check.addClickedHandler(new Button.ClickedEventHandler() {
			public void handle(Button source) {
				if (((CheckButton)source).isActive())
					button.addClickedHandler(handler);
				else
					button.removeClickedHandler(handler);
			}
		});
	}

}
