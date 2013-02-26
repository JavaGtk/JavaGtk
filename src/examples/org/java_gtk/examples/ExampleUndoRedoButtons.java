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
import org.java_gtk.gtk.Gtk;
import org.java_gtk.gtk.SeparatorToolItem;
import org.java_gtk.gtk.StockItems;
import org.java_gtk.gtk.ToolButton;
import org.java_gtk.gtk.Toolbar;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.ToolButton.ClickedEventHandler;
import org.java_gtk.gtk.Toolbar.ToolbarStyle;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/menusandtoolbars/
 * 
 * @author Bill
 *
 */
public class ExampleUndoRedoButtons extends ExampleBase {

	public static void main(String[] args) {
		new ExampleUndoRedoButtons().runExample(args, "Undo Redo Buttons Example", 250, 200, 0);
	}

	@Override
	protected void setupExample() {
		
		Box box = new Box(Orientation.VERTICAL, 0);
		mainWin.add(box);

		Toolbar toolbar = new Toolbar();
		toolbar.setStyle(ToolbarStyle.ICONS);
		toolbar.setBorderWidth(2);
		
		final ToolButton undo = new ToolButton(StockItems.UNDO);
		undo.setName("undo");
		toolbar.insert(undo, -1);
		
		final ToolButton redo = new ToolButton(StockItems.REDO);
		toolbar.insert(redo, -1);
		
		SeparatorToolItem sep = new SeparatorToolItem();
		toolbar.insert(sep, -1);

		ToolButton quit = new ToolButton(StockItems.QUIT);
		toolbar.insert(quit, -1);
		
		box.packStart(toolbar, false, false, 5);
		
		undo.addClickedHandler(new ClickedEventHandler() {
			public void handle(ToolButton source) {
				handleUndoRedo(source, redo);
			}
		});
		
		redo.addClickedHandler(new ClickedEventHandler() {
			public void handle(ToolButton source) {
				handleUndoRedo(source, undo);
			}
		});

		quit.addClickedHandler(new ClickedEventHandler() {
			public void handle(ToolButton source) {
				Gtk.mainQuit();
			}
		});

	}
	
	private static int count = 2;
	
	private void handleUndoRedo(ToolButton source, ToolButton item) {
		String name = source.getName();
		if (name.equals("undo"))
			count++;
		else
			count--;
		
		if (count < 0) {
			source.setEnabled(false);
			item.setEnabled(true);
		}
		if (count > 5) {
			source.setEnabled(false);
			item.setEnabled(true);
		}
	}
}
