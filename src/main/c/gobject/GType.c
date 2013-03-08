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
#include "include/org_java_gtk_gobject_GType.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gobject_GType
 * Method:    get_type
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gobject_GType_get_1type
  (JNIEnv *env, jclass cls, jstring name)
{
	const char* strTypeName;
	strTypeName = getJavaString(env, name);

	GType gtype;
	if (g_str_equal(strTypeName, "String")) {
		gtype = G_TYPE_STRING;
	} else if (g_str_equal(strTypeName, "Int")) {
		gtype = G_TYPE_INT;
	} else if (g_str_equal(strTypeName, "Long")) {
		gtype = G_TYPE_INT64;
	} else if (g_str_equal(strTypeName, "Float")) {
		gtype = G_TYPE_FLOAT;
	} else if (g_str_equal(strTypeName, "Double")) {
		gtype = G_TYPE_DOUBLE;
	} else if (g_str_equal(strTypeName, "Bool")) {
		gtype = G_TYPE_BOOLEAN;
	} else if (g_str_equal(strTypeName, "GObject")) {
		gtype = G_TYPE_OBJECT;
	} else if (g_str_equal(strTypeName, "Pixbuf")) {
		gtype = GDK_TYPE_PIXBUF;
	} else if (g_str_equal(strTypeName, "None")) {
		gtype = G_TYPE_INT;
	} else {
		gtype = G_TYPE_INVALID;
	}

	releaseJavaString(env, name, strTypeName);
	return gtype;
}
