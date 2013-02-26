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
#include "include/org_java_gtk_gtk_Frame.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_Frame
 * Method:    gtk_frame_new
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Frame_gtk_1frame_1new
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_frame_new(strLabel);
	releaseJavaString(env, label, strLabel);
	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Frame
 * Method:    gtk_frame_get_label
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Frame_gtk_1frame_1get_1label
  (JNIEnv *env, jclass cls, jlong frame)
{
	const char* strText;
	jstring text;

	strText = gtk_frame_get_label((GtkFrame*)frame);
	text = (*env)->NewStringUTF(env, strText);

	return text;
}

/*
 * Class:     org_java_gtk_gtk_Frame
 * Method:    gtk_frame_set_label
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Frame_gtk_1frame_1set_1label
  (JNIEnv *env, jclass cls, jlong frame, jstring label)
{
	const char* strText;

	strText = getJavaString(env, label);
	if (strText == NULL) return;
	gtk_frame_set_label((GtkFrame*)frame, (gchar*)strText);
	releaseJavaString(env, label, strText);
}

/*
 * Class:     org_java_gtk_gtk_Frame
 * Method:    gtk_frame_get_shadow_type
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Frame_gtk_1frame_1get_1shadow_1type
  (JNIEnv *env, jclass cls, jlong frame)
{
	return (jint)gtk_frame_get_shadow_type((GtkFrame*)frame);
}

/*
 * Class:     org_java_gtk_gtk_Frame
 * Method:    gtk_frame_set_shadow_type
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Frame_gtk_1frame_1set_1shadow_1type
  (JNIEnv *env, jclass cls, jlong frame, jint shadow)
{
	gtk_frame_set_shadow_type((GtkFrame*)frame, (GtkShadowType)shadow);
}
