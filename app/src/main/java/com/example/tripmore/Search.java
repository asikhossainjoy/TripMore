package com.example.tripmore;

import static com.example.tripmore.adapter.TopPlacesAdapter.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.tripmore.adapter.RecentsAdapter;
import com.example.tripmore.adapter.TopPlacesAdapter;
import com.example.tripmore.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Search extends AppCompatActivity {

    List<TopPlacesData> topPlacesDataList= new ArrayList<>();
    RecyclerView recentRecycler,topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });


        topPlacesDataList.add(new TopPlacesData("Cox's Bazar","Bangladesh","4999Taka",R.drawable.ca));
        topPlacesDataList.add(new TopPlacesData("Sundarban Forest","Bangladesh","6999Taka",R.drawable.sbb));
        topPlacesDataList.add(new TopPlacesData("Sajek Valley","Bangladesh","2999Taka",R.drawable.sb));
        topPlacesDataList.add(new TopPlacesData("Saint Martin Island","Bangladesh","7999Taka",R.drawable.saaa));
        topPlacesDataList.add(new TopPlacesData("Sylet","Bangladesh","3599Taka",R.drawable.sbbbb));
        topPlacesDataList.add(new TopPlacesData("Bandarban","Bangladesh","3999Taka",R.drawable.bbb));

        setTopPlacesRecycler(topPlacesDataList);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void fileList(String Text) {
        List<TopPlacesData>filteredList=new ArrayList<>();
        for (TopPlacesData item : topPlacesDataList){
            if(item.getPlaceName().toLowerCase().contains(Text.toLowerCase())){
                filteredList.add(item);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else {
            topPlacesAdapter.setFilteredList(filteredList);
        }
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
}