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
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.Menu;
import org.java_gtk.gtk.MenuBar;
import org.java_gtk.gtk.MenuItem;

public class ExampleMenu extends ExampleBase {
	
	public static void main(String[] args) {
		new ExampleMenu().runExample(args, "Menu Example", 250, 200, 0);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.VERTICAL, 10);
		mainWin.add(box);
		
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu();
		
		MenuItem file = new MenuItem("File");
		MenuItem quit = new MenuItem("Quit");
		
		file.setSubMenu(fileMenu);
		fileMenu.append(quit);
		menuBar.append(file);
		
		box.packStart(menuBar, false, false, 3);
		
		quit.addActivatedHandler(new MenuItem.ActivatedEventHandler () {
			public boolean handle(MenuItem source) {
				Gtk.mainQuit();
				return false;
			}
			
		});
	}
	
}
