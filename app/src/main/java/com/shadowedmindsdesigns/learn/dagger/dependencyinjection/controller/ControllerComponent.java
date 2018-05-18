package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller;

import com.shadowedmindsdesigns.learn.dagger.ExampleActivity;
import com.shadowedmindsdesigns.learn.dagger.example.common.controller.BaseActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {ControllerModule.class}
)
public interface ControllerComponent {
    public void inject(BaseActivity activity);
}
