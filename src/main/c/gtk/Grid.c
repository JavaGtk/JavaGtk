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
#include "include/org_java_gtk_gtk_Grid.h"

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_grid_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_attach
 * Signature: (JJIIII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1attach
  (JNIEnv *env, jclass cls, jlong grid, jlong child, jint left, jint top, jint width, jint height)
{
	gtk_grid_attach((GtkGrid*)grid, (GtkWidget*)child, (gint)left, (gint)top, (gint)width, (gint)height);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_set_row_spacing
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1set_1row_1spacing
  (JNIEnv *env, jclass cls, jlong grid, jint spacing)
{
	gtk_grid_set_row_spacing((GtkGrid*)grid, (gint)spacing);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_get_row_spacing
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1get_1row_1spacing
  (JNIEnv *env, jclass cls, jlong grid)
{
	return (jint)gtk_grid_get_row_spacing((GtkGrid*)grid);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_set_column_spacing
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1set_1column_1spacing
(JNIEnv *env, jclass cls, jlong grid, jint spacing)
{
	gtk_grid_set_column_spacing((GtkGrid*)grid, (gint)spacing);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_get_column_spacing
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1get_1column_1spacing
(JNIEnv *env, jclass cls, jlong grid)
{
	return (jint)gtk_grid_get_column_spacing((GtkGrid*)grid);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_set_row_homogeneous
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1set_1row_1homogeneous
  (JNIEnv *env, jclass cls, jlong grid, jboolean homogeneous)
{
	gtk_grid_set_row_homogeneous((GtkGrid*)grid, (gboolean)homogeneous);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_get_row_homogeneous
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1get_1row_1homogeneous
  (JNIEnv *env, jclass cls, jlong grid)
{
	return (jboolean)gtk_grid_get_row_homogeneous((GtkGrid*)grid);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_set_column_homogeneous
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1set_1column_1homogeneous
  (JNIEnv *env, jclass cls, jlong grid, jboolean homogeneous)
{
	gtk_grid_set_column_homogeneous((GtkGrid*)grid, (gboolean)homogeneous);
}

/*
 * Class:     org_java_gtk_gtk_Grid
 * Method:    gtk_grid_get_column_homogeneous
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Grid_gtk_1grid_1get_1column_1homogeneous
  (JNIEnv *env, jclass cls, jlong grid)
{
	return (jboolean)gtk_grid_get_column_homogeneous((GtkGrid*)grid);
}
