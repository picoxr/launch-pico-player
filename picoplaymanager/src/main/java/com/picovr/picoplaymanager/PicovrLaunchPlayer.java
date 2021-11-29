package com.picovr.picoplaymanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/**
 * @author Admin
 */
public class PicovrLaunchPlayer {

    private final Intent mIntent;
    private String mUri;

    private boolean isExist(String filePath) {
        return new File(filePath).exists();
    }

    public PicovrLaunchPlayer() {
        mIntent = new Intent("picovr.intent.action.player");
    }

    public PicovrLaunchPlayer uri(String videoPath, boolean isEncrypted) {
        mUri = isExist(videoPath) ? Uri.fromFile(new File(videoPath)).toString() : videoPath;
        if (!isEncrypted) {
            if (isExist(videoPath)) {
                int videoType = VideoTypeUtils.getVideoType(videoPath);
                mIntent.putExtra("videoType", String.valueOf(videoType));
            }
        }
        mIntent.putExtra("uri", mUri);
        return this;
    }

    public PicovrLaunchPlayer title(String videoName) {
        mIntent.putExtra("title", videoName);
        return this;
    }

    public PicovrLaunchPlayer videoType(String videoType) {
        mIntent.putExtra("videoType", videoType);
        return this;
    }

    public PicovrLaunchPlayer playTime(int playTime) {
        mIntent.putExtra("playTime", playTime);
        return this;
    }

    public PicovrLaunchPlayer videoSource(String videoSource) {
        mIntent.putExtra("videoSource", videoSource);
        return this;
    }

    public PicovrLaunchPlayer scenes(int scene) {
        mIntent.putExtra("scenes", scene);
        return this;
    }

    public PicovrLaunchPlayer position(float position) {
        mIntent.putExtra("position", position);
        return this;
    }

    public PicovrLaunchPlayer seekPlay(boolean seekPlay) {
        mIntent.putExtra("seekPlay", seekPlay);
        return this;
    }

    public PicovrLaunchPlayer loop(boolean loop) {
        mIntent.putExtra("loop", loop);
        return this;
    }

    public PicovrLaunchPlayer isControl(boolean isControl) {
        mIntent.putExtra("isControl", isControl);
        return this;
    }

    public PicovrLaunchPlayer play_list(String playList) {
        mIntent.putExtra("play_list", playList);
        return this;
    }

    public PicovrLaunchPlayer shouldPlayIndex(int shouldPlayIndex) {
        mIntent.putExtra("shouldPlayIndex", shouldPlayIndex);
        return this;
    }

    public void launchVideoPlayer(Context context) {
        if (TextUtils.isEmpty(mUri)) {
            Log.e("==PicoPlayer==", "uri is null");
            return;
        }
        context.startActivity(mIntent);
    }

    public void playOrPauseVideoPlayer(Context context) {
        context.sendBroadcast(new Intent("com.picovr.wing.player.playorpause"));
    }

    public void exitVideoPlayer(Context context) {
        context.sendBroadcast(new Intent("com.picovr.wing.player.exit"));
    }
}
