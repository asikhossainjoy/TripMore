package com.example.tripmore.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripmore.DetailsActivity;
import com.example.tripmore.DetailsActivity2;
import com.example.tripmore.DetailsActivity3;
import com.example.tripmore.DetailsActivity4;
import com.example.tripmore.DetailsActivity5;
import com.example.tripmore.DetailsActivity6;
import com.example.tripmore.R;
import com.example.tripmore.model.RecentsData;
import com.example.tripmore.model.TopPlacesData;

import java.util.List;

public class TopPlacesAdapter extends RecyclerView.Adapter<TopPlacesAdapter.TopPlacesViewHolder> {
    Context context;
    List<TopPlacesData>topPlacesDataList;

    public void setFilteredList(List<TopPlacesData> filteredList){
        this.topPlacesDataList=filteredList;
        notifyDataSetChanged();
    }

    public TopPlacesAdapter(Context context, List<TopPlacesData> recentsDataList) {
        this.context = context;
        this.topPlacesDataList = recentsDataList;
    }

    @NonNull
    @Override
    public TopPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_places_row_item,parent,false);
        //edit>View view = LayoutInflater.from(context).inflate(R.layout,parent,false);
        return new TopPlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlacesViewHolder holder, int position) {
        holder.countryName.setText(topPlacesDataList.get(position).getCountryName());
        holder.placeName.setText(topPlacesDataList.get(position).getPlaceName());
        holder.price.setText(topPlacesDataList.get(position).getPrice());
        holder.placeImage.setImageResource(topPlacesDataList.get(position).getImageUrl());

        switch(position){
            case 0:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 1:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity5.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 2:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity3.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 3:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity6.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 4:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity4.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 5:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity2.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return topPlacesDataList.size();
    }

    public static final class TopPlacesViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage ;
        TextView placeName,countryName,price;

        public TopPlacesViewHolder(@NonNull View itemView){
            super(itemView);

            placeImage= itemView.findViewById(R.id.place_image);
            placeName= itemView.findViewById(R.id.place_name);
            countryName= itemView.findViewById(R.id.country_name);
            price= itemView.findViewById(R.id.price);
        }
    }
}
