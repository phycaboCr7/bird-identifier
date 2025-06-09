# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Hilt
-keep class dagger.hilt.** { *; }
-keep class * extends dagger.hilt.android.Hilt_* { *; }
-keep @com.google.dagger.hilt.android.AndroidEntryPoint class * { *; }
-keepclassmembers class * {
    @com.google.dagger.hilt.migration.Accessors* <fields>;
}
-keepclassmembers class * {
    @com.google.dagger.hilt.* *;
}

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations
-keepattributes EnclosingMethod
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# OkHttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**

# Gson
-keep class com.google.gson.** { *; }
-keep class com.google.type.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep class * extends androidx.room.Room
-keep class * extends androidx.room.RoomDatabase$Callback
-keepclassmembers class * {
    @androidx.room.* <methods>;
}

# CameraX
-keep class androidx.camera.** { *; }
-keep interface androidx.camera.** { *; }
-dontwarn androidx.camera.**

# Glide
-keep public class * implements com.bumptech.glide.module.AppGlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
    <init>(...);
}

# Keep `@Keep`-annotated classes and class members
-keep @androidx.annotation.Keep class * {*;}
-keep @androidx.annotation.Keep interface * {*;}
-keep @androidx.annotation.Keep @interface * {*;}
-keep @androidx.annotation.Keep enum * {*;}
-keep @androidx.annotation.Keep @interface *
-keepclasseswithmembers class * {
    @androidx.annotation.Keep <fields>;
}
-keepclasseswithmembers class * {
    @androidx.annotation.Keep <methods>;
}

# Keep Kotlin Metadata
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Keep ViewModels
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
    void onCleared();
}

# Keep Parcelables
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Keep serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep BuildConfig
-keep class com.birdly.app.BuildConfig { *; }

# Keep application class
-keep public class * extends android.app.Application
-keep public class * extends androidx.multidex.MultiDexApplication
-keep class * extends android.app.Application {
    <init>();
}

# Keep native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep custom view constructors
-keepclasseswithmembers class * {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Keep R classes
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Keep the special static methods that are required in all enumeration classes.
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Preserve annotated Javascript interface methods.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Support library references the SDK version in the default notification channel
# it creates without this, we can't override it in XML.
-keep class android.support.v4.app.NotificationCompat { *; }
