package com.example.viktoriva_by_chiko;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splashmain extends Activity {
private MediaPlayer splash;


    private final  int SPLASH_DISPLEY_LENGTH = 3000;// 6sec
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        splash=MediaPlayer.create(this, R.raw.splash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashStart(splash);
            Intent in = new Intent(Splashmain.this,MainActivity.class);
            startActivity(in);
            finish();
            }
        }, SPLASH_DISPLEY_LENGTH);
    }
    public void splashStart(MediaPlayer sound){
        sound.start();

    }
}
