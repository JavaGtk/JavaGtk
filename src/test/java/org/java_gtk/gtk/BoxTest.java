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

import org.java_gtk.gtk.Container.Orientation;
import org.junit.Assert;
import org.junit.Test;

public class BoxTest extends GtkTest {
	private static final int TEST_BOX_SPACING = 10;
	
	@Test
	public void testNewBox() {
		Box box = new Box(Orientation.HORIZONTAL, TEST_BOX_SPACING);
		mainWin.add(box);
		processEvents();
		Assert.assertEquals(TEST_BOX_SPACING, box.getSpacing());
	}

	@Test
	public void testSetSpacing() {
		Box box = new Box(Orientation.HORIZONTAL, TEST_BOX_SPACING);
		mainWin.add(box);
		processEvents();
		box.setSpacing(TEST_BOX_SPACING + 5);
		processEvents();
		Assert.assertEquals(TEST_BOX_SPACING + 5, box.getSpacing());
	}

}
