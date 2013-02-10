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

package org.java_gtk.gdk;

import java.util.TreeMap;

/**
 * Specifies the type of an Event
 * 
 * @author Bill
 *
 */
public enum EventType {
	
	NOTHING(-1),
 	DELETE(0),
	DESTROY(1),
	EXPOSE(2),
	MOTION_NOTIFY(3),
	BUTTON_PRESS(4),
	DOUBLE_BUTTON_PRESS(5),
	TRIPLE_BUTTON_PRESS(6),
	BUTTON_RELEASE(7),
	KEY_PRESS(8),
	KEY_RELEASE(9),
	ENTER_NOTIFY(10),
	LEAVE_NOTIFY(11),
	FOCUS_CHANGE(12),
	CONFIGURE(13),
	MAP(14),
	UNMAP(15),
	PROPERTY_NOTIFY(16),
	SELECTION_CLEAR(17),
	SELECTION_REQUEST(18),
	SELECTION_NOTIFY(19),
	PROXIMITY_IN(20),
	PROXIMITY_OUT(21),
	DRAG_ENTER(22),
	DRAG_LEAVE(23),
	DRAG_MOTION(24),
	DRAG_STATUS(25),
	DROP_START(26),
	DROP_FINISHED(27),
	CLIENT_EVENT(28),
	VISIBILITY_NOTIFY(29),
	SCROLL(31),
	WINDOW_STATE(32),
	SETTING(33),
	OWNER_CHANGE(34),
	GRAB_BROKEN(35),
	DAMAGE(36),
	TOUCH_BEGIN(37),
	TOUCH_UPDATE(38),
	TOUCH_END(39),
	TOUCH_CANCEL(40),
	EVENT_LAST(41);
	  
	private EventType(int value) {
		this.value = value;
	}
	
	private int value;
	
	public int getValue() {
		return value;
	}

	// cache values in a map for lookups
	private static TreeMap<Integer, EventType> map;
	
	static {
		map = new TreeMap<Integer, EventType>();
		for (EventType type: EventType.values()) {
			map.put(new Integer(type.value), type);
		}
	}
	
	public static EventType lookup(int value) {
		return map.get(new Integer(value));
	}

}
