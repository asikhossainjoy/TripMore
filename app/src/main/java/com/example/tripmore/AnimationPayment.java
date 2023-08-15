package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class AnimationPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_payment);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread(){
            public void run(){
                try{
                    sleep(2800);
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    Intent intent2=new Intent(AnimationPayment.this,Home.class);
                    Intent intent=getIntent();
                    String email=intent.getStringExtra("email");
                    intent2.putExtra("email",email);
                    startActivity(intent2);
                    finish();
                }
            }
        };td.start();
    }
}