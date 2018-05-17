package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import android.app.Application;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MyDiApplication myDiApplication); // Cannot use base type of application, causes injection to fail
}
