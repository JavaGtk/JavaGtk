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
#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "include/jni_util.h"

static JavaVM*	cached_jvm;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
	cached_jvm = jvm;
	return JNI_VERSION_1_6;
}

JNIEnv *getJavaEnv() {
	JNIEnv *env;
	int status = (*cached_jvm)->GetEnv(cached_jvm, (void **)&env, JNI_VERSION_1_6);
	if (status != JNI_OK) {
		status = (*cached_jvm)->AttachCurrentThread(cached_jvm, (void **)&env, NULL);
		if (status != JNI_OK) {
			return NULL;
		}
	}
	return env;
}

callback* create_callback(JNIEnv *env, jobject handler, jobject receiver, const char *name, const char *sig) {
	callback *c = (callback*)malloc(sizeof(callback));
	c->handler = (*env)->NewGlobalRef(env, handler);
	c->receiver = (*env)->NewGlobalRef(env, receiver);
	jclass receiver_cls = (*env)->GetObjectClass(env, c->receiver);
	c->id = (*env)->GetStaticMethodID(env, receiver_cls, name, sig);
	return c;
}

gulong connect_callback(gpointer instance, const gchar *signal, GCallback handler, callback* c) {
	return g_signal_connect_data(instance, signal, handler, c, (GClosureNotify)free_callback, 0);
}

void update_handle(JNIEnv *env, jobject handler, const char *name, const char *sig, int handle) {
	jclass handler_cls = (*env)->GetObjectClass(env, handler);
	jmethodID id = (*env)->GetMethodID(env, handler_cls, name, sig);
	(*env)->CallVoidMethod(env, handler, id, handle);
}

void callback_start(callback *c) {
	c->attached = false;
	int status = (*cached_jvm)->GetEnv(cached_jvm, (void **)&c->env, JNI_VERSION_1_6);
	if (status != JNI_OK) {
		status = (*cached_jvm)->AttachCurrentThread(cached_jvm, (void **)&c->env, NULL);
		if (status != JNI_OK) {
			return;
		}
		c->attached = true;
	}
}

void callback_end(callback *c) {
	if (c->attached) {
		(*cached_jvm)->DetachCurrentThread(cached_jvm);
		c->attached = false;
	}
}

void free_callback(gpointer data) {
	free(data);
}

void printClassName(JNIEnv *env, jobject obj) {
	jclass obj_cls = (*env)->GetObjectClass(env, obj);

	// First get the class object
	jmethodID mid = (*env)->GetMethodID(env, obj_cls, "getClass", "()Ljava/lang/Class;");
	jobject clsObj = (*env)->CallObjectMethod(env, obj, mid);

	// Now get the class object's class descriptor
	jclass cls = (*env)->GetObjectClass(env, clsObj);

	// Find the getName() method on the class object
	mid = (*env)->GetMethodID(env, cls, "getName", "()Ljava/lang/String;");

	// Call the getName() to get a jstring object back
	jstring strObj = (jstring)(*env)->CallObjectMethod(env, clsObj, mid);

	const char* cstr = (*env)->GetStringUTFChars(env, strObj, 0);

	printf("class: %s", cstr);

	(*env)->ReleaseStringUTFChars(env, strObj, cstr);

}

char** convertArgs(JNIEnv *env, jobject _argc, jobjectArray _argv, int* argc) {
	char **argv;
	if (_argv == NULL) {
		*argc = 0;
	} else {
		*argc = (*env)->GetArrayLength(env, _argv);
	}
	argv = (char**) g_newa(char**, (*argc)+1);

	for (int i=0; i<*argc; i++) {
		jstring string = (jstring)(*env)->GetObjectArrayElement(env, _argv, i);
		const char* rawString = (*env)->GetStringUTFChars(env, string, 0);
		argv[i+1] = g_strdup(rawString);
		(*env)->ReleaseStringUTFChars(env, string, rawString);
	}

	argv[0] = "";
	(*argc)++;

	return argv;
}

