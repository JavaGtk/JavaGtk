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

import org.java_gtk.gtk.Dialog.ResponseType;

/**
 * The frame widget is a Bin that surrounds its child with a decorative 
 * frame and an optional label.
 * 
 * @author Bill
 *
 */
public class Frame extends Bin {

	private static native final long gtk_frame_new(String label);
	private static native final String gtk_frame_get_label(long framePointer);
	private static native final void gtk_frame_set_label(long framePointer, String label);
	private static native final int gtk_frame_get_shadow_type(long framePointer);
	private static native final void gtk_frame_set_shadow_type(long framePointer, int shadowType);

	/**
	 * Used to change the appearance of an outline
	 */
	public enum ShadowType {
		NONE(0),
		IN(1),
		OUT(2),
		ETCHED_IN(3),
		ETCHED_OUT(4);
		
		private ShadowType(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
		
		public static ShadowType getShadowType(int value) {
			for (ShadowType shadow: ShadowType.values()) {
				if (shadow.getValue() == value)
					return shadow;
			}
			return ShadowType.NONE;
		}
	}

	protected Frame(long pointer) {
		super(pointer);
	}

	/**
	 * Constructs a new frame with no label.
	 * 
	 */
	public Frame() {
		this(newFrame(null));
	}

	/**
	 * Constructs a new frame with the specified label.
	 * 
	 * @param label the text of the label.
	 */
	public Frame(String label) {
		this(newFrame(label));
	}
	
	private static long newFrame(String label) {
		lock.lock();
		try {
			return gtk_frame_new(label);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the text within the Label widget. If label is {@code null}
	 * the current label is removed.
	 * 
	 * @param label the new text of the label
	 */
	public void setLabel(String label) {
		lock.lock();
		try {
			gtk_frame_set_label(this.pointer, label);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the text from the Label widget.
	 * 
	 * @return the text in the label widget or {@code null} if there is no label widget.
	 */
	public String getLabel() {
		lock.lock();
		try {
			return gtk_frame_get_label(pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the shadow type
	 * 
	 * @param shadowType the new shadow type
	 */
	public void setShadowType(ShadowType shadowType) {
		lock.lock();
		try {
			gtk_frame_set_shadow_type(this.pointer, shadowType.getValue());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Gets the shadow type
	 * 
	 * @return the current shadow type
	 */
	public ShadowType getShadowType() {
		int type;
		lock.lock();
		try {
			type = gtk_frame_get_shadow_type(pointer);
		}
		finally {
			lock.unlock();
		}
		return ShadowType.getShadowType(type);
	}

}
