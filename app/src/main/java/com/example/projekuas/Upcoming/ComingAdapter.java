package com.example.projekuas.Upcoming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekuas.R;

import java.util.List;

public class ComingAdapter extends RecyclerView.Adapter<ComingAdapter.ViewHolder> {
    List<ComingItem> result;
    Activity activity;
    public ComingAdapter(List<ComingItem> result, Activity activity){
        this.result = result;
        this.activity = activity;
    }
    public ComingAdapter(MyComing myComing) {
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        return new
                ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_list, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(result.get(position));
    }
    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_tipe, tv_age;
        ImageView posterView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.textViewFilmUp);
            tv_tipe = itemView.findViewById(R.id.tv_tipeUp);
            tv_age = itemView.findViewById(R.id.tv_ageUp);
            posterView = itemView.findViewById(R.id.ImageUp);
        }
        public void bind(ComingItem ComingItem) {
            tv_name.setText(ComingItem.name);
            tv_tipe.setText(ComingItem.tipe);
            tv_age.setText(ComingItem.age_rating);

            Glide.with(activity).load(ComingItem.getPoster()).into(posterView);
        }
    }
}
