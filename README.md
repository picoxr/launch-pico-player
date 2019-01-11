<p align="right"><a href="https://github.com/PicoSupport/PicoSupport" target="_blank"> <img src="https://github.com/PicoSupport/PicoSupport/blob/master/Assets/home.png" width="20"/> </a></p>

# Player Description

1.Start Player

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

2.How to start the player in video format

- Start player Settings

  ```
  public enum VoideoType
  {
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
      Unknow
  }
  ```

  Note：Don't set it to 4,6,8,9,12,14.This parameter is not set, and the default is 2D movie playing.
