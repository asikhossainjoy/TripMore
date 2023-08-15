package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextView fullname,email,password;
    EditText fname,lname,phone;
    FirebaseDatabase database;
    DatabaseReference reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fullname=findViewById(R.id.name);
        email=findViewById(R.id.email);
        fname=findViewById(R.id.firstNameS);
        lname=findViewById(R.id.lastNameS);
        phone=findViewById(R.id.phoneS);
        password=findViewById(R.id.passwordS);
        //showalluserdata();

        Intent intent = getIntent();
        String emailL = intent.getStringExtra("email");


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("emailS").equalTo(emailL);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    //email.setError(null);
                    String fnameL=snapshot.child(emailL).child("firstNameS").getValue(String.class);
                    String lnameL=snapshot.child(emailL).child("lastNameS").getValue(String.class);
                    String phoneL=snapshot.child(emailL).child("phoneS").getValue(String.class);
                    String passwordL=snapshot.child(emailL).child("passwordS").getValue(String.class);

                    String nameA=fnameL+" "+lnameL;

                    fullname.setText(nameA);
                    email.setText(emailL);
                    fname.setText(fnameL);
                    lname.setText(lnameL);
                    phone.setText(phoneL);
                    password.setText(passwordL);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });


        Button b2;
        b2=(Button)findViewById(R.id.p3);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Profile.this, Profile.class);

                //String name=fullname.setText();
                String emailL=email.getText().toString();
                String fnameL=fname.getEditableText().toString();
                String lnameL=lname.getEditableText().toString();
                String name=fnameL+" "+lnameL;
                String passwordL=password.getText().toString();


                String phoneL=phone.getEditableText().toString();
                intent3.putExtra("email",emailL);
                // intent3.putExtra("firstNameS",firstNameFromDB);
                //intent3.putExtra("lastNameS",lastNameFromDB);
                database= FirebaseDatabase.getInstance();
                reference2=database.getReference("users");
                HelperClass helperClass = new HelperClass(fnameL, lnameL, emailL, phoneL, passwordL);

                reference2.child(emailL).setValue(helperClass);

                Toast.makeText(Profile.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();

                /*intent3.putExtra("name",name);
                intent3.putExtra("fname",fnameL);
                intent3.putExtra("lname",lnameL);
                intent3.putExtra("phone",phoneL);
                intent3.putExtra("password",passwordL);*/

                startActivity(intent3); finish();
            }
        });


        ImageView imageButton2;
        imageButton2= (ImageView) findViewById(R.id.back);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Profile.this, Home.class);

                //String name=fullname.setText();
                /*String emailL=email.getText().toString();
                String fnameL=fname.getEditableText().toString();
                String lnameL=lname.getEditableText().toString();
                String name=fnameL+" "+lnameL;
                String passwordL=password.getText().toString();


                String phoneL=phone.getEditableText().toString();*/
                intent3.putExtra("email",emailL);
                // intent3.putExtra("firstNameS",firstNameFromDB);
                //intent3.putExtra("lastNameS",lastNameFromDB);
                /*database= FirebaseDatabase.getInstance();
                reference2=database.getReference("users");
                HelperClass helperClass = new HelperClass(fnameL, lnameL, emailL, phoneL, passwordL);

                reference2.child(emailL).setValue(helperClass);

                Toast.makeText(Profile.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();*/

                /*intent3.putExtra("name",name);
                intent3.putExtra("fname",fnameL);
                intent3.putExtra("lname",lnameL);
                intent3.putExtra("phone",phoneL);
                intent3.putExtra("password",passwordL);*/

                startActivity(intent3); finish();
            }
        });


    }



    private void showalluserdata() {
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String emailL=intent.getStringExtra("email");
        String fnameL=intent.getStringExtra("fname");
        String lnameL=intent.getStringExtra("lname");
        String phoneL=intent.getStringExtra("phone");
        String passwordL=intent.getStringExtra("password");
        /*DataSnapshot snapshot = null;
        String firstNameFromDB=snapshot.child(femail).child("firstNameS").getValue(String.class);
        String lastNameFromDB=snapshot.child(femail).child("lastNameS").getValue(String.class);
        String phoneFromDB=snapshot.child(femail).child("phoneS").getValue(String.class);*/

        fullname.setText(name);
        email.setText(emailL);
        fname.setText(fnameL);
        lname.setText(lnameL);
        phone.setText(phoneL);
        password.setText(passwordL);

    }


}