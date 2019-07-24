# Player Description

JAR, Demo APK and PicoUnityActivity.cs are in /resource.     
**Note**: If you want to create your own JAR file, please refer to [the Guideline](http://static.appstore.picovr.com/docs/JarUnity/index.html)      

## Supported Devices
Pico Goblin, Pico Neo, Pico G2, Pico G2 4K 

## Introduction
This demo shows how to launch system video player with specified video file.

## APK Usage
You need to transfer the video named "test.mp4" to /Download/ directory, launch this app then you can watch it.

## API defined in JAR file
void launchVideoPlayer(String videoPath, String videoName, String videoType)  

About videoType parameter introduction and more information, refer to [PicoVR Built-in Video Player](http://static.appstore.picovr.com/docs/VideoPlayer/index.html).
