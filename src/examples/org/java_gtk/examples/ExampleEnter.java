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

import java.util.EnumSet;

import org.java_gtk.gdk.EventCrossing;
import org.java_gtk.gdk.RGBA;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Fixed;
import org.java_gtk.gtk.StateFlags;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Widget.EnterEventHandler;

/**
 * 
 * @author Bill
 *
 */
public class ExampleEnter extends ExampleBase {

	public static void main(String[] args) {
		new ExampleEnter().runExample(args, "Widget Enter Example", 230, 150, 15);
	}

	@Override
	protected void setupExample() {

		Fixed fixed = new Fixed();
		mainWin.add(fixed);
		
		Button button = new Button("Button");
		button.setMinimumSize(80, 35);
		fixed.add(button, 50, 50);
		
		button.addEnterHandler(new EnterEventHandler() {
			public boolean handle(Widget source, EventCrossing event) {
				RGBA color = new RGBA(0.5, 0.6, 0.7, 1.0);
				mainWin.setBackgroundColor(EnumSet.of(StateFlags.NORMAL), color);
				return false;
			}
		});
		
	}

}
