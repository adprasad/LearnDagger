package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import android.app.Application;

import com.shadowedmindsdesigns.learn.dagger.example.MyLogger;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    protected final Application mApp;

    public ApplicationModule(Application mApp) {
        this.mApp = mApp;
    }

    @Provides
    @ApplicationScope
    protected Application application(){
        return this.mApp;
    }

    @Provides
    @ApplicationScope
    protected MyLogger logger(){
        return new MyLogger();
    }
}
