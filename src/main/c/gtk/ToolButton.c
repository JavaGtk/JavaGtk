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
#include "include/org_java_gtk_gtk_ToolButton.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_new
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1new
  (JNIEnv *env, jclass cls, jlong icon, jstring label)
{
	const char* strLabel;
	GtkToolItem* widget;

	strLabel = getJavaString(env, label);
	widget = gtk_tool_button_new((GtkWidget*)icon, strLabel);
	releaseJavaString(env, label, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_new_from_stock
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1new_1from_1stock
  (JNIEnv *env, jclass cls, jstring stock_id)
{
	const char* strStockId;
	GtkToolItem* widget;

	strStockId = getJavaString(env, stock_id);
	widget = gtk_tool_button_new_from_stock(strStockId);
	releaseJavaString(env, stock_id, strStockId);

	return (jlong)widget;
}

void tool_button_clicked_event_handler(GtkWidget *widget, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticVoidMethod(c->env, c->receiver, c->id, c->handler, widget);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_add_clicked_event_handler
 * Signature: (JLorg/java_gtk/gtk/ToolButton/ClickedEventHandler;Lorg/java_gtk/gtk/ToolButton;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1add_1clicked_1event_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jclass receiver)
{
	callback *c;
	long handle_id;
	c = create_callback(env, handler, receiver, "clickedEventReceiver", "(Lorg/java_gtk/gtk/ToolButton$ClickedEventHandler;J)V");
	handle_id = connect_callback((gpointer)instance, "clicked", G_CALLBACK(tool_button_clicked_event_handler), c);
	update_handle(env, handler, "setHandleId", "(J)V", handle_id);
}
