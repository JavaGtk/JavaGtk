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
 * Class:     org_java_gtk_gtk_TreeModel
 * Method:    gtk_tree_model_get_long
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_TreeModel_gtk_1tree_1model_1get_1long
  (JNIEnv *env, jclass cls, jlong tree_model, jlong iter, jint column)
{
	glong value;

	gtk_tree_model_get((GtkTreeModel *)tree_model, (GtkTreeIter *)iter, column, &value, -1);
	return (jlong)value;
}

/*
 * Class:     org_java_gtk_gtk_TreeModel
 * Method:    gtk_tree_model_get_string
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_TreeModel_gtk_1tree_1model_1get_1string
  (JNIEnv *env, jclass cls, jlong tree_model, jlong iter, jint column)
{
	gchar* strText;
	jstring text;

	gtk_tree_model_get((GtkTreeModel *)tree_model, (GtkTreeIter *)iter, column, &strText, -1);
	text = (*env)->NewStringUTF(env, strText);
	g_free(strText);

	return text;
}
