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
#include "include/org_java_gtk_gtk_MenuItem.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_menu_item_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1new_1with_1label
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	widget = gtk_menu_item_new_with_label(strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_new_with_mnemonic
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1new_1with_1mnemonic
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	widget = gtk_menu_item_new_with_mnemonic(strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_set_label
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1set_1label
  (JNIEnv *env, jclass cls, jlong menu_item, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	if (strLabel == NULL) return;
	gtk_menu_item_set_label((GtkMenuItem*)menu_item, (gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_get_label
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1get_1label
  (JNIEnv *env, jclass cls, jlong menu_item)
{
	const char* strLabel;
	jstring label;

	strLabel = gtk_menu_item_get_label((GtkMenuItem*)menu_item);
	label = (*env)->NewStringUTF(env, strLabel);

	return label;
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_set_submenu
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1set_1submenu
  (JNIEnv *env, jclass cls, jlong menu_item, jlong submenu)
{
	gtk_menu_item_set_submenu((GtkMenuItem*)menu_item, (GtkWidget*)submenu);
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_get_submenu
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1get_1submenu
  (JNIEnv *env, jclass cls, jlong menu_item)
{
	GtkWidget *submenu;
	submenu = gtk_menu_item_get_submenu((GtkMenuItem*)menu_item);
	return (jlong)submenu;
}

void menu_item_activated_event_handler(GtkWidget *widget, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticVoidMethod(c->env, c->receiver, c->id, c->handler, widget);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_add_activated_event_handler
 * Signature: (JLorg/java_gtk/gtk/MenuItem/ActivatedEventHandler;Lorg/java_gtk/gtk/MenuItem;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1add_1activated_1event_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jclass receiver)
{
	callback *c;
	long handle_id;
	c = create_callback(env, handler, receiver, "activatedEventReceiver", "(Lorg/java_gtk/gtk/MenuItem$ActivatedEventHandler;J)V");
	handle_id = connect_callback((gpointer)instance, "activate", G_CALLBACK(menu_item_activated_event_handler), c);
	update_handle(env, handler, "setHandleId", "(J)V", handle_id);
}
