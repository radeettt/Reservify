package com.example.projekuas.CinemaSelect;

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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    List<MovieItem> result;
    Activity activity;
    public MovieAdapter(List<MovieItem> result, Activity activity){
        this.result = result;
        this.activity = activity;
    }
    public MovieAdapter(MyMovie myMovie) {
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        return new
                ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cinema_select_list, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int
            position) {
        holder.bind(result.get(position));
    }
    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_genres, tv_duration, tv_age;
        ImageView posterView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.textViewFilm);
            tv_genres = itemView.findViewById(R.id.tv_genres);
            tv_duration = itemView.findViewById(R.id.tv_duration);
            tv_age = itemView.findViewById(R.id.tv_age);
            posterView = itemView.findViewById(R.id.Image1);
        }
        public void bind(MovieItem MovieItem) {
            tv_name.setText(MovieItem.name);
            tv_genres.setText(MovieItem.genre);
            tv_duration.setText(MovieItem.duration);
            tv_age.setText(MovieItem.age_rating);

            Glide.with(activity).load(MovieItem.getPoster()).into(posterView);
        }
    }
}