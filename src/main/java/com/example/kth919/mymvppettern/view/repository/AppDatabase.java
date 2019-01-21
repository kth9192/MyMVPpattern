package com.example.kth919.mymvppettern.view.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {CustomRoom.class}, version = 1, exportSchema = false)
@TypeConverters({CustomTypeConverter.class})

public abstract class AppDatabase extends RoomDatabase {

    public abstract CustomDao customDao();

    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(Context context){
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "test_database")
                            .build();
                }
            }
        }
        return INSTANCE;

    }
}
