/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_Window */

#ifndef _Included_org_java_gtk_gtk_Window
#define _Included_org_java_gtk_gtk_Window
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_new
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1new
  (JNIEnv *, jclass, jint);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_title
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1title
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_get_title
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1get_1title
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_default_size
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1default_1size
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_resizable
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1resizable
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_get_resizable
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1get_1resizable
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_position
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1position
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_add_accel_group
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1add_1accel_1group
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_icon
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1icon
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_set_decorated
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1set_1decorated
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_java_gtk_gtk_Window
 * Method:    gtk_window_begin_move_drag
 * Signature: (JIIIJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_Window_gtk_1window_1begin_1move_1drag
  (JNIEnv *, jclass, jlong, jint, jint, jint, jlong);

#ifdef __cplusplus
}
#endif
#endif