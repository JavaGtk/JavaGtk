/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_java_gtk_gtk_ToolButton */

#ifndef _Included_org_java_gtk_gtk_ToolButton
#define _Included_org_java_gtk_gtk_ToolButton
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_new
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1new
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_new_from_stock
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1new_1from_1stock
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_java_gtk_gtk_ToolButton
 * Method:    gtk_tool_button_add_clicked_event_handler
 * Signature: (JLorg/java_gtk/gtk/ToolButton/ClickedEventHandler;Lorg/java_gtk/gtk/ToolButton;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_ToolButton_gtk_1tool_1button_1add_1clicked_1event_1handler
  (JNIEnv *, jclass, jlong, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
