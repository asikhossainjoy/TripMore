package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imageButton2;
        imageButton2= (ImageView) findViewById(R.id.imageView13);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Payment.this, Bkash.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                String packageName=intent.getStringExtra("packageName");
                String availableFlight=intent.getStringExtra("availableFlight");
                String duration=intent.getStringExtra("duration");
                String payment=intent.getStringExtra("payment");






                // HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                //reference.child(packageName).setValue(helperClass2);


                intent3.putExtra("email",email);
                intent3.putExtra("packageName",packageName);
                intent3.putExtra("availableFlight",availableFlight);
                intent3.putExtra("duration",duration);
                intent3.putExtra("payment",payment);



                startActivity(intent3);
            }
        });

        ImageView imageButton3;
        imageButton3= (ImageView) findViewById(R.id.n);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Payment.this, Nagad.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                String packageName=intent.getStringExtra("packageName");
                String availableFlight=intent.getStringExtra("availableFlight");
                String duration=intent.getStringExtra("duration");
                String payment=intent.getStringExtra("payment");






                // HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                //reference.child(packageName).setValue(helperClass2);


                intent3.putExtra("email",email);
                intent3.putExtra("packageName",packageName);
                intent3.putExtra("availableFlight",availableFlight);
                intent3.putExtra("duration",duration);
                intent3.putExtra("payment",payment);



                startActivity(intent3);
            }
        });

        ImageView imageButton4;
        imageButton4= (ImageView) findViewById(R.id.visa);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Payment.this, Card.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                String packageName=intent.getStringExtra("packageName");
                String availableFlight=intent.getStringExtra("availableFlight");
                String duration=intent.getStringExtra("duration");
                String payment=intent.getStringExtra("payment");






                // HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                //reference.child(packageName).setValue(helperClass2);


                intent3.putExtra("email",email);
                intent3.putExtra("packageName",packageName);
                intent3.putExtra("availableFlight",availableFlight);
                intent3.putExtra("duration",duration);
                intent3.putExtra("payment",payment);



                startActivity(intent3);
            }
        });

    }
}