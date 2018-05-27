package com.shadowedmindsdesigns.learn.dagger.dependencyinjection;

import android.app.Application;
import android.support.annotation.UiThread;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationModule;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.DaggerApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.example.MyLogger;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Keeping under di package because I wouldn't have overridden this class except to support DI
 */
public class MyDiApplication extends Application  {
    @Inject
    protected ApplicationComponent mApplicationComponent;


    public MyLogger getMyLogger() {
        return mLogger;
    }

    @Inject
    protected MyLogger mLogger;

    // Annotated with UI because normally you do not do DI on bg thread
    @UiThread
    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this)) // API is depreciated
                    .build();
        }
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        // Do dependency injection first
        getApplicationComponent().inject(this);
        super.onCreate();
        // Now  the Logger object should be injected and usable
        mLogger.d("String...");
    }
}
