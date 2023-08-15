package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nagad extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    EditText firstNameSS,lastNameSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagad);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        firstNameSS=findViewById(R.id.lastNameS2);
        lastNameSS=findViewById(R.id.lastNameS);


        Button Button2;
        Button2= (Button) findViewById(R.id.p3);
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String firstNameS=firstNameSS.getText().toString();
                String lastNameS=lastNameSS.getText().toString();

                if(firstNameS.isEmpty() || lastNameS.isEmpty()){


                    if (firstNameS.isEmpty()) {
                        firstNameSS.setError("Please Enter Nagad Number");
                        firstNameSS.requestFocus();
                    }
                    if (lastNameS.isEmpty()) {
                        lastNameSS.setError("Please Enter Nagad Pin");
                        lastNameSS.requestFocus();
                    }
                }else{
                    database= FirebaseDatabase.getInstance();

                reference=database.getReference("tickets");

                Intent intent3 = new Intent(Nagad.this,AnimationPayment.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                String packageName=intent.getStringExtra("packageName");
                String availableFlight=intent.getStringExtra("availableFlight");
                String duration=intent.getStringExtra("duration");
                String payment=intent.getStringExtra("payment");
                intent3.putExtra("email",email);

                HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                reference.child(email).setValue(helperClass2);






                // HelperClass2 helperClass2 = new HelperClass2(email,packageName, availableFlight, duration, payment);
                //reference.child(packageName).setValue(helperClass2);






                startActivity(intent3);}
            }
        });
    }
}