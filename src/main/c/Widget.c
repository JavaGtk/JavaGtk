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
#include "include/org_java_gtk_gtk_Widget.h"
#include "include/jni_util.h"

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_show_all
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1show_1all
  (JNIEnv* env, jclass cls, jlong widget)
{
	gtk_widget_show_all((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1destroy
  (JNIEnv *env, jclass cls, jlong widget)
{
	gtk_widget_destroy((GtkWidget*)widget);
}

void delete_event_handler(GtkWidget *widget, GdkEvent *event, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticBooleanMethod(c->env, c->receiver, c->id, c->handler, widget, event);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_delete_event_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/DeleteEventHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1delete_1event_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jobject receiver)
{
	callback *c;
	c = create_callback(env, handler, receiver, "deleteEventReceiver", "(Lorg/java_gtk/gtk/Widget$DeleteEventHandler;JJ)Z");
	connect_callback((gpointer)instance, "delete-event", G_CALLBACK(delete_event_handler), c);
}

void destroy_handler(GtkWidget *widget, gpointer data) {
	callback *c = data;
	callback_start(c);
	(*c->env)->CallStaticVoidMethod(c->env, c->receiver, c->id, c->handler, widget);
	callback_end(c);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_destroy_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/DestroyHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1destroy_1handler
  (JNIEnv *env, jclass cls, jlong instance, jobject handler, jobject receiver)
{
	callback *c;
	c = create_callback(env, handler, receiver, "destroyReceiver", "(Lorg/java_gtk/gtk/Widget$DestroyHandler;J)V");
	connect_callback((gpointer)instance, "destroy", G_CALLBACK(destroy_handler), c);

}
