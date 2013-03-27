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
#include "include/org_java_gtk_gtk_Entry.h"

/*
 * Class:     org_java_gtk_gtk_Entry
 * Method:    gtk_entry_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Entry_gtk_1entry_1new
  (JNIEnv *env, jclass cls)
{
	GtkWidget* widget;

	widget = gtk_entry_new();

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Entry
 * Method:    gtk_entry_get_text
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Entry_gtk_1entry_1get_1text
  (JNIEnv *env, jclass cls, jlong entry)
{
	const char* strText;
	jstring text;

	strText = gtk_entry_get_text((GtkEntry*)entry);
	text = (*env)->NewStringUTF(env, strText);

	return text;

}
