package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationModule;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {
    private FragmentActivity mFragmentActivity;

    public ControllerModule(@NonNull FragmentActivity activity) {
        mFragmentActivity = activity;
    }


    @Provides
    protected Context getContext() {
        return mFragmentActivity;
    }

    @Provides
    protected Activity getActivity() {
        return mFragmentActivity;
    }

    @Provides
    protected FragmentManager getFragmentManager() {
        return this.mFragmentActivity.getSupportFragmentManager();
    }

    /*
    @Provides
    DialogsFactory dialogsFactory() {
        return new DialogsFactory();
    }
    */


}
