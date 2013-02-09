/* 
 * Copyright (c) 2012 - 2013, JavaGTK and Bill Hull
 *
 * Permission to use, copy, modify, and/or distribute this software
 * for any purpose with or without fee is hereby granted, provided 
 * that the above copyright notice and this permission notice appear 
 * in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL 
 * WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE 
 * AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL
 * DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA 
 * OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER 
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR 
 * PERFORMANCE OF THIS SOFTWARE.
 */

package org.java_gtk.examples;

import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Gtk;

public class ExampleButtons extends ExampleBase {
	
	public static void main(String[] args) {
		new ExampleButtons().runExample(args, "Buttons Example", 350, 100, 10);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.HORIZONTAL, 10);
		mainWin.add(box);
		
		Button b1 = new Button("This is a button.\nClick me to close.");
		b1.addClickedHandler(new Button.ClickedEventHandler() {
			public void handle(Button source) {
				Gtk.mainQuit();
			}
		});
		box.packStart(b1, true, true, 0);
		
		Button b2 = new Button("This is another button.\nClick me to see something special.");
		b2.addClickedHandler(new Button.ClickedEventHandler() {
			public void handle(Button source) {
				source.setLabel("You clicked me!!\nThat was special.");
			}
		});
		box.packEnd(b2, true, true, 0);
	}

}
