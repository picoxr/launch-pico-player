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

    public void androidPlayer(Context context, String path, String playerName, String videoType) {

        Log.e(TAG, "androidPlayer");
        NAME = playerName;
//        directory = Environment.getExternalStoragePublicDirectory(context.DOWNLOAD_SERVICE).getPath();
//		directory = Externalstoragedirectory.getSDdir(this);
        directory = path;
//        String uri = directory + File.separator + NAME;
        String uri = directory + NAME;
        Log.e(TAG, "uri = " + uri);
        Log.e(TAG, "uri = " + Uri.fromFile(new File(uri)).toString());
//        int videoType = VideoTypeUtils.getVideoType(uri);
        Log.e(TAG, "directory = " + directory);
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("title", NAME);
        intent.putExtra("uri", Uri.fromFile(new File(uri)).toString());
        intent.putExtra("videoType", videoType);
        context.startActivity(intent);

    }
}
