package com.shadowedmindsdesigns.learn.dagger.example.common.controller;

import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;

public abstract class BaseFragment extends Fragment {
    /*
         Note used to declare global services so no need for a local variable to hold this
         */
    @UiThread
    protected ControllerComponent getControllerComponent(){
        return ((MyDiApplication) getActivity().getApplication())
                .getApplicationComponent()
                .newControllerComponent(
                    new ControllerModule(getActivity())
                );
    }
}
