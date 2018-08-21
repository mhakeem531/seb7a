package com.example.hakeem.sebha.helper;

import android.app.Application;
import android.content.Context;

public class MySuperAppApplication extends Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}