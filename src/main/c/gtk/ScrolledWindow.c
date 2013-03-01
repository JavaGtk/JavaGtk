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
#include "include/org_java_gtk_gtk_ScrolledWindow.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_ScrolledWindow
 * Method:    gtk_scrolled_window_new
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ScrolledWindow_gtk_1scrolled_1window_1new
  (JNIEnv *env, jclass cls, jlong hadjustment, jlong vadjustment)
{
	GtkWidget* widget;

	widget = gtk_scrolled_window_new((GtkAdjustment *)hadjustment, (GtkAdjustment *)vadjustment);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_ScrolledWindow
 * Method:    gtk_scrolled_window_set_policy
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ScrolledWindow_gtk_1scrolled_1window_1set_1policy
  (JNIEnv *env, jclass cls, jlong scrolled_window, jint hpolicy, jint vpolicy)
{
	gtk_scrolled_window_set_policy((GtkScrolledWindow *)scrolled_window, (GtkPolicyType)hpolicy, (GtkPolicyType)vpolicy);
}

/*
 * Class:     org_java_gtk_gtk_ScrolledWindow
 * Method:    gtk_scrolled_window_set_shadow_type
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ScrolledWindow_gtk_1scrolled_1window_1set_1shadow_1type
  (JNIEnv *env, jclass cls, jlong scrolled_window, jint shadow_type)
{
	gtk_scrolled_window_set_shadow_type((GtkScrolledWindow *)scrolled_window, (GtkShadowType)shadow_type);
}
