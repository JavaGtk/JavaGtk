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

import java.util.EnumSet;

/**
 * A set of bit-flags to indicate which events a window is to receive.
 * 
 * @author Bill
 *
 */
public enum EventMasks {
	EXPOSURE_MASK            (1 << 1),
	POINTER_MOTION_MASK      (1 << 2),
	POINTER_MOTION_HINT_MASK (1 << 3),
	BUTTON_MOTION_MASK       (1 << 4),
	BUTTON1_MOTION_MASK      (1 << 5),
	BUTTON2_MOTION_MASK      (1 << 6),
	BUTTON3_MOTION_MASK      (1 << 7),
	BUTTON_PRESS_MASK        (1 << 8),
	BUTTON_RELEASE_MASK      (1 << 9),
	KEY_PRESS_MASK           (1 << 10),
	KEY_RELEASE_MASK         (1 << 11),
	ENTER_NOTIFY_MASK        (1 << 12),
	LEAVE_NOTIFY_MASK        (1 << 13),
	FOCUS_CHANGE_MASK        (1 << 14),
	STRUCTURE_MASK           (1 << 15),
	PROPERTY_CHANGE_MASK     (1 << 16),
	VISIBILITY_NOTIFY_MASK   (1 << 17),
	PROXIMITY_IN_MASK        (1 << 18),
	PROXIMITY_OUT_MASK       (1 << 19),
	SUBSTRUCTURE_MASK        (1 << 20),
	SCROLL_MASK              (1 << 21),
	TOUCH_MASK               (1 << 22),
	SMOOTH_SCROLL_MASK       (1 << 23),
	ALL_EVENTS_MASK          (0xFFFFFE);

	private EventMasks(int value) {
		this.value = value;
	}
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public static int getValue(EnumSet<EventMasks> masks) {
		int value = 0;
		for (EventMasks mask: masks) {
			value |= mask.getValue();
		}
		return value;
	}
	
	public static EnumSet<EventMasks> getMask(int value) {
		EnumSet<EventMasks> mask = EnumSet.noneOf(EventMasks.class);
		for (EventMasks masks: EventMasks.values()) {
			if ((value & masks.getValue()) > 0)
				mask.add(masks);
		}
		return mask;
	}

}
