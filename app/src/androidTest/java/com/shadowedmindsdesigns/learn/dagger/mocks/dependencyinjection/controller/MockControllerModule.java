package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ControllerModule.class})
public class MockControllerModule extends ControllerModule {
    public MockControllerModule(FragmentActivity activity) {
        super(activity);
        System.out.println("On create is activity null: " + (activity == null));
        System.out.println("Mock Controller exists: " + getActivity());
    }

    @Provides
    @Override
    protected Context getContext() {
        System.out.println("Mock Controller context");
        return super.getContext();
    }

    @Provides
    @Override
    protected Activity getActivity() {
        System.out.println("Mock Controller activity");
        return super.getActivity();
    }

    @Provides
    @Override
    protected FragmentManager getFragmentManager() {
        System.out.println("Mock Controller fm");
        return super.getFragmentManager();
    }
}
