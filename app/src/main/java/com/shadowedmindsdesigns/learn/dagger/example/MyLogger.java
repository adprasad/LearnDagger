package com.shadowedmindsdesigns.learn.dagger.example;

import android.util.Log;

public class MyLogger  {
    private final String TAG = "DEFAULT";
    public MyLogger() {
    }

    public void d(String s){
        Log.d(TAG, s);
    }
}
