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
#include "include/org_java_gtk_gtk_AccelMap.h"

/*
 * Class:     org_java_gtk_gtk_AccelMap
 * Method:    gtk_accel_map_add_entry
 * Signature: (Ljava/lang/String;II)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AccelMap_gtk_1accel_1map_1add_1entry
  (JNIEnv *env, jclass cls, jstring path, jint key, jint mod_type)
{
	const char* strPath;

	strPath = (*env)->GetStringUTFChars(env, path, NULL);
	gtk_accel_map_add_entry(strPath, (gint)key, (gint)mod_type);
	(*env)->ReleaseStringUTFChars(env, path, strPath);
}
