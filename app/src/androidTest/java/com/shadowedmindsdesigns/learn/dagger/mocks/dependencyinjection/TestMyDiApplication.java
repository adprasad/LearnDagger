package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.DaggerApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.application.MockApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.application.MockApplicationModule;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.controller.MockControllerModule;

import org.mockito.Mock;
import org.mockito.Mockito;

public class TestMyDiApplication extends MyDiApplication {
    @Override
    public ApplicationComponent getApplicationComponent() {
//        return Mockito.mock(MockApplicationComponent.class);
        if( mApplicationComponent == null ){
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new MockApplicationModule(this)) // API is depreciated
                    .build();
        }
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        // Do dependency injection first
        getApplicationComponent().inject(this);
        super.onCreate(); // doing on
        // Now  the Logger object should be injected and usable
        getMyLogger().d("Test String...");
    }

}
