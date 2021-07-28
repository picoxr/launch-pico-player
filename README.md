# Player Description

- If you have any questions/comments, please visit [**Pico Developer Answers**](https://devanswers.pico-interactive.com/) and raise your question there.

JAR, Demo APK and PicoUnityActivity.cs are in /resource.     
**Note**: If you want to create your own JAR file, please refer to [the Guideline](http://static.appstore.picovr.com/docs/JarUnity/index.html)      

## Supported Devices
Pico Goblin, Pico Neo, Pico G2, Pico G2 4K 

## Introduction
This demo shows how to launch system video player with specified video file.

## API defined in JAR file
void launchVideoPlayer(String videoPath, String videoName, String videoType)  

void launchVideoPlayer(String videoPath, String videoName, boolean seekPlay, boolean loop, boolean isPlayEndAndClose, boolean isSinglePlayLoop, boolean isControl)

void launchVideoPlayer(String videoPath, String videoName, boolean seekPlay, boolean loop, boolean isPlayEndAndClose, boolean isSinglePlayLoop, boolean isControl, String json, int shouldPlayIndex)

About videoType parameter introduction and more information, refer to [PicoVR Built-in Video Player](http://static.appstore.picovr.com/docs/VideoPlayer/index.html).
