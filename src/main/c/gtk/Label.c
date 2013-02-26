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
#include "include/org_java_gtk_gtk_Label.h"
#include <jni_util.h>

/*
 * Class:     org_java_gtk_gtk_Label
 * Method:    gtk_label_new
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Label_gtk_1label_1new
  (JNIEnv *env, jclass cls, jstring text)
{
	const char* strLabel;
	GtkWidget* widget;

	strLabel = getJavaString(env, text);
	widget = gtk_label_new(strLabel);
	releaseJavaString(env, text, strLabel);

	return (jlong)widget;
}

/*
 * Class:     org_java_gtk_gtk_Label
 * Method:    gtk_label_get_text
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Label_gtk_1label_1get_1text
  (JNIEnv *env, jclass cls, jlong label)
{
	const char* strText;
	jstring text;

	strText = gtk_label_get_text((GtkLabel*)label);
	text = (*env)->NewStringUTF(env, strText);

	return text;
}

/*
 * Class:     org_java_gtk_gtk_Label
 * Method:    gtk_label_set_text
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Label_gtk_1label_1set_1text
  (JNIEnv *env, jclass cls, jlong label, jstring text)
{
	const char* strText;

	strText = getJavaString(env, text);
	if (strText == NULL) return;
	gtk_label_set_text((GtkLabel*)label, (gchar*)strText);
	releaseJavaString(env, text, strText);

}
