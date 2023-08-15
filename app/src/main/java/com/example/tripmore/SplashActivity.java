package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread(){
            public void run(){
                try{
                    sleep(9500);
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    Intent intent=new Intent(SplashActivity.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();

    }
}