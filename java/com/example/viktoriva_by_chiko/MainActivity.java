package com.example.viktoriva_by_chiko;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private MediaPlayer start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        start = MediaPlayer.create(this, R.raw.main);




    }


    public void btn_start(View view){
        soundstart(start);
        Intent intent = new Intent(this, Gamelevels.class);
        startActivity(intent);

    }

    public void soundstart(MediaPlayer sound){
        sound.start();


    }
}