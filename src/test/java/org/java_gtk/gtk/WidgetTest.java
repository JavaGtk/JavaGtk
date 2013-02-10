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

import org.java_gtk.gtk.Widget.Align;
import org.junit.Assert;
import org.junit.Test;

public class WidgetTest extends GtkTest {

	private static final String WIDGET_NAME = "test_widget_name";
	private static final int WIDGET_MARGIN = 7;
		
	@Test
	public void testWidgetName() {
		Label l = new Label("test label");
		l.setName(WIDGET_NAME);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getName(), WIDGET_NAME);
	}

	@Test
	public void testWidgetSensitive() {
		Label l = new Label("test label");
		l.setEnabled(false);
		mainWin.add(l);
		processEvents();
		Assert.assertFalse(l.isEnable());
		l.setEnabled(true);
		processEvents();
		Assert.assertTrue(l.isEnable());
	}
	
	@Test
	public void testWidgetHAlign() {
		Label l = new Label("test label");
		l.setHalign(Align.CENTER);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getHalign(), Align.CENTER);
	}
	
	@Test
	public void testWidgetVAlign() {
		Label l = new Label("test label");
		l.setValign(Align.CENTER);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getValign(), Align.CENTER);
	}
	
	@Test
	public void testWidgetMarginTop() {
		Label l = new Label("test label");
		l.setMarginTop(WIDGET_MARGIN);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getMarginTop(), WIDGET_MARGIN);
	}
	
	@Test
	public void testWidgetMarginBottom() {
		Label l = new Label("test label");
		l.setMarginBottom(WIDGET_MARGIN);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getMarginBottom(), WIDGET_MARGIN);
	}

	@Test
	public void testWidgetMarginLeft() {
		Label l = new Label("test label");
		l.setMarginLeft(WIDGET_MARGIN);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getMarginLeft(), WIDGET_MARGIN);
	}
	
	@Test
	public void testWidgetMarginRight() {
		Label l = new Label("test label");
		l.setMarginRight(WIDGET_MARGIN);
		mainWin.add(l);
		processEvents();
		Assert.assertEquals(l.getMarginRight(), WIDGET_MARGIN);
	}
	
	@Test
	public void testWidgetHExpand() {
		Label l = new Label("test label");
		l.setHexpand(true);
		mainWin.add(l);
		processEvents();
		Assert.assertTrue(l.getHexpand());
	}
	
	@Test
	public void testWidgetVExpand() {
		Label l = new Label("test label");
		l.setVexpand(true);
		mainWin.add(l);
		processEvents();
		Assert.assertTrue(l.getVexpand());
	}
	
}
