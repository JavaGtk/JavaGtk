package org.java_gtk.examples;

import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Label;
import org.java_gtk.gtk.Separator;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtkwidgetsII/
 * 
 * @author Bill
 *
 */
public class ExampleSeparator extends ExampleBase {

	public static void main(String[] args) {
		new ExampleSeparator().runExample(args, "Separator Example", 200, 200, 15);
	}

	@Override
	protected void setupExample() {
		mainWin.setResizable(false);
		
		Label label1 = new Label("Zinc is a moderately reactive, blue gray metal that tarnishes in moist air and burns in air with a bright bluish-green flame, giving off fumes of zinc oxide. It reacts with acids, alkalis and other non-metals.  If not completely pure, zinc reacts with dilute acids to release hydrogen.");
		label1.setLineWrap(true);
		Separator sep = new Separator(Orientation.HORIZONTAL);
		Label label2 = new Label("Copper is an essential trace nutrient to all high plants and animals. In animals, including humans, it is found primarily in the bloodstream, as a co-factor in various enzymes, and in copper-based pigments.  However, in sufficient amounts, copper can be poisonous and even fatal to organisms.");
		label2.setLineWrap(true);
		
		Box box = new Box(Orientation.VERTICAL, 10);
		mainWin.add(box);
		
		box.packStart(label1, false, true, 0);
		box.packStart(sep, false, true, 10);
		box.packStart(label2, false, true, 0);
	}

}
