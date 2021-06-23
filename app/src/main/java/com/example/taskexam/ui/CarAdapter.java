package com.example.taskexam.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taskexam.Pojos.Car;
import com.example.taskexam.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private ArrayList<Car>carList = new ArrayList<>();
    private Context context;
//    public CarAdapter(ArrayList<Car> carList, Context context) {
//        this.carList = carList;
//        this.context = context;
//    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.brandTv.setText(carList.get(position).getBrand());
        if(carList.get(position).isUsed() == true){
            holder.isUsedTv.setText("isUsed");
        }else {
            holder.isUsedTv.setText("new");
        }

        holder.yearTv.setText(carList.get(position).getConstractionYear());
        Glide.with(context)
                .load(carList.get(position).getImageUrl())
                .centerCrop()
                .into(holder.carIv);
        holder.progressBar.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public void setList(List<Car> carList){
        this.carList = (ArrayList<Car>) carList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView brandTv,isUsedTv,yearTv;
        ImageView carIv;
        ProgressBar progressBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandTv = itemView.findViewById(R.id.tv_title);
            isUsedTv = itemView.findViewById(R.id.tv_used);
            yearTv = itemView.findViewById(R.id.tv_release_year);
            carIv = itemView.findViewById(R.id.iv_car);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
