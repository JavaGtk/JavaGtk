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

import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Fixed;
import org.java_gtk.gtk.Label;
import org.java_gtk.gtk.Window.WindowPosition;

public class ExampleIncreaseDecrease extends ExampleBase {
	
	static int count = 0;

	public static void main(String[] args) {
		new ExampleIncreaseDecrease().runExample(args, "Increase Decrease Example");
	}

	@Override
	protected void setupExample() {
		mainWin.setBorderWidth(10);
		mainWin.setPosition(WindowPosition.MOUSE);
		mainWin.setDefaultSize(250, 180);
		
		Fixed frame = new Fixed();
		mainWin.add(frame);

		final Label label = new Label("0");
		
		Button plus = new Button("+");
		plus.setMinimumSize(80, 35);
		plus.addClickedHandler(new Button.ClickedEventHandler() {
			public boolean handle(Button source) {
				count++;
				label.setText(Integer.toString(count));
				return false;
			}
		});
		frame.add(plus, 50, 20);
		
		Button minus = new Button("-");
		minus.setMinimumSize(80, 35);
		minus.addClickedHandler(new Button.ClickedEventHandler() {
			public boolean handle(Button source) {
				count--;
				label.setText(Integer.toString(count));
				return false;
			}
		});
		frame.add(minus, 50, 80);
		
		frame.add(label, 190, 58);
	}
}
