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
#include "include/org_java_gtk_gdk_RGBA.h"

/*
 * Class:     org_java_gtk_gdk_RGBA
 * Method:    gdk_rgba_new
 * Signature: (DDDD)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gdk_RGBA_gdk_1rgba_1new
  (JNIEnv *env, jclass cls, jdouble red, jdouble green, jdouble blue, jdouble alpha)
{
	GdkRGBA color = {
			.red = (gdouble)red,
			.green = (gdouble)green,
			.blue = (gdouble)blue,
			.alpha = (gdouble)alpha
	};

	return (jlong)gdk_rgba_copy(&color);
}

/*
 * Class:     org_java_gtk_gdk_RGBA
 * Method:    gdk_rgba_free
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gdk_RGBA_gdk_1rgba_1free
  (JNIEnv *env, jclass cls, jlong rgba)
{
	gdk_rgba_free((GdkRGBA*)rgba);
}
