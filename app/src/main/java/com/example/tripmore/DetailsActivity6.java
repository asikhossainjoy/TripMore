package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class DetailsActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details6);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button bookBtnSS;
        bookBtnSS=findViewById(R.id.bookBtn6);
        bookBtnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //database= FirebaseDatabase.getInstance();
                //reference=database.getReference("tickets");

                //oo
                Intent intent2 = new Intent(DetailsActivity6.this, Payment.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                /*String email="as";*/

                String packageName="Saint Martin Island, Bangladesh";
                String availableFlight="01 January, 2024";
                String duration="3 night 2 day";
                String payment="Paid";


                // HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                //reference.child(packageName).setValue(helperClass2);


                intent2.putExtra("email",email);
                intent2.putExtra("packageName",packageName);
                intent2.putExtra("availableFlight",availableFlight);
                intent2.putExtra("duration",duration);
                intent2.putExtra("payment",payment);

                startActivity(intent2);


            }
        });


        ImageView imageButton2;
        imageButton2= (ImageView) findViewById(R.id.back);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(DetailsActivity6.this, Explore.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");


                intent2.putExtra("email",email);


                startActivity(intent2); finish();
            }
        });
    }
}