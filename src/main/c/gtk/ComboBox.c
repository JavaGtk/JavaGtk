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
 * Class:     org_java_gtk_gtk_ComboBox
 * Method:    gtk_combo_box_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ComboBox_gtk_1combo_1box_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_combo_box_new();

	return (jlong)widget;
}

void combo_box_changed_event_handler(GtkComboBox *widget, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticVoidMethod(c->env, c->receiver, c->id, c->handler, widget);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_ComboBox
 * Method:    gtk_combo_box_add_changed_event_handler
 * Signature: (JLorg/java_gtk/gtk/ComboBox/ChangedEventHandler;Ljava/lang/Class;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ComboBox_gtk_1combo_1box_1add_1changed_1event_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jclass receiver)
{
	callback *c;
	long handle_id;
	c = create_callback(env, handler, receiver, "changedEventReceiver", "(Lorg/java_gtk/gtk/ComboBox$ChangedEventHandler;J)V");
	handle_id = (long)connect_callback((gpointer)instance, "changed", G_CALLBACK(combo_box_changed_event_handler), c);
	update_handle(env, handler, "setHandleId", "(J)V", handle_id);
}

