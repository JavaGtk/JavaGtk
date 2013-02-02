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

import org.java_gtk.gdk.ModifierType;
import org.java_gtk.gtk.AccelGroup;
import org.java_gtk.gtk.AccelMap;
import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.ImageMenuItem;
import org.java_gtk.gtk.Menu;
import org.java_gtk.gtk.MenuBar;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.MenuItem;
import org.java_gtk.gtk.SeparatorMenuItem;
import org.java_gtk.gtk.StockItems;

public class ExampleAcceleratorsMnemonics extends ExampleBase {

	public static void main(String[] args) {
		new ExampleAcceleratorsMnemonics().runExample(args, "Accelerators & Mnemonics Example", 250, 200, 0);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.VERTICAL, 10);
		mainWin.add(box);
		
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu();
		AccelGroup accelGrp = new AccelGroup();
		mainWin.addAccelGroup(accelGrp);
		fileMenu.setAccelGroup(accelGrp);
		
		MenuItem file = new MenuItem("_File", true);
		ImageMenuItem newItem = new ImageMenuItem(StockItems.NEW);
		ImageMenuItem open = new ImageMenuItem(StockItems.OPEN);
		SeparatorMenuItem sep = new SeparatorMenuItem();
		ImageMenuItem quit = new ImageMenuItem(StockItems.QUIT);
		
		AccelMap.addEntry("<SampleApp>/File/Quit", 'q', EnumSet.of(ModifierType.CONTROL_MASK));
		quit.setAccelPath("<SampleApp>/File/Quit", accelGrp);
		
		file.setSubMenu(fileMenu);
		fileMenu.append(newItem);
		fileMenu.append(open);
		fileMenu.append(sep);
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
