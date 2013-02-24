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
 * Dialog boxes are a convenient way to prompt the user for a small amount 
 * of input, e.g. to display a message, ask a question, or anything else 
 * that does not require extensive effort on the user's part.
 * 
 * @author Bill
 *
 */
public class Dialog extends Window {

	private static native final long gtk_dialog_new();
	private static native final int gtk_dialog_run(long dialogPointer);

	/**
	 * Flags used to influence dialog construction.
	 */
	public enum DialogFlags {
		MODAL               (1 << 0),
		DESTROY_WITH_PARENT (1 << 1);

		private DialogFlags(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
		
		public static int getValue(EnumSet<DialogFlags> flags) {
			int value = 0;
			for (DialogFlags flag: flags) {
				value |= flag.getValue();
			}
			return value;
		}
		
		public static EnumSet<DialogFlags> getFlags(int value) {
			EnumSet<DialogFlags> flag = EnumSet.noneOf(DialogFlags.class);
			for (DialogFlags flags: DialogFlags.values()) {
				if ((value & flags.getValue()) > 0)
					flag.add(flags);
			}
			return flag;
		}

	}

	/**
	 * Predefined values for use as response ids
	 */
	public enum ResponseType {
		NONE(-1),
		REJECT(-2),
		ACCEPT(-3),
		DELETE_EVENT(-4),
		OK(-5),
		CANCEL(-6),
		CLOSE(-7),
		YES(-8),
		NO(-9),
		APPLY(-10),
		HELP(-11);
		
		private ResponseType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
		
		public static ResponseType getResponseType(int value) {
			for (ResponseType response: ResponseType.values()) {
				if (response.getValue() == value)
					return response;
			}
			return ResponseType.NONE;
		}
	}

	protected Dialog(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new dialog box.
	 */
	public Dialog () {
		this(newDialog());
	}
		
	private static long newDialog() {
		lock.lock();
		try {
			return gtk_dialog_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Blocks in a recursive main loop until the dialog either fires the 
	 * "response" signal, or is destroyed.
	 * 
	 * @return ResponseType indicating the results of the dialog action
	 */
	public ResponseType run() {
		lock.lock();
		try {
			return ResponseType.getResponseType(gtk_dialog_run(this.pointer));
		}
		finally {
			lock.unlock();
		}
	}

}
