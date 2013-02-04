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

#include <jni.h>
#include <gtk/gtk.h>
#include "include/org_java_gtk_gtk_TextView.h"

/*
 * Class:     org_java_gtk_gtk_TextView
 * Method:    gtk_text_view_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_TextView_gtk_1text_1view_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_text_view_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_TextView
 * Method:    gtk_text_view_set_editable
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TextView_gtk_1text_1view_1set_1editable
  (JNIEnv *env, jclass cls, jlong textview, jboolean editable)
{
	gtk_text_view_set_editable((GtkTextView*)textview, (gboolean)editable);
}

/*
 * Class:     org_java_gtk_gtk_TextView
 * Method:    gtk_text_view_get_editable
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_TextView_gtk_1text_1view_1get_1editable
  (JNIEnv *env, jclass cls, jlong textview)
{
	return (jboolean)gtk_text_view_get_editable((GtkTextView*)textview);
}

/*
 * Class:     org_java_gtk_gtk_TextView
 * Method:    gtk_text_view_set_cursor_visible
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TextView_gtk_1text_1view_1set_1cursor_1visible
  (JNIEnv *env, jclass cls, jlong textview, jboolean visible)
{
	gtk_text_view_set_cursor_visible((GtkTextView*)textview, (gboolean)visible);
}

/*
 * Class:     org_java_gtk_gtk_TextView
 * Method:    gtk_text_view_get_cursor_visible
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_TextView_gtk_1text_1view_1get_1cursor_1visible
  (JNIEnv *env, jclass cls, jlong textview)
{
	return (jboolean)gtk_text_view_get_cursor_visible((GtkTextView*)textview);
}
