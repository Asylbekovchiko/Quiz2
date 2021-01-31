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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level7 extends AppCompatActivity {

    public MediaPlayer correct;
    public MediaPlayer fon;


    Dialog dialogEnd;
    Dialog dialog;


    public int numLeft;
    public int numRight;

    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unilsevenvlv);
        fon= MediaPlayer.create(this, R.raw.heart);
        correct=MediaPlayer.create(this, R.raw.correct);


        TextView t7=findViewById(R.id.l7);
        t7.setText(R.string.leve71);

        ImageView img2 = findViewById(R.id.back1);
        img2.setImageResource(R.drawable.sphone);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

///

        dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sevenlvldialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);


        Button btnback = dialog.findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(level7.this, Gamelevels.class);
                    startActivity(intent);
                    finish();
                }catch(Exception e){

                }

            }

        });

        Button btncontinue2 = (Button)dialog.findViewById(R.id.btn_continue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound(fon);
                dialog.dismiss();



            }
        });
        dialog.show();
/////////////////////////////////////////////////////////////
        dialogEnd = new Dialog(this);

        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);




        Button btncontinueend = (Button)dialogEnd.findViewById(R.id.btn_continue);
        btncontinueend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundstop(fon);
                Intent intent = new Intent(level7.this, level8.class);
                startActivity(intent);
                dialogEnd.dismiss();



            }
        });







    }




    public void backuniversal(View v){
        soundstop(fon);
        Intent intent = new Intent(this, Gamelevels.class);
        startActivity(intent);
    }

    public void btngoal(View v){
        soundstop(fon);
        sound(correct);
       dialogEnd.show();




    }



    public void sound(MediaPlayer sound){
        sound.start();
    }

    public void onBackPressed(){
        soundstop(fon);
        Intent intent = new Intent(this, Gamelevels.class);
        startActivity(intent);
    }


    public void soundstop(MediaPlayer sound){
        sound.stop();
    }

}




