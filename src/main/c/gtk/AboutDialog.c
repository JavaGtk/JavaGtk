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
#include "include/org_java_gtk_gtk_AboutDialog.h"

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_new
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1new
  (JNIEnv *env, jclass cls)
{
	return (jlong)gtk_about_dialog_new();
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_program_name
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1program_1name
  (JNIEnv *env, jclass cls, jlong dialog)
{
	const char* strName;
	jstring name;

	strName = gtk_about_dialog_get_program_name((GtkAboutDialog*)dialog);
	name = (*env)->NewStringUTF(env, strName);

	return name;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_program_name
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1program_1name
  (JNIEnv *env, jclass cls, jlong dialog, jstring name)
{
	const char* strName;

	strName = (*env)->GetStringUTFChars(env, name, NULL);
	if (strName == NULL) return;
	gtk_about_dialog_set_program_name((GtkAboutDialog*)dialog, (gchar*)strName);
	(*env)->ReleaseStringUTFChars(env, name, strName);
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_version
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1version
  (JNIEnv *env, jclass cls, jlong dialog)
{
	const char* strVersion;
	jstring version;

	strVersion = gtk_about_dialog_get_version((GtkAboutDialog*)dialog);
	version = (*env)->NewStringUTF(env, strVersion);

	return version;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_version
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1version
  (JNIEnv *env, jclass cls, jlong dialog, jstring version)
{
	const char* strVersion;

	strVersion = (*env)->GetStringUTFChars(env, version, NULL);
	if (strVersion == NULL) return;
	gtk_about_dialog_set_version((GtkAboutDialog*)dialog, (gchar*)strVersion);
	(*env)->ReleaseStringUTFChars(env, version, strVersion);
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_copyright
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1copyright
  (JNIEnv *env, jclass cls, jlong dialog)
{
	const char* strCopyright;
	jstring copyright;

	strCopyright = gtk_about_dialog_get_copyright((GtkAboutDialog*)dialog);
	copyright = (*env)->NewStringUTF(env, strCopyright);

	return copyright;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_copyright
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1copyright
  (JNIEnv *env, jclass cls, jlong dialog, jstring copyright)
{
	const char* strCopyright;

	strCopyright = (*env)->GetStringUTFChars(env, copyright, NULL);
	if (strCopyright == NULL) return;
	gtk_about_dialog_set_copyright((GtkAboutDialog*)dialog, (gchar*)strCopyright);
	(*env)->ReleaseStringUTFChars(env, copyright, strCopyright);
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_comments
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1comments
  (JNIEnv *env, jclass cls, jlong dialog)
{
	const char* strComments;
	jstring comments;

	strComments = gtk_about_dialog_get_comments((GtkAboutDialog*)dialog);
	comments = (*env)->NewStringUTF(env, strComments);

	return comments;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_comments
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1comments
  (JNIEnv *env, jclass cls, jlong dialog, jstring comments)
{
	const char* strComments;

	strComments = (*env)->GetStringUTFChars(env, comments, NULL);
	if (strComments == NULL) return;
	gtk_about_dialog_set_comments((GtkAboutDialog*)dialog, (gchar*)strComments);
	(*env)->ReleaseStringUTFChars(env, comments, strComments);
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_website
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1website
  (JNIEnv *env, jclass cls, jlong dialog)
{
	const char* strWebsite;
	jstring website;

	strWebsite = gtk_about_dialog_get_website((GtkAboutDialog*)dialog);
	website = (*env)->NewStringUTF(env, strWebsite);

	return website;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_website
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1website
  (JNIEnv *env, jclass cls, jlong dialog, jstring website)
{
	const char* strWebsite;

	strWebsite = (*env)->GetStringUTFChars(env, website, NULL);
	if (strWebsite == NULL) return;
	gtk_about_dialog_set_website((GtkAboutDialog*)dialog, (gchar*)strWebsite);
	(*env)->ReleaseStringUTFChars(env, website, strWebsite);
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_get_logo
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1get_1logo
  (JNIEnv *env, jclass cls, jlong dialog)
{
	GdkPixbuf *logo;
	logo = gtk_about_dialog_get_logo((GtkAboutDialog*)dialog);
	return (jlong)logo;
}

/*
 * Class:     org_java_gtk_gtk_AboutDialog
 * Method:    gtk_about_dialog_set_logo
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_java_1gtk_gtk_AboutDialog_gtk_1about_1dialog_1set_1logo
  (JNIEnv *env, jclass cls, jlong dialog, jlong logo)
{
	gtk_about_dialog_set_logo((GtkAboutDialog*)dialog, (GdkPixbuf*)logo);
}

