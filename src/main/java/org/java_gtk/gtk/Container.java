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

import java.util.ArrayList;
import java.util.List;

import org.java_gtk.util.ObjectCache;

/**
 * A JavaGtk user interface is constructed by nesting widgets inside widgets. 
 * Container widgets are the inner nodes in the resulting tree of widgets: 
 * they contain other widgets
 * 
 * @author Bill Hull
 *
 */
public abstract class Container extends Widget {
	
	private static native final void gtk_container_add(long containerPointer, long widgetPointer);
	private static native final void gtk_container_remove(long containerPointer, long widgetPointer);
	private static native final void gtk_container_set_border_width(long containerPointer, int border_width);
	private static native final int gtk_container_get_border_width(long containerPointer);
	private static native final long[] gtk_container_get_children (long containerPointer);

	public enum Orientation {
		HORIZONTAL(0),
		VERTICAL(1);
		
		private Orientation(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}

	protected Container(long pointer) {
		super(pointer);
	}
	
	/**
	 * Adds a widget to this Container.  A widget may be added to only one container at a time;
	 * you can't place the same widget inside two different containers.
	 * 
	 * @param widget a widget to be placed inside this Container
	 */
	public void add(Widget widget) {
		lock.lock();
		try {
			gtk_container_add(this.pointer, widget.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Removes a widget from this Container.
	 * 
	 * @param widget a widget to be removed from this Container
	 */
	public void remove(Widget widget) {
		lock.lock();
		try {
			gtk_container_remove(this.pointer, widget.getPointer());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the border width of the container. 
	 * 
	 * The border width of a container is the amount of space to leave around the outside of 
	 * the container. The only exception to this is Window; because toplevel windows can't 
	 * leave space outside, they leave the space inside. The border is added on all sides of 
	 * the container.
	 * 
	 * @param width amount of blank space to leave outside the container
	 */
	public void setBorderWidth(int width) {
		lock.lock();
		try {
			gtk_container_set_border_width(this.pointer, width);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Retrieves the border width of the container.
	 * 
	 * @return the current border width
	 */
	public int getBorderWidth() {
		lock.lock();
		try {
			return gtk_container_get_border_width(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the container's non-internal children.
	 * 
	 * @return a newly-allocated list of the container's non-internal children
	 */
	public List<Widget> getChildren() {
		long[] ids;
		lock.lock();
		try {
			 ids = gtk_container_get_children(this.pointer);
		}
		finally {
			lock.unlock();
		}
		List<Widget> children = new ArrayList<Widget>(ids.length);
		for (long id: ids) {
			children.add((Widget)ObjectCache.lookup(id));
		}
		return children;
	}
}
