package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Myplan extends AppCompatActivity {

    TextView availableFlight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplan);

        availableFlight=findViewById(R.id.ac);
        /*showalluserdata();*/

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Intent intent = getIntent();
        String emailL = intent.getStringExtra("email");


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("tickets");
        Query checkUserDatabase = reference.orderByChild("email").equalTo(emailL);


        availableFlight.setText("No Data Found");

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    //email.setError(null);
                    String availableFlightDB = snapshot.child(emailL).child("availableFlight").getValue(String.class);
                    String durationDB = snapshot.child(emailL).child("duration").getValue(String.class);
                    String packageNameDB = snapshot.child(emailL).child("packageName").getValue(String.class);
                    String paymentDB = snapshot.child(emailL).child("payment").getValue(String.class);

                    availableFlight.setText("Package Name : "+packageNameDB+"\n"+"Available Flight : "+availableFlightDB+"\n"+"Duration : "+durationDB+"\n"+"Payment : "+paymentDB);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });





    }

    /*private void showalluserdata() {

        *//**//*
    }*/
}