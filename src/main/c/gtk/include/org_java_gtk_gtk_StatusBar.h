/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_StatusBar */

#ifndef _Included_org_java_gtk_gtk_StatusBar
#define _Included_org_java_gtk_gtk_StatusBar
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1new
  (JNIEnv *, jclass);

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_push
 * Signature: (JILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1push
  (JNIEnv *, jclass, jlong, jint, jstring);

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_pop
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1pop
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_java_gtk_gtk_StatusBar
 * Method:    gtk_statusbar_get_context_id
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_java_1gtk_gtk_StatusBar_gtk_1statusbar_1get_1context_1id
  (JNIEnv *, jclass, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
