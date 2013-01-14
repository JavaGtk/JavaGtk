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
#include "include/org_java_gtk_gtk_Window.h"

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_new
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1new
  (JNIEnv *env, jclass cls, jint type)
{
	GtkWidget* widget;

	widget = gtk_window_new((GtkWindowType)type);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_title
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1title
  (JNIEnv *env, jclass cls, jlong window, jstring title)
{
	const char* strTitle;

	strTitle = (*env)->GetStringUTFChars(env, title, NULL);
	if (strTitle == NULL) return;
	gtk_window_set_title((GtkWindow*)window, (gchar*)strTitle);
	(*env)->ReleaseStringUTFChars(env, title, strTitle);
}

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_get_title
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1get_1title
  (JNIEnv *env, jclass cls, jlong window)
{
	const char* strTitle;
	jstring title;

	strTitle = gtk_window_get_title((GtkWindow*)window);
	title = (*env)->NewStringUTF(env, strTitle);

	return title;
}
