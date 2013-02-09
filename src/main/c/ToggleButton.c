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
#include "include/org_java_gtk_gtk_ToggleButton.h"

/*
 * Class:     org_java_gtk_gtk_ToggleButton
 * Method:    gtk_toggle_button_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToggleButton_gtk_1toggle_1button_1new
  (JNIEnv *env, jclass cls)
{
	return (jlong)gtk_toggle_button_new();
}

/*
 * Class:     org_java_gtk_gtk_ToggleButton
 * Method:    gtk_toggle_button_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToggleButton_gtk_1toggle_1button_1new_1with_1label
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	GtkWidget* widget = gtk_toggle_button_new_with_label((gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ToggleButton
 * Method:    gtk_toggle_button_new_with_mnemonic
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToggleButton_gtk_1toggle_1button_1new_1with_1mnemonic
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	GtkWidget* widget = gtk_toggle_button_new_with_mnemonic((gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ToggleButton
 * Method:    gtk_toggle_button_set_active
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ToggleButton_gtk_1toggle_1button_1set_1active
  (JNIEnv *env, jclass cls, jlong toggle_button, jboolean active)
{
	gtk_toggle_button_set_active((GtkToggleButton*)toggle_button, (gboolean)active);
}

/*
 * Class:     org_java_gtk_gtk_ToggleButton
 * Method:    gtk_toggle_button_get_active
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_ToggleButton_gtk_1toggle_1button_1get_1active
  (JNIEnv *env, jclass cls, jlong toggle_button)
{
	gboolean active;
	active = gtk_toggle_button_get_active((GtkToggleButton*)toggle_button);
	return (jboolean)active;
}
