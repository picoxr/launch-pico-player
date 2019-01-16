# Player Description

Note: Regarding java package creation and usege, please refer to [the Guideline](https://github.com/PicoSupport/PicoSupport/blob/master/How_to_use_JAR_file_in_Unity_project_on_Pico_device.docx)

## Introduction
This demo shows how to play specific video using system video player

## Usage
You need to transfer the video to /Download/ directory, launch this app then you can watch it.

## Class Name
android:name="com.picovr.picoplayb100manager.MainActivity"

## Permission
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Pamameter Introduction
| Parameter                         | Remark                                                       |
| --------------------------------- | ------------------------------------------------------------ |
| Action start player               | picovr.intent.action.player                                  |
| uri                               | Play address (required)                                      |
| title                             | The name of the video                                        |
| voidetype                         | Video type                                                   |
| Videowidth                        | Width of the video                                           |
| Videoheight                       | Video height                                                 |
| playTime                          | Play the starting point                                      |
| autoPlay                          | Whether to automatically play, int data, 1, automatically play;0, load the first frame, |
| initen.putExtra("videoSource",3); |                                                              |

## Supported Video Format
    VideoType_2D=0;  //2D
    VoideType_3D_LR=1;   //3DLR
    VoideType_360_2D=2;  //360 2D
    VoideType_360_3D_TB=3;  //360 3D TB
    VoideType_360_3D_BT=4;  //360 3d BT
    VoideType_360_3D_LR=5;  //360 3D LR
    VoideType_360_3D_RL=6;  //
    VoideType_3D_TB=7;      //
    VoideType_3D_BT=8;      //
    VoideType_3D_RL=9;      //
    VoideType_180_2D=10;    //
    VoideType_180_3D_TB=11; //
    VoideType_180_3D_BT=12; //
    VoideType_180_3D_LR=13; //
    VoideType_180_3D_RL=14; //

## Note
Note：Don't set videoType to 4,6,8,9,12,14.
      If you don't specify any videoType, it'll be 0 ( 2D ) by default.
