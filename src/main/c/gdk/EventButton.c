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
#include "include/org_java_gtk_gdk_EventButton.h"

/*
 * Class:     org_java_gtk_gdk_EventButton
 * Method:    gtk_event_button_get_x_root
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_java_1gtk_gdk_EventButton_gtk_1event_1button_1get_1x_1root
  (JNIEnv *env, jclass cls, jlong event)
{
	return (jdouble)((GdkEventButton*)event)->x_root;
}

/*
 * Class:     org_java_gtk_gdk_EventButton
 * Method:    gtk_event_button_get_y_root
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_java_1gtk_gdk_EventButton_gtk_1event_1button_1get_1y_1root
(JNIEnv *env, jclass cls, jlong event)
{
	return (jdouble)((GdkEventButton*)event)->y_root;
}

/*
 * Class:     org_java_gtk_gdk_EventButton
 * Method:    gtk_event_button_get_time
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gdk_EventButton_gtk_1event_1button_1get_1time
(JNIEnv *env, jclass cls, jlong event)
{
	return (jlong)((GdkEventButton*)event)->time;
}

/*
 * Class:     org_java_gtk_gdk_EventButton
 * Method:    gtk_event_button_get_button
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gdk_EventButton_gtk_1event_1button_1get_1button
(JNIEnv *env, jclass cls, jlong event)
{
	return (jint)((GdkEventButton*)event)->button;
}
