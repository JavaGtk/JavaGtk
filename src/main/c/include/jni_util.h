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

#ifndef JNI_UTIL_H_
#define JNI_UTIL_H_

#include <jni.h>
#include <stdbool.h>

#define JAVA_REF "javaRef"

JNIEnv *getJavaEnv();

typedef struct callback_tag {
	jmethodID id;
	jobject handler;
	jclass receiver;
	bool attached;
	JNIEnv *env;
	gpointer data;
} callback;

callback* create_callback(JNIEnv *, jobject, jclass, const char *, const char *);

gulong connect_callback(gpointer, const gchar *, GCallback, callback *);

void update_handle(JNIEnv *, jobject, const char *, const char *, int);

void callback_start(callback*);

void callback_end(callback*);

void free_callback(gpointer);

void toggle_java_ref(gpointer, GObject *, gboolean);

void printClassName(JNIEnv *, jobject);

char** convertArgs(JNIEnv *, jobject, jobjectArray, int *);

#endif /* JNI_UTIL_H_ */
