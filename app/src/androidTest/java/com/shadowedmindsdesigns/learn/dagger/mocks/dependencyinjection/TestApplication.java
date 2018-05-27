package com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection;

import android.support.test.InstrumentationRegistry;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;


public class TestApplication extends ApplicationTestCase<TestMyDiApplication> {
    public TestApplication(Class<TestMyDiApplication> applicationClass) {
        super(applicationClass);
    }

}
