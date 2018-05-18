package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {
    private final FragmentActivity mFragmentActivity;


    public ControllerModule(FragmentActivity activity) {
        this.mFragmentActivity = activity;
    }

    @Provides
    Context context() {
        return mFragmentActivity;
    }

    @Provides
    Activity activity() {
        return mFragmentActivity;
    }

    @Provides
    FragmentManager fragmentManager() {
        return this.mFragmentActivity.getSupportFragmentManager();
    }

    /*
    @Provides
    DialogsFactory dialogsFactory() {
        return new DialogsFactory();
    }
    */


}
