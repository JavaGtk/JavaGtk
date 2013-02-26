package org.java_gtk.examples;

import org.java_gtk.gtk.ComboBox;
import org.java_gtk.gtk.ComboBox.ChangedEventHandler;
import org.java_gtk.gtk.ComboBoxText;
import org.java_gtk.gtk.Fixed;
import org.java_gtk.gtk.Label;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleComboBoxText extends ExampleBase {

	public static void main(String[] args) {
		new ExampleComboBoxText().runExample(args, "Combo Box Text Example", 230, 150, 10);
	}

	@Override
	protected void setupExample() {
		Fixed fixed = new Fixed();
		ComboBoxText combo = new ComboBoxText();
		
		combo.appendText("Ubuntu");
		combo.appendText("Mandriva");
		combo.appendText("Fedora");
		combo.appendText("Mint");
		combo.appendText("Gentoo");
		combo.appendText("Debian");
		
		fixed.add(combo, 50, 50);
		mainWin.add(fixed);
		
		final Label label = new Label("-");
		fixed.add(label, 50, 110);
		
		combo.addChangedHandler(new ChangedEventHandler() {
			public void handle(ComboBox source) {
				String text = ((ComboBoxText)source).getActiveText();
				label.setText(text);
			}
		});
	}

}
