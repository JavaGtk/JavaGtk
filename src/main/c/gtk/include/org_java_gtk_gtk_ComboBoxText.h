/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_ComboBoxText */

#ifndef _Included_org_java_gtk_gtk_ComboBoxText
#define _Included_org_java_gtk_gtk_ComboBoxText
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_ComboBoxText
 * Method:    gtk_combo_box_text_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ComboBoxText_gtk_1combo_1box_1text_1new
  (JNIEnv *, jclass);

/*
 * Class:     org_java_gtk_gtk_ComboBoxText
 * Method:    gtk_combo_box_text_append
 * Signature: (JLjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ComboBoxText_gtk_1combo_1box_1text_1append
  (JNIEnv *, jclass, jlong, jstring, jstring);

/*
 * Class:     org_java_gtk_gtk_ComboBoxText
 * Method:    gtk_combo_box_text_append_text
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ComboBoxText_gtk_1combo_1box_1text_1append_1text
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_java_gtk_gtk_ComboBoxText
 * Method:    gtk_combo_box_text_get_active_text
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_ComboBoxText_gtk_1combo_1box_1text_1get_1active_1text
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif