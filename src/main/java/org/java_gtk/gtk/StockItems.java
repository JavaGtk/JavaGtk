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
 * Prebuilt common menu/toolbar items and corresponding icons
 * 
 * @author Bill
 *
 */
public enum StockItems {

	ABOUT("gtk-about"),
	ADD("gtk-add"),
	APPLY("gtk-apply"),
	BOLD("gtk-bold"),
	CANCEL("gtk-cancel"),
	CAPS_LOCK_WARNING("gtk-caps-lock-warning"),
	CDROM("gtk-cdrom"),
	CLEAR("gtk-clear"),
	CLOSE("gtk-close"),
	COLOR_PICKER("gtk-color-picker"),
	CONNECT("gtk-connect"),
	CONVERT("gtk-convert"),
	COPY("gtk-copy"),
	CUT("gtk-cut"),
	DELETE("gtk-delete"),
	DIALOG_AUTHENTICATION("gtk-dialog-authentication"),
	DIALOG_ERROR("gtk-dialog-error"),
	DIALOG_INFO("gtk-dialog-info"),
	DIALOG_QUESTION("gtk-dialog-question"),
	DIALOG_WARNING("gtk-dialog-warning"),
	DIRECTORY("gtk-directory"),
	DISCARD("gtk-discard"),
	DISCONNECT("gtk-disconnect"),
	DND("gtk-dnd"),
	DND_MULTIPLE("gtk-dnd-multiple"),
	EDIT("gtk-edit"),
	EXECUTE("gtk-execute"),
	FILE("gtk-file"),
	FIND("gtk-find"),
	FIND_AND_REPLACE("gtk-find-and-replace"),
	FLOPPY("gtk-floppy"),
	FULLSCREEN("gtk-fullscreen"),
	GOTO_BOTTOM("gtk-goto-bottom"),
	GOTO_FIRST("gtk-goto-first"),
	GOTO_LAST("gtk-goto-last"),
	GOTO_TOP("gtk-goto-top"),
	GO_BACK("gtk-go-back"),
	GO_DOWN("gtk-go-down"),
	GO_FORWARD("gtk-go-forward"),
	GO_UP("gtk-go-up"),
	HARDDISK("gtk-harddisk"),
	HELP("gtk-help"),
	HOME("gtk-home"),
	INDEX("gtk-index"),
	INDENT("gtk-indent"),
	INFO("gtk-info"),
	ITALIC("gtk-italic"),
	JUMP_TO("gtk-jump-to"),
	JUSTIFY_CENTER("gtk-justify-center"),
	JUSTIFY_FILL("gtk-justify-fill"),
	JUSTIFY_LEFT("gtk-justify-left"),
	JUSTIFY_RIGHT("gtk-justify-right"),
	LEAVE_FULLSCREEN("gtk-leave-fullscreen"),
	MISSING_IMAGE("gtk-missing-image"),
	MEDIA_FORWARD("gtk-media-forward"),
	MEDIA_NEXT("gtk-media-next"),
	MEDIA_PAUSE("gtk-media-pause"),
	MEDIA_PLAY("gtk-media-play"),
	MEDIA_PREVIOUS("gtk-media-previous"),
	MEDIA_RECORD("gtk-media-record"),
	MEDIA_REWIND("gtk-media-rewind"),
	MEDIA_STOP("gtk-media-stop"),
	NETWORK("gtk-network"),
	NEW("gtk-new"),
	NO("gtk-no"),
	OK("gtk-ok"),
	OPEN("gtk-open"),
	ORIENTATION_PORTRAIT("gtk-orientation-portrait"),
	ORIENTATION_LANDSCAPE("gtk-orientation-landscape"),
	ORIENTATION_REVERSE_LANDSCAPE("gtk-orientation-reverse-landscape"),
	ORIENTATION_REVERSE_PORTRAIT("gtk-orientation-reverse-portrait"),
	PAGE_SETUP("gtk-page-setup"),
	PASTE("gtk-paste"),
	PREFERENCES("gtk-preferences"),
	PRINT("gtk-print"),
	PRINT_ERROR("gtk-print-error"),
	PRINT_PAUSED("gtk-print-paused"),
	PRINT_PREVIEW("gtk-print-preview"),
	PRINT_REPORT("gtk-print-report"),
	PRINT_WARNING("gtk-print-warning"),
	PROPERTIES("gtk-properties"),
	QUIT("gtk-quit"),
	REDO("gtk-redo"),
	REFRESH("gtk-refresh"),
	REMOVE("gtk-remove"),
	REVERT_TO_SAVED("gtk-revert-to-saved"),
	SAVE("gtk-save"),
	SAVE_AS("gtk-save-as"),
	SELECT_ALL("gtk-select-all"),
	SELECT_COLOR("gtk-select-color"),
	SELECT_FONT("gtk-select-font"),
	SORT_ASCENDING("gtk-sort-ascending"),
	SORT_DESCENDING("gtk-sort-descending"),
	SPELL_CHECK("gtk-spell-check"),
	STOP("gtk-stop"),
	STRIKETHROUGH("gtk-strikethrough"),
	UNDELETE("gtk-undelete"),
	UNDERLINE("gtk-underline"),
	UNDO("gtk-undo"),
	UNINDENT("gtk-unindent"),
	YES("gtk-yes"),
	ZOOM_100("gtk-zoom-100"),
	ZOOM_FIT("gtk-zoom-fit"),
	ZOOM_IN("gtk-zoom-in"),
	ZOOM_OUT("gtk-zoom-out");
	
	private StockItems(String value) {
		this.value = value;
	}
	
	private String value;
	
	public String getValue() {
		return value;
	}

}
