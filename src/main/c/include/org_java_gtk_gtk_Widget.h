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
 * Method:    gtk_widget_add_destroy_handler
 * Signature: (JLorg/java_gtk/gtk/Widget/DestroyHandler;Lorg/java_gtk/gtk/Widget;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1add_1destroy_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

/*
 * Class:     org_java_gtk_gtk_Widget
 * Method:    gtk_widget_set_size_request
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Widget_gtk_1widget_1set_1size_1request
  (JNIEnv *, jclass, jlong, jint, jint);

#ifdef __cplusplus
}
#endif
#endif
