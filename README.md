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
      VoideType_3D_LR=1;   //3D左右
      VoideType_360_2D=2;  //全景2D
      VoideType_360_3D_TB=3;  //全景3D上下
      VoideType_360_3D_BT=4;  //全景3d下上
      VoideType_360_3D_LR=5;  //全景3D左右
      VoideType_360_3D_RL=6;  //全景3D右左
      VoideType_3D_TB=7;      //3D上下		
      VoideType_3D_BT=8;      //3D下上
      VoideType_3D_RL=9;      //3D右左
      VoideType_180_2D=10;    //180 2D
      VoideType_180_3D_TB=11; //180 3D 上下
      VoideType_180_3D_BT=12; //180 3D 下上
      VoideType_180_3D_LR=13; //180 3D左右
      VoideType_180_3D_RL=14; //180 3D右左
      Unknow
  }
  ```

  Note：Don't set it to 4,6,8,9,12,14.This parameter is not set, and the default is 2D movie playing.
