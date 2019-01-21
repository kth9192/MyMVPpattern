package com.example.kth919.mymvppettern.view.repository;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomRoom {

    @PrimaryKey
    @NonNull
    private String id;

    private String title;

    public CustomRoom(@NonNull String id, String title) {
        this.id = id;
        this.title = title;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
