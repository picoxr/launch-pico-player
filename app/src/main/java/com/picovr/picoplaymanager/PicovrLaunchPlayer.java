package com.picovr.picoplaymanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.picovr.picoplaymanager.VideoTypeRecognize.VideoTypeUtils;

import java.io.File;


public class PicovrLaunchPlayer {
    private static final String TAG = "PicovrLaunchPlayer";

    private static String action = "picovr.intent.action.player";
    private static String directory = null;
    private static String NAME = "test.mp4";

    public void launchVideoPlayer(Context context, String videoPath, String videoName, String videoType) {
        String path = videoPath + videoName;
        Log.e(TAG, "path = " + path);
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("title", videoName);
        intent.putExtra("uri", Uri.fromFile(new File(path)).toString());
        intent.putExtra("videoType", videoType);
        context.startActivity(intent);

    }
}
