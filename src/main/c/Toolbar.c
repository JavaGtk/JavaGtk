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
#include "include/org_java_gtk_gtk_ToolBar.h"

/*
 * Class:     org_java_gtk_gtk_Toolbar
 * Method:    gtk_toolbar_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Toolbar_gtk_1toolbar_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_toolbar_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Toolbar
 * Method:    gtk_toolbar_set_style
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Toolbar_gtk_1toolbar_1set_1style
  (JNIEnv *env, jclass cls, jlong toolbar, jint style)
{
	gtk_toolbar_set_style((GtkToolbar*)toolbar, (GtkToolbarStyle)style);
}

/*
 * Class:     org_java_gtk_gtk_Toolbar
 * Method:    gtk_toolbar_insert
 * Signature: (JJI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Toolbar_gtk_1toolbar_1insert
  (JNIEnv *env, jclass cls, jlong toolbar, jlong item, jint pos)
{
	gtk_toolbar_insert((GtkToolbar*)toolbar, (GtkToolItem*)item, (gint)pos);
}
