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
#include "include/org_java_gtk_gtk_Image.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_Image
 * Method:    gtk_image_new_from_file
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Image_gtk_1image_1new_1from_1file
(JNIEnv *env, jclass cls, jstring filename)
{
	const char* strFilename;
	GtkWidget* widget;

	strFilename = getJavaString(env, filename);
	widget = gtk_image_new_from_file(strFilename);
	releaseJavaString(env, filename, strFilename);

	return (jlong)widget;
}
