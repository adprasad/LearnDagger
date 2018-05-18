package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import android.app.Application;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, SettingsModule.class})
public interface ApplicationComponent {
    public void inject(MyDiApplication myDiApplication); // Cannot use base type of application, causes injection to fail

    public ControllerComponent newControllerComponent(ControllerModule controllerModule); // Wires sub-component see Controller readme
}
