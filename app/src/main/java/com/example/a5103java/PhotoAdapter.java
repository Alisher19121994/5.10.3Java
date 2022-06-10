package com.example.a5103java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Photo> list;

    public PhotoAdapter(Context context, ArrayList<Photo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo, parent, false);
        return new PhotoViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Photo photo = list.get(position);

        if (holder instanceof PhotoViewHoder) {
            ((PhotoViewHoder) holder).imageView.setImageResource(photo.photo);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PhotoViewHoder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PhotoViewHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photo_id);
        }
    }
}
