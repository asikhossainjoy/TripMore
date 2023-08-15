package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    EditText firstNameSS,lastNameSS,emailSS,phoneSS,passwordSS,repasswordSS;
    Button signupBtnSS;
    CheckBox checkSS;
    FirebaseDatabase database;
    DatabaseReference reference;

    //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://tripmore-e73ae-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        firstNameSS=findViewById(R.id.firstNameS);
        lastNameSS=findViewById(R.id.lastNameS);
        emailSS=findViewById(R.id.email);
        phoneSS=findViewById(R.id.phoneS);
        passwordSS=findViewById(R.id.passwordS);
        repasswordSS=findViewById(R.id.repasswardS);
        signupBtnSS=findViewById(R.id.signupBtnS);
        checkSS=findViewById(R.id.checkBox);

        signupBtnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");

                String firstNameS=firstNameSS.getText().toString();
                String lastNameS=lastNameSS.getText().toString();
                String emailS=emailSS.getText().toString();
                String phoneS=phoneSS.getText().toString();
                String passwordS=passwordSS.getText().toString();
                String repasswordS=repasswordSS.getText().toString();
                //String checkS=checkSS.getText().toString();
                Boolean checkS = checkSS.isChecked();

                if(firstNameS.isEmpty() || lastNameS.isEmpty() ||emailS.isEmpty() || phoneS.isEmpty() ||passwordS.isEmpty() || repasswordS.isEmpty()){
                    Toast.makeText(Signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();





                    if(repasswordS.isEmpty()) {
                        repasswordSS.setError("Please Enter Re-Password");
                        repasswordSS.requestFocus();
                    }
                    if(passwordS.isEmpty()) {
                        passwordSS.setError("Please Enter Password");
                        passwordSS.requestFocus();
                    }
                    if(phoneS.isEmpty()) {
                        phoneSS.setError("Please Fill Phone Number");
                        phoneSS.requestFocus();
                    }
                    if(emailS.isEmpty()) {
                        emailSS.setError("Please Enter Email Address");
                        emailSS.requestFocus();
                    }
                    if(lastNameS.isEmpty()) {
                        lastNameSS.setError("Please Enter Last Name");
                        lastNameSS.requestFocus();
                    }
                    if(firstNameS.isEmpty()) {
                        firstNameSS.setError("Please Enter First Name");
                        firstNameSS.requestFocus();
                    }
                }
                else if(passwordS.length()<6)
                {
                    //Toast.makeText(Signup.this, "Password must not be less than 6 word", Toast.LENGTH_SHORT).show();
                    passwordSS.setError("Password must not be less than 6 word");
                    passwordSS.requestFocus();
                }
                else if(!passwordS.equals(repasswordS))
                {
                    //Toast.makeText(Signup.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                    repasswordSS.setError("Passwords are not matching");
                    repasswordSS.requestFocus();
                }
                else if(!checkS.equals(true))
                {
                    Toast.makeText(Signup.this, "Please agree with the Terms and conditions and Privacy Policy", Toast.LENGTH_SHORT).show();
                    checkSS.setError("Please agree with the Terms and conditions and Privacy Policy");
                    checkSS.requestFocus();
                }
                else {
                    HelperClass helperClass = new HelperClass(firstNameS, lastNameS, emailS, phoneS, passwordS);

                    reference.child(emailS).setValue(helperClass);

                    Toast.makeText(Signup.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Signup.this, SignupAnimation.class);
                    startActivity(intent);
                    startActivity(intent);
                }
            }
        });

        /*final EditText firstNameS=findViewById(R.id.firstNameS);
        final EditText lastNameS=findViewById(R.id.lastNameS);
        final EditText emailS=findViewById(R.id.emailS);
        final EditText phoneS=findViewById(R.id.phoneS);
        final EditText passwordS=findViewById(R.id.passwordS);
        final EditText repasswordS=findViewById(R.id.repasswardS);
        final Button signupBtnS=findViewById(R.id.signupBtnS);

        signupBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstNameSTxt=firstNameS.getText().toString();
                final String lastNameSTxt=lastNameS.getText().toString();
                final String emailSTxt=emailS.getText().toString();
                final String phoneSTxt=phoneS.getText().toString();
                final String passwordSTxt=passwordS.getText().toString();
                final String repasswordSTxt=repasswordS.getText().toString();

                if(firstNameSTxt.isEmpty() || lastNameSTxt.isEmpty() ||emailSTxt.isEmpty() || phoneSTxt.isEmpty() ||passwordSTxt.isEmpty() || repasswordSTxt.isEmpty()){
                    Toast.makeText(Signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if(!passwordSTxt.equals(repasswordSTxt))
                {
                    Toast.makeText(Signup.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for(DataSnapshot : dataSnapshot.getchild(){

                            if(snapshot.hasChild(phoneSTxt)){
                                Toast.makeText(Signup.this, "Phone number is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(phoneSTxt).child("firstname").setValue(firstNameS);
                                databaseReference.child("users").child(phoneSTxt).child("lastname").setValue(lastNameS);
                                databaseReference.child("users").child(phoneSTxt).child("email").setValue(emailSTxt);
                                databaseReference.child("users").child(phoneSTxt).child("password").setValue(passwordS);

                                Toast.makeText(Signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    });


                }
            }
        });

        Button b1;
        b1=(Button)findViewById(R.id.signupBtnS);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Signup.this, SignupAnimation.class);

                startActivity(intent3);
            }
        });*/
    }
}