package com.picovr.picoplaymanager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPlayerClick(View view) {
        new PicovrLaunchPlayer().uri("/sdcard/test2D.mp4").title("test2D")
//                .play_list("[{\"index\":0,\"name\":\"test2D.mp4\",\"playMode\":0,\"url\":\"%2Fsdcard%2Ftest2D.mp4\"},
//                {\"index\":1,\"name\":\"test.mp4\",\"playMode\":2,\"url\":\"%2Fsdcard%2Ftest.mp4\"},
//                {\"index\":2,\"name\":\"test2D2.mp4\",\"playMode\":0,\"url\":\"%2Fsdcard%2Ftest2D.mp4\"}]")
//                .shouldPlayIndex(2)
                .loop(true)
//                .position(100.0f)
//                .videoSource("0")
                .playTime(40)
                .launchVideoPlayer(view.getContext());
    }
}

