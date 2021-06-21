package com.picovr.picoplaymanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.unity3d.player.UnityPlayerNativeActivityPico;
import java.io.File;

public class PicovrPlayManagerActivity extends UnityPlayerNativeActivityPico {

    private static final String TAG = "PicovrPlayManager";
    public static Activity unityActivity = null;

    private static String action = "picovr.intent.action.player";

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        unityActivity = this;
    }

    public void launchVideoPlayer(String videoPath, String videoName, String videoType) {
        String path = videoPath + videoName;
        Log.e(TAG, "path = " + path);
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("title", videoName);
        intent.putExtra("uri", Uri.fromFile(new File(path)).toString());
        intent.putExtra("videoType", videoType);
        startActivity(intent);
    }

    public void launchVideoPlayer(String videoPath, String videoName, boolean seekPlay, boolean loop,
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
        startActivity(intent);
    }

    public void launchVideoPlayer(String videoPath, String videoName, boolean seekPlay, boolean loop,
                                  boolean isPlayEndAndClose, boolean isSinglePlayLoop, boolean isControl,
                                  String json, int shouldPlayIndex) {
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
        startActivity(intent);
    }
}
