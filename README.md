# Player Description

**Note**: Regarding JAR file creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How%20to%20Use%20JAR%20file%20in%20Unity%20project%20on%20Pico%20device.docx)      
**JAR and APK Path**: /outputs

## Supported Devices
Pico Goblin, Pico Neo, Pico G2, Pico G2 4K 

## Introduction
This demo shows how to play specific video using system video player

## APK Usage
You need to transfer the video named "test.mp4" to /Download/ directory, launch this app then you can watch it.

## JAR Usage
* Non-inheriting the main Activity
```
AndroidJavaObject ajo = new AndroidJavaObject("com.picovr.picoplaymanager.PicovrLaunchPlayer");
AndroidJavaObject ActivityContext = new AndroidJavaClass("com.unity3d.player.UnityPlayer").GetStatic<AndroidJavaObject>("currentActivity");
ajo.Call("androidPlayer", ActivityContext, "/storage/emulated/0/Download/", "test.mp4", "2"));
```

* inheriting the main Activity
1. Modify main activity of AndroidManifest.xml to com.picovr.picoplaymanager.PicovrPlayManagerActivity;    
2. Copy the JAR file to the Assets/Plugins/Android/ folder;    
3. Copy the PicoUnityActivity.cs to the Assets folder;     
4. In the script file, Use “CallObjectMethod” interface to call the methods defined in JAR files as below.
```
PicoUnityActivity.CallObjectMethod("androidPlayer", "/storage/emulated/0/Download/", "test.mp4", "2");
```

## Permission
add these to AndroidManifest.xml in Unity project.
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Pamameter Introduction
| Parameter                         | Remark                                                       |
| --------------------------------- | ------------------------------------------------------------ |
| Action                            | picovr.intent.action.player                                  |
| uri                               | Play address                                                 |
| title                             | The name of the video                                        |
| videoType                         | Video type                                                           

## Supported Video Format
    VideoType_2D=0;  //2D
    VoideType_3D_LR=1;   //3D left-right
    VoideType_360_2D=2;  //360 2D
    VoideType_360_3D_TB=3;  //360 3D top-bottom
    VoideType_360_3D_BT=4;  //360 3d bottom-top
    VoideType_360_3D_LR=5;  //360 3D left-right
    VoideType_360_3D_RL=6;  //360 3D right-left
    VoideType_3D_TB=7;      //3D top-bottom
    VoideType_3D_BT=8;      //3D bottom-top
    VoideType_3D_RL=9;      //3D right-left
    VoideType_180_2D=10;    //180 2D
    VoideType_180_3D_TB=11; //180 3D top-bottom
    VoideType_180_3D_BT=12; //180 3D bottom-top
    VoideType_180_3D_LR=13; //180 3D left-right
    VoideType_180_3D_RL=14; //180 3D right-left

## Note
Note：Don't set videoType to 4,6,8,9,12,14.
      If you don't specify any videoType, it'll be 0 ( 2D ) by default.
