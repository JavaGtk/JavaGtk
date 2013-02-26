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
#include "include/org_java_gtk_gtk_CheckMenuItem.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_CheckMenuItem
 * Method:    gtk_check_menu_item_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_CheckMenuItem_gtk_1check_1menu_1item_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_check_menu_item_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_CheckMenuItem
 * Method:    gtk_check_menu_item_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_CheckMenuItem_gtk_1check_1menu_1item_1new_1with_1label
(JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_check_menu_item_new_with_label(strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_CheckMenuItem
 * Method:    gtk_check_menu_item_new_with_mnemonic
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_CheckMenuItem_gtk_1check_1menu_1item_1new_1with_1mnemonic
(JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_check_menu_item_new_with_mnemonic(strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_CheckMenuItem
 * Method:    gtk_check_menu_item_set_active
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_CheckMenuItem_gtk_1check_1menu_1item_1set_1active
  (JNIEnv *env, jclass cls, jlong check_menu_item, jboolean active)
{
	gtk_check_menu_item_set_active((GtkCheckMenuItem*)check_menu_item, (gboolean)active);
}

/*
 * Class:     org_java_gtk_gtk_CheckMenuItem
 * Method:    gtk_check_menu_item_get_active
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_CheckMenuItem_gtk_1check_1menu_1item_1get_1active
  (JNIEnv *env, jclass cls, jlong check_menu_item)
{
	gboolean active;
	active = gtk_check_menu_item_get_active((GtkCheckMenuItem*)check_menu_item);
	return (jboolean)active;
}
