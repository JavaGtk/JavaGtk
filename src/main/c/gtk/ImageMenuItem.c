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
#include "include/org_java_gtk_gtk_ImageMenuItem.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_ImageMenuItem
 * Method:    gtk_image_menu_item_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ImageMenuItem_gtk_1image_1menu_1item_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_image_menu_item_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ImageMenuItem
 * Method:    gtk_image_menu_item_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ImageMenuItem_gtk_1image_1menu_1item_1new_1with_1label
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_image_menu_item_new_with_label(strLabel);
	releaseJavaString(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ImageMenuItem
 * Method:    gtk_image_menu_item_new_with_mnemonic
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ImageMenuItem_gtk_1image_1menu_1item_1new_1with_1mnemonic
(JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_image_menu_item_new_with_mnemonic(strLabel);
	releaseJavaString(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ImageMenuItem
 * Method:    gtk_image_menu_item_new_from_stock
 * Signature: (Ljava/lang/String;J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ImageMenuItem_gtk_1image_1menu_1item_1new_1from_1stock
  (JNIEnv *env, jclass cls, jstring stock_id, jlong accel_group)
{
	const char* strStockId;
	GtkWidget* widget;

	strStockId = getJavaString(env, stock_id);
	widget = gtk_image_menu_item_new_from_stock(strStockId, (GtkAccelGroup*)accel_group);
	releaseJavaString(env, stock_id, strStockId);

	return (jlong)widget;
}
