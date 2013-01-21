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

/*
 * Class:     org_java_gtk_gtk_Gtk
 * Method:    gtk_init
 * Signature: (Ljava/lang/Object;[Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Gtk_gtk_1init
  (JNIEnv *env, jclass cls, jobject _argc, jobjectArray _argv)
{
	int argc;
	char** argv;

	if (_argv == NULL) {
		argc = 0;
	} else {
		argc = (*env)->GetArrayLength(env, _argv);
	}
	argv = (char**) g_newa(char**, argc+1);

	for (int i=0; i<argc; i++) {
		jstring string = (jstring)(*env)->GetObjectArrayElement(env, _argv, i);
		const char* rawString = (*env)->GetStringUTFChars(env, string, 0);
		argv[i+1] = g_strdup(rawString);
		(*env)->ReleaseStringUTFChars(env, string, rawString);
	}

	argv[0] = "";
	argc++;

	gtk_init(&argc, &argv);
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
