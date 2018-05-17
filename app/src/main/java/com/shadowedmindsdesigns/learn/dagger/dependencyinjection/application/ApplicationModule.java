package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import android.app.Application;

import com.shadowedmindsdesigns.learn.dagger.example.MyLogger;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApp;

    public ApplicationModule(Application mApp) {
        this.mApp = mApp;
    }

    @Provides
    @ApplicationScope
    Application application(){
        return this.mApp;
    }

    @Provides
    @ApplicationScope
    MyLogger logger(){
        return new MyLogger();
    }
}
