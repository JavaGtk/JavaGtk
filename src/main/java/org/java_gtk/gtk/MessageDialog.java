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

/**
 * 
 * @author Bill
 *
 */
public class MessageDialog extends Dialog {

	private static native final long gtk_message_dialog_new(long windowPointer, int flags, int type, int buttons, String message);

	public enum ButtonsType {
		NONE(0),
		OK(1),
		CLOSE(2),
		CANCEL(3),
		YES_NO(4),
		OK_CANCEL(5);
		
		private ButtonsType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	public enum MessageType {
		INFO(0),
		WARNING(1),
		QUESTION(2),
		ERROR(3),
		OTHER(4);
		
		private MessageType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}

	protected MessageDialog(long pointer) {
		super(pointer);
	}

	/**
	 * 
	 * @param parent
	 * @param flags
	 * @param type
	 * @param buttons
	 * @param messageFormat
	 * @param args
	 */
	public MessageDialog (Window parent, DialogFlags flags, MessageType type, ButtonsType buttons, String messageFormat, Object...args) {
		this(newMessageDialog(parent, flags, type, buttons, messageFormat, args));
	}
		
	private static long newMessageDialog(Window parent, DialogFlags flags, MessageType type, ButtonsType buttons, String messageFormat, Object...args) {
		lock.lock();
		try {
			return gtk_message_dialog_new(parent.getPointer(), flags.getValue(), type.getValue(), buttons.getValue(), String.format(messageFormat, args));
		}
		finally {
			lock.unlock();
		}
	}
}
