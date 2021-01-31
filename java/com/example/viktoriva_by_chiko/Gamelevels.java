package com.example.viktoriva_by_chiko;

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
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Gamelevels extends AppCompatActivity {
    private MediaPlayer pitbul;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);
        pitbul=MediaPlayer.create(this,R.raw.click);



        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.discrdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        Button btnback = dialog.findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }

        });





        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void startfirstlvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level1.class);
        startActivity(intent);
    }
    public void start2lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level2.class);
        startActivity(intent);
    }

    public void start3lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level3.class);
        startActivity(intent);
    }
    public void start4lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level4.class);
        startActivity(intent);
    }
    public void start5lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level5.class);
        startActivity(intent);
    }
    public void start6lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level6.class);
        startActivity(intent);
    }

    public void start7lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level7.class);
        startActivity(intent);
    }
    public void start8lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level8.class);
        startActivity(intent);
    }
    public void start9lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level9.class);
        startActivity(intent);
    }
    public void start10lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level10.class);
        startActivity(intent);
    }
    public void start11lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level11.class);
        startActivity(intent);
    }
    public void start12lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level12.class);
        startActivity(intent);
    }
    public void start13lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level13.class);
        startActivity(intent);
    }
    public void start14lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level14.class);
        startActivity(intent);
    }
    public void start15lvl(View v){
        startp(pitbul);
        Intent intent = new Intent(this, level15.class);
        startActivity(intent);
    }
    public void back(View v){
        startp(pitbul);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

public void startp(MediaPlayer sound){
        sound.start();

}

    public void tb(View v){
        dialog.show();

    }

}