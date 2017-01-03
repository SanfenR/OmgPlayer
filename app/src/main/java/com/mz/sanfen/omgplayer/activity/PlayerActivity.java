package com.mz.sanfen.omgplayer.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.Settings;
import com.mz.sanfen.omgplayer.widget.media.AndroidMediaController;
import com.mz.sanfen.omgplayer.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayerActivity extends AppCompatActivity {


    IjkVideoView videoView;
    private TableLayout mHudView;

    private Settings mSettings;

    private AndroidMediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mSettings = new Settings(this);

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



        ActionBar actionBar = getSupportActionBar();

        mHudView = (TableLayout) findViewById(R.id.hud_view);

        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mMediaController = new AndroidMediaController(this, false);
        mMediaController.setSupportActionBar(actionBar);

        videoView = (IjkVideoView) findViewById(R.id.video_view);

        videoView.setVideoURI(Uri.parse("http://ohqvqufyf.bkt.clouddn.com/fyq.mp4"));
        videoView.setMediaController(mMediaController);
        videoView.setHudView(mHudView);
        videoView.start();

    }

    @Override
    protected void onStop() {
        super.onStop();

        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
