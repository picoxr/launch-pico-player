package com.picovr.picoplayb100manager;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.picovr.picoplayb100manager.VideoTypeRecognize.VideoTypeUtils;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static String action = "picovr.intent.action.player";
    private static String directory = null;
    private static final String NAME = "东江湖.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    public void openPlayerClick(View view) {
        directory = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).toString();
        String fileDir = directory + File.separator + NAME;
        openPlayer(fileDir);
    }

    public void openPlayer(String fileDir){

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

