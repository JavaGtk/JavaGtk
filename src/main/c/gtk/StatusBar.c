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
#include "include/org_java_gtk_gtk_StatusBar.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_statusbar_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_push
 * Signature: (JILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1push
  (JNIEnv *env, jclass cls, jlong statusbar, jint context_id, jstring text)
{
	const char* strText;
	guint message_id;

	strText = getJavaString(env, text);
	message_id = gtk_statusbar_push((GtkStatusbar*)statusbar, (guint)context_id, (const gchar*)strText);
	releaseJavaString(env, text, strText);
	return (jint)message_id;
}

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_pop
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1pop
  (JNIEnv *env, jclass cls, jlong statusbar, jint context_id)
{
	gtk_statusbar_pop((GtkStatusbar*)statusbar, (guint)context_id);
}

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_get_context_id
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1get_1context_1id
  (JNIEnv *env, jclass cls, jlong statusbar, jstring text)
{
	const char* strText;
	guint context_id;

	strText = getJavaString(env, text);
	context_id = gtk_statusbar_get_context_id((GtkStatusbar*)statusbar, (const gchar*)strText);
	releaseJavaString(env, text, strText);
	return (jint)context_id;
}
