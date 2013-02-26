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
import org.java_gtk.gtk.CheckMenuItem;
import org.java_gtk.gtk.Menu;
import org.java_gtk.gtk.MenuBar;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.MenuItem;
import org.java_gtk.gtk.StatusBar;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/menusandtoolbars/
 * 
 * @author Bill
 *
 */
public class ExampleCheckMenuItem extends ExampleBase {

	public static void main(String[] args) {
		new ExampleCheckMenuItem().runExample(args, "Check Menu Item Example", 250, 200, 10);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.VERTICAL, 10);
		mainWin.add(box);
		
		MenuBar menuBar = new MenuBar();
		Menu viewMenu = new Menu();
		
		MenuItem view = new MenuItem("View");
		CheckMenuItem tog_stat = new CheckMenuItem("View Statusbar");
		tog_stat.setActive(true);
		
		view.setSubMenu(viewMenu);
		viewMenu.append(tog_stat);
		menuBar.append(view);
		box.packStart(menuBar, false, false, 3);
		
		final StatusBar statusbar = new StatusBar();
		box.packEnd(statusbar, false, true, 1);
		
		tog_stat.addActivatedHandler(new MenuItem.ActivatedEventHandler () {
			public void handle(MenuItem source) {
				if (((CheckMenuItem)source).isActive())
					statusbar.show();
				else 
					statusbar.hide();
			}
		});
		
	}

}
