package com.picovr.picoplaymanager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;

public class MainActivity extends Activity {

    private static final String NAME = "test360.mp4";
    private static String directory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        directory = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).toString();
    }

    public void openPlayerClick(View view) {
        //For example: directory -- /storage/emulated/0/download/    NAME  -- test360.mp4
        new PicovrLaunchPlayer().launchVideoPlayer(view.getContext(), directory + File.separator, NAME, "2");
    }
}

