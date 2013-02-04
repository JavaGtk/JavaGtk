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

void widget_destroy_handler(GtkWidget *widget, gpointer data) {
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
	connect_callback((gpointer)instance, "destroy", G_CALLBACK(widget_destroy_handler), c);

}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_size_request
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1size_1request
  (JNIEnv *env, jclass cls, jlong widget, jint width, jint height)
{
	gtk_widget_set_size_request((GtkWidget*)widget, (gint)width, (gint)height);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_accel_path
 * Signature: (JLjava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1accel_1path
  (JNIEnv *env, jclass cls, jlong widget, jstring path, jlong accel_group)
{
	const char* strPath;

	strPath = (*env)->GetStringUTFChars(env, path, NULL);
	gtk_widget_set_accel_path((GtkWidget*)widget, strPath, (GtkAccelGroup*)accel_group);
	(*env)->ReleaseStringUTFChars(env, path, strPath);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_show
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1show
  (JNIEnv *env, jclass cls, jlong widget)
{
	gtk_widget_show((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_hide
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1hide
  (JNIEnv *env, jclass cls, jlong widget)
{
	gtk_widget_hide((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_name
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1name
  (JNIEnv *env, jclass cls, jlong widget)
{
	const char* strName;
	jstring name;

	strName = gtk_widget_get_name((GtkWidget*)widget);
	name = (*env)->NewStringUTF(env, strName);

	return name;
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_name
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1name
  (JNIEnv *env, jclass cls, jlong widget, jstring name)
{
	const char* strName;

	strName = (*env)->GetStringUTFChars(env, name, NULL);
	if (strName == NULL) return;
	gtk_widget_set_name((GtkWidget*)widget, (gchar*)strName);
	(*env)->ReleaseStringUTFChars(env, name, strName);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_sensitive
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1sensitive
  (JNIEnv *env, jclass cls, jlong widget)
{
	gboolean sensitive;
	sensitive = gtk_widget_get_sensitive((GtkWidget*)widget);
	return (jboolean)sensitive;
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_sensitive
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1sensitive
  (JNIEnv *env, jclass cls, jlong widget, jboolean sensitive)
{
	gtk_widget_set_sensitive((GtkWidget*)widget, (gboolean)sensitive);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_halign
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1halign
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_halign((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_halign
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1halign
  (JNIEnv *env, jclass cls, jlong widget, jint align)
{
	gtk_widget_set_halign((GtkWidget*)widget, (GtkAlign)align);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_valign
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1valign
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_valign((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_valign
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1valign
  (JNIEnv *env, jclass cls, jlong widget, jint align)
{
	gtk_widget_set_valign((GtkWidget*)widget, (GtkAlign)align);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_left
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1left
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_margin_left((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_left
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1left
  (JNIEnv *env, jclass cls, jlong widget, jint margin)
{
	gtk_widget_set_margin_left((GtkWidget*)widget, (gint)margin);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_right
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1right
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_margin_right((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_right
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1right
  (JNIEnv *env, jclass cls, jlong widget, jint margin)
{
	gtk_widget_set_margin_right((GtkWidget*)widget, (gint)margin);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_top
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1top
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_margin_top((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_top
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1top
  (JNIEnv *env, jclass cls, jlong widget, jint margin)
{
	gtk_widget_set_margin_top((GtkWidget*)widget, (gint)margin);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_bottom
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1bottom
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jint)gtk_widget_get_margin_bottom((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_bottom
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1bottom
  (JNIEnv *env, jclass cls, jlong widget, jint margin)
{
	gtk_widget_set_margin_bottom((GtkWidget*)widget, (gint)margin);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_hexpand
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1hexpand
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jboolean)gtk_widget_get_hexpand((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_hexpand
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1hexpand
  (JNIEnv *env, jclass cls, jlong widget, jboolean expand)
{
	gtk_widget_set_hexpand((GtkWidget*)widget, (gboolean)expand);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_vexpand
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1vexpand
  (JNIEnv *env, jclass cls, jlong widget)
{
	return (jboolean)gtk_widget_get_vexpand((GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_vexpand
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1vexpand
  (JNIEnv *env, jclass cls, jlong widget, jboolean expand)
{
	gtk_widget_set_vexpand((GtkWidget*)widget, (gboolean)expand);
}
