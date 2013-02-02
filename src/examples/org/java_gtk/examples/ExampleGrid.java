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
import org.java_gtk.gtk.Grid;

public class ExampleGrid extends ExampleBase {

	public static void main(String[] args) {
		new ExampleGrid().runExample(args, "Grid Example");
	}

	@Override
	protected void setupExample() {
		mainWin.setDefaultSize(250, 180);
		mainWin.setBorderWidth(5);
		
		String[][] gridValues = {
				{"7", "8", "9", "/"}, 
				{"4", "5", "6", "*"}, 
				{"1", "2", "3", "-"}, 
				{"0", ".", "=", "+"} 
		};
		Grid grid = new Grid();
		grid.setColumnSpacing(2);
		grid.setRowSpacing(2);
		grid.setColumnHomogeneous(true);
		grid.setRowHomogeneous(true);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Button button = new Button(gridValues[i][j]);
				grid.attach(button, j, i, 1, 1);
			}
		}
		mainWin.add(grid);
	}

}
