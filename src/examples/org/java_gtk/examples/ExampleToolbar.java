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
import org.java_gtk.gtk.SeparatorToolItem;
import org.java_gtk.gtk.StockItems;
import org.java_gtk.gtk.ToolButton;
import org.java_gtk.gtk.ToolButton.ClickedEventHandler;
import org.java_gtk.gtk.Toolbar;
import org.java_gtk.gtk.Toolbar.ToolbarStyle;

public class ExampleToolbar extends ExampleBase {

	public static void main(String[] args) {
		new ExampleToolbar().runExample(args, "Toolbar Example", 250, 200, 0);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.VERTICAL, 0);
		mainWin.add(box);

		Toolbar toolbar = new Toolbar();
		toolbar.setStyle(ToolbarStyle.ICONS);
		toolbar.setBorderWidth(2);
		
		ToolButton new_tb = new ToolButton(StockItems.NEW);
		toolbar.insert(new_tb, -1);
		
		ToolButton open = new ToolButton(StockItems.OPEN);
		toolbar.insert(open, -1);
		
		ToolButton save = new ToolButton(StockItems.SAVE);
		toolbar.insert(save, -1);
		
		SeparatorToolItem sep = new SeparatorToolItem();
		toolbar.insert(sep, -1);

		ToolButton quit = new ToolButton(StockItems.QUIT);
		toolbar.insert(quit, -1);
		
		box.packStart(toolbar, false, false, 5);
		
		quit.addClickedHandler(new ClickedEventHandler() {
			public boolean handle(ToolButton source) {
				Gtk.mainQuit();
				return false;
			}			
		});
	}

}
