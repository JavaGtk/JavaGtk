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

import java.util.EnumSet;

/**
 * Describes a widget state
 * 
 * @author Bill
 *
 */
public enum StateFlags {
	NORMAL       (0),
	ACTIVE       (1 << 0),
	PRELIGHT     (1 << 1),
	SELECTED     (1 << 2),
	DISABLED     (1 << 3),
	INCONSISTENT (1 << 4),
	FOCUSED      (1 << 5),
	BACKDROP     (1 << 6);

	private StateFlags(int value) {
		this.value = value;
	}
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public static int getValue(EnumSet<StateFlags> flags) {
		int value = 0;
		for (StateFlags flag: flags) {
			value |= flag.getValue();
		}
		return value;
	}
	
	public static EnumSet<StateFlags> getFlags(int value) {
		EnumSet<StateFlags> flags = EnumSet.noneOf(StateFlags.class);
		for (StateFlags flag: StateFlags.values()) {
			if ((value & flag.getValue()) > 0)
				flags.add(flag);
		}
		return flags;
	}

}
