package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.application;

import android.app.Application;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationModule;
import com.shadowedmindsdesigns.learn.dagger.example.MyLogger;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.TestMyDiApplication;

import org.mockito.Mock;
import org.mockito.Mockito;

import dagger.Module;

@Module( includes = {ApplicationModule.class})
public class MockApplicationModule extends ApplicationModule {

    public MockApplicationModule(Application mApp) {
        super(mApp);
    }

//    @Override
//    protected Application application() {
//        return new TestMyDiApplication();
//    }

//    @Override
//    protected MyLogger logger() {
//        return ((TestMyDiApplication) application()).getMyLogger();
//    }
}