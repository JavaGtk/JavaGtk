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
#include "include/org_java_gtk_gtk_Menu.h"

/*
 * Class:     org_java_gtk_gtk_Menu
 * Method:    gtk_menu_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Menu_gtk_1menu_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_menu_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Menu
 * Method:    gtk_menu_set_accel_group
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Menu_gtk_1menu_1set_1accel_1group
  (JNIEnv *env, jclass cls, jlong menu, jlong accel_group)
{
	gtk_menu_set_accel_group((GtkMenu*)menu, (GtkAccelGroup*)accel_group);
}
