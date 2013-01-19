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

package org.java_gtk;

import org.java_gtk.gdk.Event;
import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Window;

/**
 * 
 * @author Bill Hull
 *
 */
public class App 
{
	
	public static void main( String[] args ) {
		Gtk.init(args);
		Window mainWin = new Window();
		mainWin.addDeleteHandler(new Widget.DeleteEventHandler() {
			public boolean handle(Widget source, Event event) {
				Gtk.mainQuit();
				return false;
			}
		});
		mainWin.setTitle("Hello World!");
		mainWin.setBorderWidth(10);
		
		Button b = new Button("Testing");
		b.addClickedHandler(new Button.ClickedEventHandler() {
			public boolean handle(Button source) {
				Gtk.mainQuit();
				return false;
			}
		});
		mainWin.add(b);
		
		mainWin.showAll();
		Gtk.main();
	}
	
}
