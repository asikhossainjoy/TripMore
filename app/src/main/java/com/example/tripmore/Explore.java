package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Intent intent=getIntent();
        //String email=intent.getStringExtra("email");
        //intent3.putExtra("email",emailL);

        ImageView imageButton2;
        imageButton2= (ImageView) findViewById(R.id.coxsEx);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton3;
        imageButton3= (ImageView) findViewById(R.id.coxsEx2);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity5.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton4;
        imageButton4= (ImageView) findViewById(R.id.coxsEx3);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity6.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton5;
        imageButton5= (ImageView) findViewById(R.id.coxsEx4);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity3.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton6;
        imageButton6= (ImageView) findViewById(R.id.coxsEx5);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity4.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton7;
        imageButton7= (ImageView) findViewById(R.id.coxsEx6);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Explore.this, DetailsActivity2.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });
    }
}