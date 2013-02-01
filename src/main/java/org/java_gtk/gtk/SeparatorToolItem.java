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

package org.java_gtk.gtk;

/**
 * A SeparatorToolItem is a ToolItem that separates groups of other ToolItems. 
 * Depending on the theme, a SeparatorToolItem will often look like a vertical 
 * line on horizontally docked toolbars.
 * <p>
 * If the Toolbar child property "expand" is TRUE and the property "draw" is FALSE, 
 * a SeparatorToolItem will act as a "spring" that forces other items to the ends 
 * of the toolbar.
 *  
 * @author Bill
 *
 */
public class SeparatorToolItem extends ToolItem {

	private static native final long gtk_separator_tool_item_new();
	
	protected SeparatorToolItem(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a SeparatorToolItem widget.
	 */
	public SeparatorToolItem() {
		super(newSeparatorToolItem());
	}
	
	private static long newSeparatorToolItem() {
		lock.lock();
		try {
			return gtk_separator_tool_item_new();
		}
		finally {
			lock.unlock();
		}
	}

}
