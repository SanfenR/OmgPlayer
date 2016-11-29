package com.mz.sanfen.omgplayer;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayerActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    IjkMediaPlayer player;
    SurfaceView surface;
    SurfaceHolder surfaceHolder;
    String path = "/storage/emulated/0/video.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 初始化播放器
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        surface = (SurfaceView) findViewById(R.id.surface);
        surfaceHolder = surface.getHolder();

        surfaceHolder.addCallback(this);

    }

    public void release() {
        if (player != null) {
            player.reset();
            player.release();
            player = null;
            AudioManager am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
            am.abandonAudioFocus(null);
        }
    }

    public void openVideo(){
        release();

        try {
            player = new IjkMediaPlayer();

            player.setDataSource(path);
            player.setDisplay(surfaceHolder);

            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setScreenOnWhilePlaying(true);
            player.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume(){
        super.onResume();
        // activity 可见时尝试继续播放
        if (player != null){
            player.start();
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        openVideo();
        player.start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
