package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.controller;

import com.shadowedmindsdesigns.learn.dagger.ExampleActivity;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;
import com.shadowedmindsdesigns.learn.dagger.example.common.controller.BaseActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {ControllerModule.class, MockControllerModule.class}
        )
public interface MockControllerComponent extends ControllerComponent {
//public interface MockControllerComponent {
}
