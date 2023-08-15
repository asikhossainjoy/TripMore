package com.example.tripmore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tripmore.DetailsActivity;
import com.example.tripmore.DetailsActivity2;
import com.example.tripmore.DetailsActivity3;
import com.example.tripmore.DetailsActivity4;
import com.example.tripmore.DetailsActivity5;
import com.example.tripmore.DetailsActivity6;
import com.example.tripmore.R;
import com.example.tripmore.model.RecentsData;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {
    Context context;
    List<RecentsData>recentsDataList;

    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }


    @Override
    public RecentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);
        //edit>View view = LayoutInflater.from(context).inflate(R.layout,parent,false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecentsViewHolder holder, int position) {
        holder.countryName.setText(recentsDataList.get(position).getCountryName());
        holder.placeName.setText(recentsDataList.get(position).getPlaceName());
        holder.price.setText(recentsDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentsDataList.get(position).getImageUrl());

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, DetailsActivity.class);
                context.startActivities(new Intent[]{i});
            }
        });*/
        switch(position){
            case 0:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(),DetailsActivity.class);
                        //o
//                        String email=intent.getStringExtra("email");
//                        intent.putExtra("email",email);

                        view.getContext().startActivities(new Intent[]{intent});


                    }
                });
                break;
            case 1:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity2.class);
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
                        Intent intent=new Intent(view.getContext(), DetailsActivity4.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 4:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity5.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
            case 5:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), DetailsActivity6.class);
                        view.getContext().startActivities(new Intent[]{intent});
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage ;
        TextView placeName,countryName,price;

        public RecentsViewHolder( View itemView){
            super(itemView);

            placeImage= itemView.findViewById(R.id.place_image);
            placeName= itemView.findViewById(R.id.place_name);
            countryName= itemView.findViewById(R.id.country_name);
            price= itemView.findViewById(R.id.price);
        }
    }
}
