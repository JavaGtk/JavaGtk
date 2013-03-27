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
#include "include/org_java_gtk_gtk_ListStore.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_new
 * Signature: (I[I)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1new
  (JNIEnv *env, jclass cls, jint num_columns, jlongArray column_types)
{
	GtkListStore *list_store;

	jlong *types = (*env)->GetLongArrayElements(env, column_types, 0);
	list_store = gtk_list_store_newv((gint)num_columns, (GType *)types);
	(*env)->ReleaseLongArrayElements(env, column_types, types, 0);

	return (jlong)list_store;
}

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_append
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1append
  (JNIEnv *env, jclass cls, jlong list_store, jlong iter)
{
	gtk_list_store_append((GtkListStore *)list_store, (GtkTreeIter *)iter);
}

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_remove
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1remove
  (JNIEnv *env, jclass cls, jlong list_store, jlong iter)
{
	gboolean value;
	value = gtk_list_store_remove((GtkListStore *)list_store, (GtkTreeIter *)iter);
	return (jboolean)value;
}

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_clear
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1clear
  (JNIEnv *env, jclass cls, jlong list_store)
{
	gtk_list_store_clear((GtkListStore *)list_store);
}

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_set_string
 * Signature: (JJILjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1set_1string
  (JNIEnv *env, jclass cls, jlong list_store, jlong iter, jint column, jstring value)
{
	const char* strValue;
	GValue val = G_VALUE_INIT;

	strValue = getJavaString(env, value);
	g_value_init(&val, G_TYPE_STRING);
	g_value_set_string(&val, strValue);
	releaseJavaString(env, value, strValue);

	gtk_list_store_set_value((GtkListStore *)list_store, (GtkTreeIter *)iter, (gint)column, &val);

	g_value_unset(&val);
}

/*
 * Class:     org_java_gtk_gtk_ListStore
 * Method:    gtk_list_store_set_pixbuf
 * Signature: (JJIJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ListStore_gtk_1list_1store_1set_1pixbuf
  (JNIEnv *env, jclass cls, jlong list_store, jlong iter, jint column, jlong value)
{
	GValue val = G_VALUE_INIT;

	g_value_init(&val, GDK_TYPE_PIXBUF);
	g_value_set_object(&val, (gpointer)value);

	gtk_list_store_set_value((GtkListStore *)list_store, (GtkTreeIter *)iter, (gint)column, &val);

	g_value_unset(&val);
}
