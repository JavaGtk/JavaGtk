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
#include "include/org_java_gtk_gtk_Gtk.h"
#include "include/jni_util.h"

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_init
 * Signature: (Ljava/lang/Object;[Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1init
  (JNIEnv *env, jclass cls, jobject _argc, jobjectArray _argv)
{
	int argc = 0;
	char **argv;

	argv = convertArgs(env, _argc, _argv, &argc);

	gtk_init(&argc, &argv);
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_init_check
 * Signature: (Ljava/lang/Object;[Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1init_1check
  (JNIEnv *env, jclass cls, jobject _argc, jobjectArray _argv)
{
	int argc = 0;
	char** argv;

	argv = convertArgs(env, _argc, _argv, &argc);

	gboolean check;
	check = gtk_init_check(&argc, &argv);
	return (jboolean)check;
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_main
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1main
  (JNIEnv *env, jclass cls)
{
	gtk_main();
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_main_iteration_do
 * Signature: (Z)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1main_1iteration_1do
  (JNIEnv *env, jclass cls, jboolean blocking)
{
	gboolean quit;
	quit = gtk_main_iteration_do((gboolean)blocking);
	return (jboolean)quit;
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_events_pending
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1events_1pending
  (JNIEnv *env, jclass cls)
{
	gboolean pending;
	pending = gtk_events_pending();
	return (jboolean)pending;
}


/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_main_quit
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1main_1quit
  (JNIEnv *env, jclass cls)
{
	gtk_main_quit();
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    g_object_cleanup
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_g_1object_1cleanup
  (JNIEnv *env, jclass cls, jlong object)
{
	if (g_object_is_floating((gpointer)object))
		g_object_ref_sink((gpointer)object);
	g_object_unref((gpointer)object);
}

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    g_signal_handler_disconnect
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_g_1signal_1handler_1disconnect
  (JNIEnv *env, jclass cls, jlong instance, jlong handler_id)
{
	g_signal_handler_disconnect((gpointer)instance, (gulong)handler_id);
}
