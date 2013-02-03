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

import org.java_gtk.gdk.Pixbuf;

/**
 * 
 * A Window is a toplevel window which can contain other widgets.
 * 
 * @author Bill Hull
 *
 */
public class Window extends Bin {

	private static native final long gtk_window_new(int type);
	private static native final void gtk_window_set_title(long windowPointer, String title);
	private static native final String gtk_window_get_title(long windowPointer);
	private static native final void gtk_window_set_default_size(long windowPointer, int width, int height);
	private static native final void gtk_window_set_resizable(long windowPointer, boolean resizable);
	private static native final boolean gtk_window_get_resizable(long windowPointer);
	private static native final void gtk_window_set_position(long windowPointer, int position);
	private static native final void gtk_window_add_accel_group(long windowPointer, long accelgroupPointer);
	private static native final void gtk_window_set_icon(long windowPointer, long pixbufPointer);
	
	public enum WindowType {
		TOPLEVEL(0),
		POPUP(1);
		
		private WindowType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	public enum WindowPosition {
		NONE(0),
		CENTER(1),
		MOUSE(2),
		CENTER_ALWAYS(3),
		CENTER_ON_PARENT(4);
		  
		private WindowPosition(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	protected Window(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new Window, which is a toplevel window that can contain other widgets
	 */
	public Window () {
		this(newWindow());
	}
		
	private static long newWindow() {
		lock.lock();
		try {
			return gtk_window_new(WindowType.TOPLEVEL.getValue());
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the title of the Window. The title of a window will be displayed in its title bar.
	 * 
	 * @param title the title of the window
	 */
	public void setTitle(String title) {
		lock.lock();
		try {
			gtk_window_set_title(pointer, title);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the title of the window.
	 * 
	 * @return the title of the window or <code>null<code> if none has been set explicitly
	 */
	public String getTitle() {
		lock.lock();
		try {
			return gtk_window_get_title(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets whether the user can resize a window. Windows are user resizable by default. 
	 * 
	 * @param resizable <code>true</code> if the user can resize this window
	 */
	public void setResizable(boolean resizable) {
		lock.lock();
		try {
			gtk_window_set_resizable(pointer, resizable);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the value set of the resize
	 * 
	 * @return <code>true</code> if the user can resize this window
	 */
	public boolean getResizable() {
		lock.lock();
		try {
			return gtk_window_get_resizable(pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the default size of a window. If the window's "natural" size 
	 * (its size request) is larger than the default, the default will be ignored.
	 * <p>
	 * This function only sets the initial size, just as if the user had resized 
	 * the window themselves. Users can still shrink the window again as they 
	 * normally would. Setting a default size of -1 means to use the "natural" 
	 * default size (the size request of the window).
	 * <p>
	 * The default size of a window only affects the first time a window is shown; 
	 * if a window is hidden and re-shown, it will remember the size it had prior 
	 * to hiding, rather than using the default size. 
	 * 
	 * @param width width in pixels, or -1 to unset the default width
	 * @param height height in pixels, or -1 to unset the default height
	 */
	public void setDefaultSize(int width, int height) {
		lock.lock();
		try {
			gtk_window_set_default_size(pointer, width, height);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets a position constraint for this window.
	 * 
	 * @param position a position constraint.
	 */
	public void setPosition(WindowPosition position) {
		lock.lock();
		try {
			gtk_window_set_position(pointer, position.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Associate accelGroup with window.
	 * 
	 * @param accelGroup
	 */
	public void addAccelGroup(AccelGroup accelGroup) {
		lock.lock();
		try {
			gtk_window_add_accel_group(pointer, accelGroup.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the icon representing a Window
	 * 
	 * @param icon icon image or <code>null</code>
	 */
	public void setIcon(Pixbuf icon) {
		lock.lock();
		try {
			gtk_window_set_icon(pointer, icon.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
}
