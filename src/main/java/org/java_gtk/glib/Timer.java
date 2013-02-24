package org.java_gtk.glib;

import org.java_gtk.NativeObject;
import org.java_gtk.gobject.GObject;
import org.java_gtk.gobject.Handler;
import org.java_gtk.util.ObjectCache;

public class Timer extends NativeObject {

	private static native final void g_timer_new(int interval, TimerHandler handler, long dataPointer);

	private Timer() {
		super(0);
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
