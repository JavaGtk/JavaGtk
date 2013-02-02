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
 * A Statusbar is usually placed along the bottom of an application's main 
 * Window. It may provide a regular commentary of the application's status 
 * (as is usually the case in a web browser, for example), or may be used 
 * to simply output a message when the status changes, (when an upload is 
 * complete in an FTP client, for example). 
 * <p>
 * Status bars in GTK+ maintain a stack of messages. The message at the top 
 * of the each bar's stack is the one that will currently be displayed. 
 * <p>
 * Any messages added to a statusbar's stack must specify a context id that 
 * is used to uniquely identify the source of a message. This context id can 
 * be generated by getContextId(), given a message and the statusbar that it 
 * will be added to. Note that messages are stored in a stack, and when 
 * choosing which message to display, the stack structure is adhered to, 
 * regardless of the context identifier of a message. 
 * 
 * @author Bill
 *
 */
public class StatusBar extends Box {
	
	private static native final long gtk_statusbar_new();

	/**
	 * Constructs a StatusBar.
	 */
	public StatusBar() {
		super(newStatusBar());
	}
	
	private static long newStatusBar() {
		lock.lock();
		try {
			return gtk_statusbar_new();
		}
		finally {
			lock.unlock();
		}
	}

}