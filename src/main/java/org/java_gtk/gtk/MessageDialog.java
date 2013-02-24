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
 * MessageDialog presents a dialog with an image representing the type of 
 * message (Error, Question, etc.) alongside some message text.
 * 
 * @author Bill
 *
 */
public class MessageDialog extends Dialog {

	private static native final long gtk_message_dialog_new(long windowPointer, int flags, int type, int buttons, String message);

	/**
	 * Prebuilt sets of buttons for the dialog.
	 * 
	 */
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
	
	/**
	 * The type of message being displayed in the dialog.
	 *
	 */
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
	 * Constructs a new message dialog, which is a simple dialog with an 
	 * icon indicating the dialog type (error, warning, etc.) and some 
	 * text the user may want to see. When the user clicks a button a 
	 * "response" signal is fired.
	 * 
	 * @param parent parent or {@code null} for none
	 * @param flags flags
	 * @param type type of message
	 * @param buttons set of buttons to use
	 * @param messageFormat a formatted string
	 * @param args arguments for the formatted string
	 */
	public MessageDialog (Window parent, DialogFlags flags, MessageType type, ButtonsType buttons, String messageFormat, Object...args) {
		this(newMessageDialog(parent, flags, type, buttons, messageFormat, args));
	}
		
	private static long newMessageDialog(Window parent, DialogFlags flags, MessageType type, ButtonsType buttons, String messageFormat, Object...args) {
		String message = String.format(messageFormat, args);
		lock.lock();
		try {
			return gtk_message_dialog_new(parent.getPointer(), flags.getValue(), type.getValue(), buttons.getValue(), message);
		}
		finally {
			lock.unlock();
		}
	}
}
