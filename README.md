# Player Description

**Note**: Regarding JAR file creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How%20to%20Use%20JAR%20file%20in%20Unity%20project%20on%20Pico%20device.docx)      
**JAR and APK Path**: /outputs

## Supported Devices
Pico Goblin, Pico Neo, Pico G2, Pico G2 4K 

## Introduction
This demo shows how to launch system video player with specified video file.

## APK Usage
You need to transfer the video named "test.mp4" to /Download/ directory, launch this app then you can watch it.

## API defined in JAR file
void launchVideoPlayer(String videoPath, String videoName, String videoType)     
About videoType parameter introduction and more information, refer to [PicoVR Built-in Video Player](http://static.appstore.picovr.com/docs/VideoPlayer/index.html).

## JAR file Usage
* Non-inheriting the main Activity
```
AndroidJavaObject ajo = new AndroidJavaObject("com.picovr.picoplaymanager.PicovrLaunchPlayer");
AndroidJavaObject ActivityContext = new AndroidJavaClass("com.unity3d.player.UnityPlayer").GetStatic<AndroidJavaObject>("currentActivity");
ajo.Call("launchVideoPlayer", ActivityContext, "/storage/emulated/0/Download/", "test.mp4", "2");
```

* inheriting the main Activity
1. Modify main activity of AndroidManifest.xml to com.picovr.picoplaymanager.PicovrPlayManagerActivity;    
2. Copy the JAR file to the Assets/Plugins/Android/ folder;    
3. Copy the PicoUnityActivity.cs to the Assets folder;     
4. In the script file, Use “CallObjectMethod” interface to call the methods defined in JAR files as below.
```
PicoUnityActivity.CallObjectMethod("launchVideoPlayer", "/storage/emulated/0/Download/", "test.mp4", "2");
```

## Permission
Add these to AndroidManifest.xml in Unity project.
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```    
