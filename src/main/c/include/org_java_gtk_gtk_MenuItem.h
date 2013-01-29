/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_MenuItem */

#ifndef _Included_org_java_gtk_gtk_MenuItem
#define _Included_org_java_gtk_gtk_MenuItem
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1new
  (JNIEnv *, jclass);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_new_with_label
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1new_1with_1label
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_set_label
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1set_1label
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_get_label
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1get_1label
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_set_submenu
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1set_1submenu
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_get_submenu
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1get_1submenu
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_java_gtk_gtk_MenuItem
 * Method:    gtk_menu_item_add_activated_event_handler
 * Signature: (JLorg/java_gtk/gtk/MenuItem/ActivatedEventHandler;Lorg/java_gtk/gtk/MenuItem;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_MenuItem_gtk_1menu_1item_1add_1activated_1event_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
