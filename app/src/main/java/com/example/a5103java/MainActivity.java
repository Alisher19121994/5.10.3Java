package com.example.a5103java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter(data());
    }

    public ArrayList<Main> data() {
        LinkedList<Story> stories = new LinkedList<>();
        ArrayList<Photo> photos = new ArrayList<>();
        ArrayList<Main> mains = new ArrayList<>();
        mains.add(new Main(stories));
        mains.add(new Main(photos));

        for (int i = 0; i < 30; i++) {
            stories.add(new Story(R.drawable.ali, "Alisher"));
        }

        for (int i = 0; i < 8; i++) {
            photos.add(new Photo(R.drawable.ali));
        }

        for (int i = 0; i < 30; i++) {
            if (i == 1) {
                Adds adds = new Adds(R.drawable.c);
                mains.add(new Main(adds));
            } else {
                mains.add(new Main(photos));
            }
        }

        return mains;
    }


    public void adapter(ArrayList<Main> mains) {
        PostAdapter postAdapter = new PostAdapter(this, mains);
        recyclerView.setAdapter(postAdapter);
    }
}