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
#include "include/org_java_gtk_gtk_Container.h"

/*
 * Class:     org_java_gtk_gtk_Container
 * Method:    gtk_container_add
 * Signature: (Lorg/java_gtk/gtk/Widget;)J
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Container_gtk_1container_1add
  (JNIEnv *env, jclass cls, jlong container, jlong widget)
{
	gtk_container_add((GtkContainer*)container, (GtkWidget*)widget);
}

/*
 * Class:     org_java_gtk_gtk_Container
 * Method:    gtk_container_set_border_width
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Container_gtk_1container_1set_1border_1width
  (JNIEnv *env, jclass cls, jlong container, jint width)
{
	gtk_container_set_border_width((GtkContainer*)container, (guint)width);
}

/*
 * Class:     org_java_gtk_gtk_Container
 * Method:    gtk_container_get_border_width
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Container_gtk_1container_1get_1border_1width
  (JNIEnv *env, jclass cls, jlong container)
{
	return (jint)gtk_container_get_border_width((GtkContainer*)container);
}

/*
 * Class:     org_java_gtk_gtk_Container
 * Method:    gtk_container_get_children
 * Signature: (J)[J
 */
JNIEXPORT jlongArray JNICALL Java_org_java_1gtk_gtk_Container_gtk_1container_1get_1children
  (JNIEnv *env, jclass cls, jlong container)
{
	GList *children = gtk_container_get_children((GtkContainer*)container);
	int size = g_list_length(children);
	jlongArray array = (*env)->NewLongArray(env, size);
	jlong* arr = (jlong*)(*env)->GetLongArrayElements(env, array, NULL);

	for (int i = 0; i < size; i++) {
		arr[i] = (jlong) children->data;
		children = children->next;
	}
	(*env)->ReleaseLongArrayElements(env, array, arr, 0);

	return array;
}

