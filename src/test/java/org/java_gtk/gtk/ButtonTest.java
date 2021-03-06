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

import org.junit.Assert;
import org.junit.Test;

public class ButtonTest extends GtkTest {
	private static final String TEST_BUTTON_LABEL = "Testing button label";

	@Test
	public void testNewButton() {
		Button b = new Button(TEST_BUTTON_LABEL);
		mainWin.add(b);
		processEvents();
		Assert.assertEquals(TEST_BUTTON_LABEL, b.getLabel());
	}

	@Test
	public void testSetButtonLabel() {
		Button b = new Button();
		mainWin.add(b);
		processEvents();
		Assert.assertNull(b.getLabel());
		b.setLabel(TEST_BUTTON_LABEL);
		processEvents();
		Assert.assertEquals(TEST_BUTTON_LABEL, b.getLabel());		
	}
	
}
