package com.shadowedmindsdesigns.learn.dagger.example.common.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;

public abstract class BaseActivity extends AppCompatActivity {

    /*
         Note used to declare global services so no need for a local variable to hold this
         */
    @UiThread
    protected ControllerComponent getControllerComponent(){

        return ((MyDiApplication) getApplication())
                .getApplicationComponent()
                .newControllerComponent(
                        new ControllerModule(this)
                );
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getControllerComponent().inject(this);
        super.onCreate(savedInstanceState);
    }
}
