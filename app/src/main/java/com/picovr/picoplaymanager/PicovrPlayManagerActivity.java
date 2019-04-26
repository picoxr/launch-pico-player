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

	public void androidPlayer(String path, String playerName, String videoType) {

		Log.e(TAG, "androidPlayer");
		NAME = playerName;
//		directory = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).getPath();
		directory = path;
//		directory = Externalstoragedirectory.getSDdir(this);
//		String uri = directory + File.separator + NAME;
		String uri = directory + NAME;
		Log.e(TAG, "uri = " + uri);
		Log.e(TAG, "uri = " + Uri.fromFile(new File(uri)).toString());
//		int videoType = VideoTypeUtils.getVideoType(uri);
		Log.e(TAG, "directory = " + directory);
		Intent intent = new Intent();
		intent.setAction(action);
		intent.putExtra("title", NAME);
		intent.putExtra("uri", Uri.fromFile(new File(uri)).toString());
		intent.putExtra("videoType", videoType);
		startActivity(intent);

	}

}
