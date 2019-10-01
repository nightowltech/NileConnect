package com.nightowltechnology.asimyaz.nileconnect;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {
    private MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        audio = MediaPlayer.create(this, R.raw.yani);
        audio.start();
        audio.setVolume(0.3f,0.3f);


    }
    @Override
       protected void onPause() {
        super.onPause();
        if (audio != null) {
            audio.pause();
            if (isFinishing()) {
                audio.stop();
                audio.release();
            }
        }
    }

}
