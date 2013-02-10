package org.java_gtk.gtk;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ContainerTest extends GtkTest {

	private static final int CONTAINER_BORDER = 6;

	@Test
	public void testAdd() {
		Label l = new Label("test label");
		mainWin.add(l);
		processEvents();
		List<Widget> children = mainWin.getChildren();
		Assert.assertEquals(1, children.size());
		Assert.assertEquals(l.getPointer(), children.get(0).getPointer());
		Assert.assertEquals(l, children.get(0));
	}

	@Test
	public void testBorder() {
		mainWin.setBorderWidth(CONTAINER_BORDER);
		processEvents();
		Assert.assertEquals(mainWin.getBorderWidth(), CONTAINER_BORDER);
	}
}
