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

package org.java_gtk.glib;

import org.java_gtk.NativeObject;
import org.java_gtk.gobject.GObject;
import org.java_gtk.gobject.Handler;
import org.java_gtk.util.ObjectCache;

/**
 * Timer functions
 * 
 * @author Bill
 *
 */
public class Timer extends NativeObject {

	private static native final void g_timer_new(int interval, TimerHandler handler, long dataPointer);

	private Timer() {
		super(0, true, false);
	}

	/**
	 * The listener for receiving timer events.
	 */
	public static abstract class TimerHandler extends Handler {
		/**
		 * 
		 * @param data data passed to the timer
		 */
		public abstract boolean handle(GObject data);
	}
	
	static boolean timerReceiver(TimerHandler handler, long dataPointer) {
		return handler.handle((GObject)ObjectCache.lookup(dataPointer));
	}
	
	/**
	 * Executes the {@code handle} method of TimerHandler at regular intervals
	 * until it returns {@code false}, at which point the Timer is automatically
	 * destroyed and the function will not be called again.
	 * 
	 * @param interval the time between calls to the handler, in milliseconds (1/1000ths of a second)
	 * @param handler the timer handler
	 * @param data data to pass to the handler
	 */
	public static void addTimer(int interval, TimerHandler handler, GObject data) {
		lock.lock();
		try {
			g_timer_new(interval, handler, data.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
}
