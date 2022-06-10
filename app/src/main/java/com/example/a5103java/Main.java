package com.example.a5103java;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    LinkedList<Story> story = new LinkedList<>();
    ArrayList<Photo> photo = new ArrayList<>();
    Adds adds;

    public Main(LinkedList<Story> story) {
        this.story = story;
    }

    public Main(Adds adds) {
        this.adds = adds;
    }

    public Main(ArrayList<Photo> photo) {
        this.photo = photo;
    }
}
