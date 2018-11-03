package com.example.student.android12;

import android.content.Context;
import android.content.SharedPreferences;

public class IntManager {

    public static int nextInt(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int num = preferences.getInt("Number", 0);

        num++;
        if (num > 999999) {
            num = 1;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Number", num);
        editor.apply();

        return num;
    }
}
