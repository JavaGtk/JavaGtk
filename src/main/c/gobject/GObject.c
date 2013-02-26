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
#include "include/org_java_gtk_gobject_GObject.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gobject_GObject
 * Method:    add_toggle_ref
 * Signature: (JLorg/java_gtk/gobject/GObject;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gobject_GObject_add_1toggle_1ref
  (JNIEnv *env, jclass cls, jlong object, jobject target)
{
	jobject ref = (*env)->NewGlobalRef(env, target);
	g_object_set_data((GObject*)object, JAVA_REF, (gpointer)ref);
	g_object_add_toggle_ref((GObject*)object, toggle_java_ref, NULL);
}
