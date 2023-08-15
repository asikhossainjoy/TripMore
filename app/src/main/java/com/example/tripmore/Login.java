package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        loginBtn=findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailL=email.getText().toString();
                String passwordL=password.getText().toString();

                if(emailL.isEmpty() || passwordL.isEmpty()){
                    Toast.makeText(Login.this, "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
                    Query checkUserDatabase= reference.orderByChild("emailS").equalTo(emailL);

                    /*DatabaseReference reference2= FirebaseDatabase.getInstance().getReference("tickets");
                    Query checkUserDatabase2= reference.orderByChild("email").equalTo(emailL);*/

                    checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                email.setError(null);
                                String passwordFromDB=snapshot.child(emailL).child("passwordS").getValue(String.class);
                                String firstNameFromDB=snapshot.child(emailL).child("firstNameS").getValue(String.class);
                                String lastNameFromDB=snapshot.child(emailL).child("lastNameS").getValue(String.class);
                                String phoneFromDB=snapshot.child(emailL).child("phoneS").getValue(String.class);
                                String name=firstNameFromDB+" "+lastNameFromDB;


                                /*/////////
                                String availableFlightDB=snapshot.child(emailL).child("availableFlight").getValue(String.class);
                                String durationDB=snapshot.child(emailL).child("duration").getValue(String.class);
                                String packageNameDB=snapshot.child(emailL).child("packageName").getValue(String.class);
                                String paymentDB=snapshot.child(emailL).child("payment").getValue(String.class);*/


                                if(!Objects.equals(passwordFromDB,passwordL)){
                                    password.setError("Wrong password");
                                    password.requestFocus();
                                }else{

                                    //email.setError(null);
                                    Toast.makeText(Login.this, "Login successfully!", Toast.LENGTH_SHORT).show();

                                    //String emailS=snapshot.child(emailL)
                                    Intent intent3 = new Intent(Login.this, Home.class);

                                    intent3.putExtra("email",emailL);
                                   // intent3.putExtra("firstNameS",firstNameFromDB);
                                    //intent3.putExtra("lastNameS",lastNameFromDB);




                                    /*intent3.putExtra("name",name);
                                    intent3.putExtra("fname",firstNameFromDB);
                                    intent3.putExtra("lname",lastNameFromDB);
                                    intent3.putExtra("phone",phoneFromDB);
                                    intent3.putExtra("password",passwordFromDB);*/







                                    /*intent3.putExtra("availableFlight",availableFlightDB);
                                    intent3.putExtra("duration",durationDB);
                                    intent3.putExtra("packageName",packageNameDB);
                                    intent3.putExtra("payment",paymentDB);*/

                                    /*Intent intent = new Intent(Login.this, DetailsActivity.class);
                                    intent.putExtra("emailL",emailL);
                                    startActivity(intent);*/


                                    startActivity(intent3);
                                    //finish();


                                    /*email.setText(null);
                                    password.setText(null);*/

                                }
                            }else{
                                email.setError("User does not exist");
                                email.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    });
                }


            }


        });



        /*///start
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);
        final Button loginBtn=findViewById(R.id.loginBtn);
        //final TextView loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailTxt=email.getText().toString();
                final String passwordTxt=password.getText().toString();

                if(emailTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login.this, "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }
                else{

                }


            }


        });*/

        /*Button b1;
        b1=(Button)findViewById(R.id.loginBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Login.this, Home.class);

                startActivity(intent3);
            }
        });*/
        Button b2;
        b2=(Button)findViewById(R.id.signupBtn);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Login.this, Signup.class);

                startActivity(intent3);
            }
        });
    }
}