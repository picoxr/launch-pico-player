package com.picovr.picoplaymanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayerNativeActivityPico;

import java.io.File;

import com.picovr.picoplaymanager.VideoTypeRecognize.VideoTypeUtils;

public class PicovrPlayManagerActivity extends UnityPlayerNativeActivityPico {

	private static final String TAG = "PicovrPlayManager";
	public static Activity unityActivity = null;

	private static String action = "picovr.intent.action.player";
	private static String directory = null;
	private static String NAME = "test.mp4";

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

}
