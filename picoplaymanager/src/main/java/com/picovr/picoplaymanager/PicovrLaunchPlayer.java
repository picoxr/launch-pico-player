package com.picovr.picoplaymanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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

    public void launchVideoPlayer(Context context, String videoPath, String videoName, boolean seekPlay, boolean loop,
                                  boolean isPlayEndAndClose, boolean isSinglePlayLoop, boolean isControl) {
        String path = videoPath + videoName;
        Intent intent = new Intent();
        intent.setAction(action);
        String uri = Uri.fromFile(new File(path)).toString();
        intent.putExtra("uri", uri);
        intent.putExtra("title", videoName);
        intent.putExtra("videoType", VideoTypeUtils.getVideoType(uri));
        intent.putExtra("seekPlay", seekPlay);
        intent.putExtra("loop", loop);
        intent.putExtra("isPlayEndAndClose", isPlayEndAndClose);
        intent.putExtra("isSinglePlayLoop", isSinglePlayLoop);
        intent.putExtra("isControl", isControl);
        context.startActivity(intent);
    }

    public void launchVideoPlayer(Context context, String videoPath, String videoName, boolean seekPlay,
                                  boolean loop, boolean isPlayEndAndClose, boolean isSinglePlayLoop,
                                  boolean isControl, String json, int shouldPlayIndex) {
        String path = videoPath + videoName;
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("uri", Uri.fromFile(new File(path)).toString());
        intent.putExtra("seekPlay", seekPlay);
        intent.putExtra("loop", loop);
        intent.putExtra("isPlayEndAndClose", isPlayEndAndClose);
        intent.putExtra("isSinglePlayLoop", isSinglePlayLoop);
        intent.putExtra("isControl", isControl);
        intent.putExtra("play_list", json);
        intent.putExtra("shouldPlayIndex", shouldPlayIndex);
        context.startActivity(intent);
    }
}
