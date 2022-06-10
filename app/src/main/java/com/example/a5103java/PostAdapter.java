package com.example.a5103java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.LinkedList;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Main> list;

    public PostAdapter(Context context, ArrayList<Main> list) {
        this.context = context;
        this.list = list;
    }


    private int STORY = 0;
    private int PHOTO = 1;
    private int ADDs = 2;

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).story.size() > 0) {
            return STORY;
        } else if (list.get(position).photo.size() > 0) {
            return PHOTO;
        }
        return ADDs;
    }

    public void storyAdapter(LinkedList<Story> stories, RecyclerView recyclerView) {
        StoryAdapter storyAdapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(storyAdapter);
    }

    public void photoAdapter(ArrayList<Photo> photos, RecyclerView recyclerView) {
        PhotoAdapter photoAdapter = new PhotoAdapter(context, photos);
        recyclerView.setAdapter(photoAdapter);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == STORY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story, parent, false);
            return new StoryViewHolder(view);
        } else if (viewType == PHOTO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
            return new PhotoViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adds_view, parent, false);
        return new AddsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Main main = list.get(position);

        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            storyAdapter(main.story, recyclerView);
        }


        if (holder instanceof PhotoViewHolder) {
            RecyclerView recyclerView = ((PhotoViewHolder) holder).recyclerView;
            photoAdapter(main.photo, recyclerView);
        }


        /*if (holder instanceof AddsViewHolder) {
            ((AddsViewHolder) holder).adds.setImageResource(main.adds);
        }*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView = itemView.findViewById(R.id.story_recyclerview);

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView = itemView.findViewById(R.id.photo_recyclerview);

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    public class AddsViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView adds;

        public AddsViewHolder(@NonNull View itemView) {
            super(itemView);
            adds = itemView.findViewById(R.id.car_id);
        }
    }
}
