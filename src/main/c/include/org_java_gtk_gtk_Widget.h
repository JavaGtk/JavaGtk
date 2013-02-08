/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_Widget */

#ifndef _Included_org_java_gtk_gtk_Widget
#define _Included_org_java_gtk_gtk_Widget
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_show_all
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1show_1all
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1destroy
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_delete_event_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/DeleteEventHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1delete_1event_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_configure_event_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/ConfigureEventHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1configure_1event_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_destroy_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/DestroyHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1destroy_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_add_enter_event_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/EnterEventHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1enter_1event_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_size_request
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1size_1request
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_accel_path
 * Signature: (JLjava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1accel_1path
  (JNIEnv *, jclass, jlong, jstring, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_show
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1show
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_hide
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1hide
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_name
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1name
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_name
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1name
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_sensitive
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1sensitive
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_sensitive
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1sensitive
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_halign
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1halign
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_halign
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1halign
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_valign
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1valign
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_valign
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1valign
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_left
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1left
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_left
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1left
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_right
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1right
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_right
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1right
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_top
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1top
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_top
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1top
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_margin_bottom
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1margin_1bottom
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_margin_bottom
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1margin_1bottom
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_hexpand
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1hexpand
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_hexpand
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1hexpand
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_vexpand
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1vexpand
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_vexpand
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1vexpand
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_get_events
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1get_1events
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_events
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1events
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_override_background_color
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1override_1background_1color
  (JNIEnv *, jclass, jlong, jint, jlong);

#ifdef __cplusplus
}
#endif
#endif
