package com.example.tripmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.style.TtsSpan;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripmore.adapter.RecentsAdapter;
import com.example.tripmore.adapter.TopPlacesAdapter;
import com.example.tripmore.model.RecentsData;
import com.example.tripmore.model.TopPlacesData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recentRecycler,topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    TextView fullname;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fullname=findViewById(R.id.name);
        //email=findViewById(R.id.email);
        /*showalluserdata();*/

        Intent intent = getIntent();
        String emailL = intent.getStringExtra("email");


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("emailS").equalTo(emailL);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    //email.setError(null);
                    String firstNameFromDB=snapshot.child(emailL).child("firstNameS").getValue(String.class);
                    String lastNameFromDB=snapshot.child(emailL).child("lastNameS").getValue(String.class);

                    String nameA=firstNameFromDB+" "+lastNameFromDB;

                    fullname.setText(nameA);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        List<RecentsData>recentsDataList= new ArrayList<>();
        recentsDataList.add(new RecentsData("Cox's Bazar","Bangladesh","4999Taka",R.drawable.coxsbazar));
        recentsDataList.add(new RecentsData("Bandarban","Bangladesh","3999Taka",R.drawable.bandarban));
        recentsDataList.add(new RecentsData("Sajek Valley","Bangladesh","2999Taka",R.drawable.sajek));
        recentsDataList.add(new RecentsData("Sylet","Bangladesh","3599Taka",R.drawable.sylet));
        recentsDataList.add(new RecentsData("Sundarban Forest","Bangladesh","6999Taka",R.drawable.sundarban));
        recentsDataList.add(new RecentsData("Saint Martin Island","Bangladesh","7999Taka",R.drawable.saint));

        setRecentRecycler(recentsDataList);


        List<TopPlacesData> topPlacesDataList= new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Cox's Bazar","Bangladesh","4999Taka",R.drawable.ca));
        topPlacesDataList.add(new TopPlacesData("Sundarban Forest","Bangladesh","6999Taka",R.drawable.sbb));
        topPlacesDataList.add(new TopPlacesData("Sajek Valley","Bangladesh","2999Taka",R.drawable.sb));
        topPlacesDataList.add(new TopPlacesData("Saint Martin Island","Bangladesh","7999Taka",R.drawable.saaa));
        topPlacesDataList.add(new TopPlacesData("Sylet","Bangladesh","3599Taka",R.drawable.sbbbb));
        topPlacesDataList.add(new TopPlacesData("Bandarban","Bangladesh","3999Taka",R.drawable.bbb));

        setTopPlacesRecycler(topPlacesDataList);

        getSupportActionBar().hide();
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button b1;

        b1=(Button)findViewById(R.id.editTextTextPersonName);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Home.this, Search.class);

                startActivity(intent3);
            }
        });

        ImageView imageButton;
        imageButton= (ImageView) findViewById(R.id.imageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    Intent intent3 = new Intent(Home.this, Profile.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                /*String name=intent.getStringExtra("name");

                String fname=intent.getStringExtra("fname");
                String lname=intent.getStringExtra("lname");
                String phone=intent.getStringExtra("phone");
                String password=intent.getStringExtra("password");*/
                intent3.putExtra("email",email);
                // intent3.putExtra("firstNameS",firstNameFromDB);
                //intent3.putExtra("lastNameS",lastNameFromDB);
                /*intent3.putExtra("name",name);
                intent3.putExtra("fname",fname);
                intent3.putExtra("lname",lname);
                intent3.putExtra("phone",phone);
                intent3.putExtra("password",password);*/

                startActivity(intent3);
            }
        });

        ImageView imageButton2;
        imageButton2= (ImageView) findViewById(R.id.imageView1);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Home.this, Explore.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);



                startActivity(intent3);
            }
        });

        ImageView imageButton4;
        imageButton4= (ImageView) findViewById(R.id.logoutplease);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent5 = new Intent(Home.this, Login.class);
                /*Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);*/

                startActivity(intent5);
            }
        });

        ImageView imageButton3;
        imageButton3= (ImageView) findViewById(R.id.imageView2);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(Home.this, Myplan.class);
                Intent intent=getIntent();
                String email=intent.getStringExtra("email");
                intent3.putExtra("email",email);

                startActivity(intent3);
            }
        });





        /*ImageView imageButton20;
        imageButton20= (ImageView) findViewById(R.id.layout);
        imageButton20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent3 = new Intent(Home.this, Login.class);
                Toast.makeText(Home.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                //Intent intent=getIntent();




                startActivity(intent3);
            }
        });*/





    }

    /*RecentsAdapter.RecentsViewHolder holder;
    holder.layout. setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent3 = new Intent(Home.this, RecentsAdapter.class);

            startActivity(intent3);
        }
    });*/





    /*private void showalluserdata() {
        Intent intent=getIntent();
        String ffname=intent.getStringExtra("name");

        fullname.setText(ffname);
    }*/

    private void setRecentRecycler(List<RecentsData>recentsDataList)
    {
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter=new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<TopPlacesData>TopPlacesDataList)
    {
        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter=new TopPlacesAdapter(this,TopPlacesDataList);
        //topPlacesRecycler.setAdapter(recentsAdapter);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Asik");
        return super.onCreateOptionsMenu(menu);
    }*/
}