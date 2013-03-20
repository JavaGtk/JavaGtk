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
#include "include/org_java_gtk_gtk_TreeView.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1new
  (JNIEnv *env, jclass cls)
{
	return (jlong)gtk_tree_view_new();
}

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_set_headers_visible
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1set_1headers_1visible
  (JNIEnv *env, jclass cls, jlong tree_view, jboolean visible)
{
	gtk_tree_view_set_headers_visible((GtkTreeView*)tree_view, (gboolean)visible);
}

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_set_model
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1set_1model
  (JNIEnv *env, jclass cls, jlong tree_view, jlong model)
{
	gtk_tree_view_set_model((GtkTreeView*)tree_view, (GtkTreeModel*)model);
}

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_get_model
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1get_1model
  (JNIEnv *env, jclass cls, jlong tree_view)
{
	return (jlong)gtk_tree_view_get_model((GtkTreeView*)tree_view);
}

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_append_column
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1append_1column
  (JNIEnv *env, jclass cls, jlong tree_view, jlong column)
{
	return (jint)gtk_tree_view_append_column((GtkTreeView*)tree_view, (GtkTreeViewColumn*)column);
}

/*
 * Class:     org_java_gtk_gtk_TreeView
 * Method:    gtk_tree_view_get_selection
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_TreeView_gtk_1tree_1view_1get_1selection
  (JNIEnv *env, jclass cls, jlong tree_view)
{
	return (jlong)gtk_tree_view_get_selection((GtkTreeView*)tree_view);
}
