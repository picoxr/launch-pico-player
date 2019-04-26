package com.picovr.picoplaymanager;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.picovr.picoplaymanager.VideoTypeRecognize.VideoTypeUtils;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static String action = "picovr.intent.action.player";
    private static String directory = null;
    private static final String NAME = "test.mp4";
    String fileDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        directory = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).toString();
        fileDir = directory + File.separator + NAME;

    }
    
    public void openPlayerClick(View view) {
        openPlayer(fileDir);
    }

    public void openPlayer(String fileDir){
        //directory = /storage/emulated/0/download/test.mp4
        Log.e(TAG, "directory = " + fileDir);
        String uri = fileDir;

        Log.e(TAG, "uri = " + uri);
        Log.e(TAG, "uri = " + Uri.fromFile(new File(uri)).toString());

        int videoType = VideoTypeUtils.getVideoType(uri);
        Log.e(TAG, "videoType = " + videoType + "");
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("title", NAME);
        intent.putExtra("uri", Uri.fromFile(new File(uri)).toString());
        intent.putExtra("videoType", videoType + "");
        startActivity(intent);
    }
}

