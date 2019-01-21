package com.example.kth919.mymvppettern.view.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class CustomTypeConverter {
    @TypeConverter
    public static List<String> stringToStringModelList(String data) {

        Type listType = new TypeToken<List<String>>() {}.getType();

        return new Gson().fromJson(data, listType);
    }

    @TypeConverter
    public static String stringModelListToString(List<String> someObjects) {

        Gson gson = new Gson();
        String json = gson.toJson(someObjects);

        return json;
    }
}
