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

import org.java_gtk.gdk.Pixbuf;
import org.java_gtk.util.ObjectCache;

/**
 * AboutDialog offers a simple way to display information about a program.
 * 
 * @author Bill
 *
 */
public class AboutDialog extends Dialog {
	
	private static native final long gtk_about_dialog_new();
	private static native final String gtk_about_dialog_get_program_name(long dialogPointer);
	private static native final void gtk_about_dialog_set_program_name(long dialogPointer, String name);
	private static native final String gtk_about_dialog_get_version(long dialogPointer);
	private static native final void gtk_about_dialog_set_version(long dialogPointer, String version);
	private static native final String gtk_about_dialog_get_copyright(long dialogPointer);
	private static native final void gtk_about_dialog_set_copyright(long dialogPointer, String copyright);
	private static native final String gtk_about_dialog_get_comments(long dialogPointer);
	private static native final void gtk_about_dialog_set_comments(long dialogPointer, String comments);
	private static native final String gtk_about_dialog_get_website(long dialogPointer);
	private static native final void gtk_about_dialog_set_website(long dialogPointer, String website);
	private static native final long gtk_about_dialog_get_logo(long dialogPointer);
	private static native final void gtk_about_dialog_set_logo(long dialogPointer, long pixbufPointer);

	protected AboutDialog(long pointer) {
		super(pointer);
	}
	
	/**
	 * Constructs a new dialog box.
	 */
	public AboutDialog () {
		this(newAboutDialog());
	}
		
	private static long newAboutDialog() {
		lock.lock();
		try {
			return gtk_about_dialog_new();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the name to display in the about dialog.
	 * 
	 * @param name the program name
	 */
	public void setProgramName(String name) {
		lock.lock();
		try {
			gtk_about_dialog_set_program_name(this.pointer, name);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the program name displayed in the about dialog.
	 * 
	 * @return The program name.
	 */
	public String getProgramName() {
		lock.lock();
		try {
			return gtk_about_dialog_get_program_name(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}

	/**
	 * Sets the version to display in the about dialog.
	 * 
	 * @param version the version
	 */
	public void setVersion(String version) {
		lock.lock();
		try {
			gtk_about_dialog_set_version(this.pointer, version);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the version displayed in the about dialog.
	 * 
	 * @return The version.
	 */
	public String getVersion() {
		lock.lock();
		try {
			return gtk_about_dialog_get_version(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the copyright to display in the about dialog.
	 * 
	 * @param copyright the copyright
	 */
	public void setCopyright(String copyright) {
		lock.lock();
		try {
			gtk_about_dialog_set_copyright(this.pointer, copyright);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the copyright displayed in the about dialog.
	 * 
	 * @return The copyright.
	 */
	public String getCopyright() {
		lock.lock();
		try {
			return gtk_about_dialog_get_copyright(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the comments to display in the about dialog.
	 * 
	 * @param comments the comments
	 */
	public void setComments(String comments) {
		lock.lock();
		try {
			gtk_about_dialog_set_comments(this.pointer, comments);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the comments displayed in the about dialog.
	 * 
	 * @return The comments.
	 */
	public String getComments() {
		lock.lock();
		try {
			return gtk_about_dialog_get_comments(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the website to display in the about dialog.
	 * 
	 * @param website the website
	 */
	public void setWebsite(String website) {
		lock.lock();
		try {
			gtk_about_dialog_set_website(this.pointer, website);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the website displayed in the about dialog.
	 * 
	 * @return The website.
	 */
	public String getWebsite() {
		lock.lock();
		try {
			return gtk_about_dialog_get_website(this.pointer);
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Sets the logo to display in the about dialog.  If it is {@code null}
	 * then display the default window icon.
	 * 
	 * @param logo a {@code Pixbuf} or {@code null}
	 */
	public void setLogo(Pixbuf logo) {
		lock.lock();
		try {
			gtk_about_dialog_set_logo(this.pointer, logo.getPointer());
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns the logo displayed in the about dialog.
	 * 
	 * @return The logo.
	 */
	public Pixbuf getLogo() {
		long logoPointer;
		lock.lock();
		try {
			logoPointer = gtk_about_dialog_get_logo(this.pointer);
		}
		finally {
			lock.unlock();
		}
		return (Pixbuf)ObjectCache.lookup(logoPointer);
	}

}
