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

import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Window;

public abstract class ExampleBase {
	
	protected Window mainWin;
	
	protected void runExample(String[] args, String title, int width, int height, int border) {
		
		Gtk.init(args);
		mainWin = new Window();
		mainWin.addDestroyHandler(new Widget.DestroyHandler() {
			public void handle(Widget source) {
				Gtk.mainQuit();
			}
		});
		mainWin.setTitle(title);
		mainWin.setDefaultSize(width, height);
		mainWin.setBorderWidth(border);
		
		setupExample();
		
		mainWin.showAll();
		Gtk.main();
		
	}
	
	protected abstract void setupExample();
}
