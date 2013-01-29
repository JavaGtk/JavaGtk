package org.java_gtk.gtk;

import org.junit.Assert;
import org.junit.Test;

public class MenuItemTest extends GtkTest {
	private static final String TEST_MENU_ITEM_LABEL = "Testing menu item label";

	@Test
	public void testNewButton() {
		MenuItem m = new MenuItem(TEST_MENU_ITEM_LABEL);
		mainWin.add(m);
		processEvents();
		Assert.assertEquals(TEST_MENU_ITEM_LABEL, m.getLabel());
	}

	@Test
	public void testSetButtonLabel() {
		MenuItem m = new MenuItem();
		mainWin.add(m);
		processEvents();
		Assert.assertEquals(m.getLabel(), "");
		m.setLabel(TEST_MENU_ITEM_LABEL);
		processEvents();
		Assert.assertEquals(TEST_MENU_ITEM_LABEL, m.getLabel());		
	}

}
