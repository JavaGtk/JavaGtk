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
#include "include/org_java_gtk_gtk_Box.h"
#include "include/jni_util.h"

/*
 * Class:     org_java_gtk_gtk_Box
 * Method:    gtk_box_new
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Box_gtk_1box_1new
  (JNIEnv *env, jclass cls, jint orientation, jint spacing)
{
	GtkWidget* widget;

	widget = gtk_box_new((GtkOrientation)orientation, (int)spacing);

	return (jlong)widget;
}

