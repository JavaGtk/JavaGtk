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
#include "include/org_java_gtk_glib_Timer.h"
#include <jni_util.h>

gboolean timer_handler(callback *c) {
	jboolean result;
	callback_start(c);
	result = (*c->env)->CallStaticBooleanMethod(c->env, c->receiver, c->id, c->handler, c->data);
	callback_end(c);
	return (gboolean)result;
}

/*
 * Class:     org_java_gtk_glib_Timer
 * Method:    g_timer_new
 * Signature: (ILorg/java_gtk/glib/Timer/TimerHandler;J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_glib_Timer_g_1timer_1new
  (JNIEnv *env, jclass cls, jint interval, jobject handler, jlong data)
{
	callback *c;
	long handle_id;
	//TODO:  cache this jclass
	jclass receiver_cls = (*env)->FindClass(env, "org/java_gtk/glib/Timer");
	c = create_callback(env, handler, receiver_cls, "timerReceiver", "(Lorg/java_gtk/glib/Timer$TimerHandler;J)Z");
	c->data = (gpointer)data;
	handle_id = (long)g_timeout_add((guint)interval, (GSourceFunc)timer_handler, c);
	update_handle(env, handler, "setHandleId", "(J)V", handle_id);
}

