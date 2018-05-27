package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import com.shadowedmindsdesigns.learn.dagger.ExampleActivity;
import com.shadowedmindsdesigns.learn.dagger.example.common.controller.BaseActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {ControllerModule.class}
)
public interface ControllerComponent {
    public void inject(BaseActivity activity);
    public void inject(ExampleActivity activity);
/*
    Activity getActivity();
    Context getContext();
    FragmentManager getFragmentManager();
    */
}
