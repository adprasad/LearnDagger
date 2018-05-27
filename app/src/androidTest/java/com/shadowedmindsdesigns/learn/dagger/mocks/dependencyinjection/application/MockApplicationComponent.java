package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.application;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationModule;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationScope;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.SettingsModule;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.TestMyDiApplication;

import dagger.Component;

@Component(modules = {ApplicationModule.class, MockApplicationModule.class})
public interface MockApplicationComponent extends ApplicationComponent{

//    @Override
    void inject(TestMyDiApplication myDiApplication);

    @Override
    ControllerComponent newControllerComponent(ControllerModule controllerModule);
}
