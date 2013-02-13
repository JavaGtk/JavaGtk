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
#include "include/org_java_gtk_gtk_Button.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1new
  (JNIEnv *env, jclass cls)
{
	return (jlong)gtk_button_new();
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1new_1with_1label
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	GtkWidget* widget = gtk_button_new_with_label((gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_new_with_mnemonic
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1new_1with_1mnemonic
  (JNIEnv *env, jclass cls, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	GtkWidget* widget = gtk_button_new_with_mnemonic((gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_new_from_stock
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1new_1from_1stock
  (JNIEnv *env, jclass cls, jstring stock_id)
{
	const char* strStockId;
	GtkWidget* widget;

	strStockId = (*env)->GetStringUTFChars(env, stock_id, NULL);
	widget = gtk_button_new_from_stock(strStockId);
	(*env)->ReleaseStringUTFChars(env, stock_id, strStockId);

	return (jlong)widget;
}


void button_clicked_event_handler(GtkWidget *widget, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticVoidMethod(c->env, c->receiver, c->id, c->handler, widget);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_add_clicked_event_handler
 * Signature: (JLorg/java_gtk/gtk/Button/ClickedEventHandler;Lorg/java_gtk/gtk/Button;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1add_1clicked_1event_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jclass receiver)
{
	callback *c;
	long handle_id;
	c = create_callback(env, handler, receiver, "clickedEventReceiver", "(Lorg/java_gtk/gtk/Button$ClickedEventHandler;J)V");
	handle_id = (long)connect_callback((gpointer)instance, "clicked", G_CALLBACK(button_clicked_event_handler), c);
	update_handle(env, handler, "setHandleId", "(J)V", handle_id);
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_get_label
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1get_1label
  (JNIEnv *env, jclass cls, jlong button)
{
	const char* strLabel;
	jstring label;

	strLabel = gtk_button_get_label((GtkButton*)button);
	label = (*env)->NewStringUTF(env, strLabel);

	return label;
}

/*
 * Class:     org_java_gtk_gtk_Button
 * Method:    gtk_button_set_label
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Button_gtk_1button_1set_1label
  (JNIEnv *env, jclass cls, jlong button, jstring label)
{
	const char* strLabel;

	strLabel = (*env)->GetStringUTFChars(env, label, NULL);
	if (strLabel == NULL) return;
	gtk_button_set_label((GtkButton*)button, (gchar*)strLabel);
	(*env)->ReleaseStringUTFChars(env, label, strLabel);
}
