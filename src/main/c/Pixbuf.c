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
#include "include/org_java_gtk_gdk_Pixbuf.h"

/*
 * Class:     org_java_gtk_gdk_Pixbuf
 * Method:    gdk_pixbuf_new_from_file
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gdk_Pixbuf_gdk_1pixbuf_1new_1from_1file
  (JNIEnv *env, jclass cls, jstring filename)
{
	GError* error = NULL;
	const char* strFilename;
	GdkPixbuf* pixbuf;

	strFilename = (*env)->GetStringUTFChars(env, filename, NULL);
	pixbuf = gdk_pixbuf_new_from_file(strFilename, &error);
	(*env)->ReleaseStringUTFChars(env, filename, strFilename);

	if (pixbuf == NULL || error) {
		jclass error_cls = NULL;
		if (error->domain == G_FILE_ERROR)
			error_cls = (*env)->FindClass(env, "org/java_gtk/glib/GFileError");
		else
			error_cls = (*env)->FindClass(env, "org/java_gtk/gdk/PixbufError");

		(*env)->ThrowNew(env, error_cls, error->message);
		(*env)->DeleteLocalRef(env, error_cls);
		g_error_free(error);
		return  0L;
	}

	return (jlong)pixbuf;
}
