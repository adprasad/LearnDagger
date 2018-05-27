package com.shadowedmindsdesigns.learn.dagger.mocks;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.TestMyDiApplication;

public class DaggerMockRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("Creating new application from DaggerMockRunner");
//        TestMyDiApplication application = (TestMyDiApplication) super.newApplication(cl, TestMyDiApplication.class.getName(), context);
//        application.getApplicationComponent().inject(application);
//        System.out.println("Configured application from DaggerMockRunner");
        System.out.println("Context null is :" + (context == null));
        return super.newApplication(cl, TestMyDiApplication.class.getName(), context);
    }
}
