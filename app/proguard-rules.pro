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
# Needed for Parcelable/SafeParcelable classes & their creators to not get renamed, as they are
# found via reflection.
# Keep Firebase model classes (including those with no-arg constructors)
-keepclassmembers class com.kh.mdaily.presentation.task.Task {
    public <init>(...);
}

# Keep all Firebase classes
-keep class com.google.firebase.** { *; }

# Keep classes annotated with Firestore annotations
-keepattributes Signature
-keepattributes RuntimeVisibleAnnotations
-keep class * {
    @com.google.firebase.database.PropertyKey <fields>;
}

# Prevent stripping of fields required by Firebase
-keepclassmembers class * {
    @com.google.firebase.database.Exclude *;
}

-keep class com.google.android.gms.** { *; }
-keep class com.google.firebase.** { *; }

