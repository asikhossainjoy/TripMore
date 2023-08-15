package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SignupAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_animation);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread(){
            public void run(){
                try{
                    sleep(2800);
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    Intent intent=new Intent(SignupAnimation.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}