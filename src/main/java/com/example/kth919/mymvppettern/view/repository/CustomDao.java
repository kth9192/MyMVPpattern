package com.example.kth919.mymvppettern.view.repository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CustomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CustomRoom... customRoom);

    @Delete
    void delete(CustomRoom customRoom);

    @Query("SELECT * from CustomRoom")
    LiveData<List<CustomRoom>> getAll();

    @Query("SELECT COUNT(title) from CustomRoom")
    int getCount();
}
