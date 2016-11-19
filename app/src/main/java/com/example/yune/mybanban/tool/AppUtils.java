package com.example.yune.mybanban.tool;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Yune on 2016/11/17.
 */

public class AppUtils {
    private static MediaPlayer mediaPlayer = null;

    /**
     * 播放资产目录中通知音乐
     *
     * @param context   上下文
     * @param voicePath 音乐路径
     * @throws IOException
     */
    public static void playNotifycationMusic(Context context, String voicePath)
            throws IOException {
        // paly music ...
        AssetFileDescriptor fileDescriptor = context.getAssets().openFd(
                voicePath);
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                fileDescriptor.getStartOffset(), fileDescriptor.getLength());
        mediaPlayer.prepare();
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }
}
