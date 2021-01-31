package com.example.viktoriva_by_chiko;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level14 extends AppCompatActivity {
    public MediaPlayer fon;

    public MediaPlayer correct;
    public MediaPlayer incorrect;

    Random random = new Random() ;
    Array array = new Array();


    Dialog dialog;
    Dialog dialogEnd;


    public int numLeft;
    public int numRight;

    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unilvlvshort);
        fon= MediaPlayer.create(this, R.raw.human1);

        correct=MediaPlayer.create(this, R.raw.correct);
        incorrect=MediaPlayer.create(this, R.raw.incorrect);



        TextView tvlvl=findViewById(R.id.lvl);
        tvlvl.setText(R.string.level14);


        ImageView img2 = findViewById(R.id.back1);
        img2.setImageResource(R.drawable.fbackk);

        ImageView imgLeft = findViewById(R.id.imgLeft);
        ImageView imgRight = findViewById(R.id.imgRight);


        TextView t1 = findViewById(R.id.textLeft);
        TextView t2 = findViewById(R.id.textRight);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fourteenlvldialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);


        Button btnback = dialog.findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(level14.this, Gamelevels.class);
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

                Intent intent = new Intent(level14.this, level15.class);
                startActivity(intent);
                dialogEnd.dismiss();



            }
        });






        final int[] progress= {

                R.id.p1, R.id.p2,R.id.p3,R.id.p4,R.id.p5,
                R.id.p6,R.id.p7,R.id.p8,R.id.p9,R.id.p10,
                R.id.p11,R.id.p12,R.id.p13,R.id.p14,R.id.p15,
        };
        final Animation a = AnimationUtils.loadAnimation(level14.this, R.anim.alpha);//в
        numLeft=random.nextInt(20);
        imgLeft.setImageResource(array.img14[numLeft]);
        t1.setText(array.texts14[numLeft]);


        numRight=random.nextInt(20);
        while(array.value14[numLeft]==array.value14[numRight]){
            numRight=random.nextInt(20);

        }
        imgRight.setImageResource(array.img14[numRight]);
        t2.setText(array.texts14[numRight]);



        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

            if(event.getAction()==MotionEvent.ACTION_DOWN){
                imgRight.setEnabled(false);

                if(array.value14[numLeft]>array.value14[numRight]){
                    imgLeft.setImageResource(R.drawable.right);
                    sound(correct);
                }else{
                    imgLeft.setImageResource(R.drawable.wrong);
                    sound(incorrect);
                }

            }else if(event.getAction()==MotionEvent.ACTION_UP){
                if(array.value14[numLeft]>array.value14[numRight]){
                    if(count<15){
                        count=count+1;
                    }

                for(int i=0; i<15; i++){
                    TextView tv = findViewById(progress[i]);
                    tv.setBackgroundResource(R.drawable.style_pints);
                }
                    for(int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);

                }
            }else{
                if(count>0){
                    if(count==1){
                        count=0;
                    }else{
                        count=count-2;

                    }
                }
                    for(int i=0; i<15; i++ ){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_pints);


                    }
                    for(int i=0; i<count;i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                }
                if(count==15){
                    dialogEnd.show();

                }else{
                    numLeft=random.nextInt(20);     //рандомное число для imgleft and textleft
                    imgLeft.setImageResource(array.img14[numLeft]);//достаем из массива картинку(например рандомное число 1, следовательно достается картинка под номером один(отсчет идет с 0 до 9))
                    t1.setText(array.texts14[numLeft]);

                    imgLeft.startAnimation(a);
                    numRight=random.nextInt(20);//рандомное число для right
                    while(array.value14[numLeft]==array.value14[numRight]){
                        numRight=random.nextInt(20);
                    }
                    imgRight.setImageResource(array.img14[numRight]);//достаем из массива картинку(например рандомное число 1, следовательно достается картинка под номером один(отсчет идет с 0 до 9))


                    t2.setText(array.texts14[numRight]);
                    imgRight.startAnimation(a);
                    imgRight.setEnabled(true);//включаем правую кнопку
                }
            }

                return true;
            }
        });

        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    imgLeft.setEnabled(false);

                    if(array.value14[numLeft]<array.value14[numRight]){
                        imgRight.setImageResource(R.drawable.right);
                        sound(correct);
                    }else{
                        imgRight.setImageResource(R.drawable.wrong);
                        sound(incorrect);
                    }

                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    if(array.value14[numLeft]<array.value14[numRight]){
                        if(count<15){
                            count=count+1;
                        }

                        for(int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_pints);
                        }
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);

                        }
                    }else{
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;

                            }
                        }
                        for(int i=0; i<15; i++ ){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_pints);


                        }
                        for(int i=0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if(count==15){
                        dialogEnd.show();

                    }else{
                        numLeft=random.nextInt(20);     //рандомное число для imgleft and textleft
                        imgLeft.setImageResource(array.img14[numLeft]);//достаем из массива картинку(например рандомное число 1, следовательно достается картинка под номером один(отсчет идет с 0 до 9))
                        t1.setText(array.texts14[numLeft]);
                        imgLeft.startAnimation(a);

                        numRight=random.nextInt(20);//рандомное число для right
                        while(array.value14[numLeft]==array.value14[numRight]){
                            numRight=random.nextInt(20);
                        }
                        imgRight.setImageResource(array.img14[numRight]);//достаем из массива картинку(например рандомное число 1, следовательно достается картинка под номером один(отсчет идет с 0 до 9))
                        t2.setText(array.texts14[numRight]);
                        imgRight.startAnimation(a);
                        imgLeft.setEnabled(true);//включаем правую кнопку
                    }
                }

                return true;
            }
        });

    }




    public void backuniversal(View v){
        soundstop(fon);

        Intent intent = new Intent(this, Gamelevels.class);
        startActivity(intent);
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




