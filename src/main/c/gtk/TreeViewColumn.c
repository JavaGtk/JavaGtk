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
#include "include/org_java_gtk_gtk_TreeViewColumn.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_TreeViewColumn
 * Method:    gtk_tree_view_column_pack_start
 * Signature: (JJZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TreeViewColumn_gtk_1tree_1view_1column_1pack_1start
  (JNIEnv *env, jclass cls, jlong column, jlong renderer, jboolean expand)
{
	gtk_tree_view_column_pack_start((GtkTreeViewColumn*)column, (GtkCellRenderer*)renderer, (gboolean)expand);
}

/*
 * Class:     org_java_gtk_gtk_TreeViewColumn
 * Method:    gtk_tree_view_column_pack_end
 * Signature: (JJZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_TreeViewColumn_gtk_1tree_1view_1column_1pack_1end
  (JNIEnv *env, jclass cls, jlong column, jlong renderer, jboolean expand)
{
	gtk_tree_view_column_pack_end((GtkTreeViewColumn*)column, (GtkCellRenderer*)renderer, (gboolean)expand);
}

