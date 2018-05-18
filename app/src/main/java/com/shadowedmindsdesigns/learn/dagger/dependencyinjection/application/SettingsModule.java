package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.shadowedmindsdesigns.learn.dagger.example.common.Constants;
import com.shadowedmindsdesigns.learn.dagger.example.common.service.SettingsManager;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {

    @Provides
    @ApplicationScope
    SettingsManager settingsManager(Application app){
        SharedPreferences sharedPreferences = app.getSharedPreferences(Constants.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        return  new SettingsManager(sharedPreferences);
    }
}
