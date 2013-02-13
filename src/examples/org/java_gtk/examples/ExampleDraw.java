package org.java_gtk.examples;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.java_gtk.cairo.CairoContext;
import org.java_gtk.glib.Timer;
import org.java_gtk.glib.Timer.TimerHandler;
import org.java_gtk.gobject.GObject;
import org.java_gtk.gtk.DrawingArea;
import org.java_gtk.gtk.Widget;
import org.java_gtk.gtk.Window;

public class ExampleDraw extends ExampleBase {

	public static void main(String[] args) {
		new ExampleDraw().runExample(args, "Draw Example", 170, 100, 0);
	}

	private String curTime = "";
	private Timer timer;
	
	@Override
	protected void setupExample() {
		DrawingArea darea = new DrawingArea();
		mainWin.add(darea);
				
		darea.addDrawHandler(new Widget.DrawHandler() {
			public boolean handle(Widget source, CairoContext context) {
				context.moveTo(30, 30);
				context.showText(curTime);
				return false;
			}
		});
		
		Timer.addTimer(1000, new TimerHandler() {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			public boolean handle(GObject data) {
				curTime = sdf.format(Calendar.getInstance().getTime());
				Window win = (Window)data;
				win.queueDraw();
				return true;
			}
		}, mainWin);
		
	}

}
