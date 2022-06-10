package com.example.a5103java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.LinkedList;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    LinkedList<Story> list;

    public StoryAdapter(Context context, LinkedList<Story> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_view, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story story = list.get(position);

        if (holder instanceof StoryViewHolder) {
            ((StoryViewHolder) holder).profile.setImageResource(story.profile);
            ((StoryViewHolder) holder).fullname.setText(story.fullname);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView profile;
        TextView fullname;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.story_profile_id);
            fullname = itemView.findViewById(R.id.story_fullname_id);
        }
    }
}
