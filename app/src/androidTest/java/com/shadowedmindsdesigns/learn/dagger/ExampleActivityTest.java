package com.shadowedmindsdesigns.learn.dagger;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application.ApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;
import com.shadowedmindsdesigns.learn.dagger.example.common.controller.BaseActivity;
import com.shadowedmindsdesigns.learn.dagger.mocks.DIActivityRuleTest;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.TestMyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.application.MockApplicationComponent;
import com.shadowedmindsdesigns.learn.dagger.mocks.dependencyinjection.controller.MockControllerModule;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ExampleActivityTest {

    @Rule
    public DIActivityRuleTest<ExampleActivity> exampleActivityRule = new DIActivityRuleTest<>(ExampleActivity.class, true,false);

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        TestMyDiApplication app
                = (TestMyDiApplication) instrumentation.getTargetContext().getApplicationContext();
        ApplicationComponent component = app.getApplicationComponent();
        component.inject(app);
        ExampleActivity exampleActivity = exampleActivityRule.launchActivity(new Intent());
        ControllerComponent controllerComponent = component.newControllerComponent(new MockControllerModule(exampleActivity));
        controllerComponent.inject(exampleActivity);
    }

    @After
    public void tearDown(){
        exampleActivityRule.finishActivity();
    }


    @Test
    public void whenViewOpens_FireMissleBtnDisplayed_true() {
        onView(withId(R.id.app_button))
                .check(matches(isDisplayed()));
    }

    @Test
    public void whenViewOpens_FireMissleBtnClickable_true() {
//        exampleActivityRule.launchActivity(new Intent());
        onView(withId(R.id.app_button))
                .check(matches(isClickable()));
    }

    @Test
    public void whenViewOpens_FireMissleBtnClickDisplaysDialog_true() {
        Assert.assertNotNull(exampleActivityRule.getActivity().getApplication().getApplicationContext());
        Assert.assertNotNull(exampleActivityRule.getActivity().getApplication().getApplicationContext().getTheme());
        // Find button & click
        onView(withId(R.id.app_button))
                .perform(click())
        ;
        // Ensure Dialog opened
        onView(withText(R.string.dialog_fire_missiles)).check(matches(isDisplayed()));
    }

    @Test
    public void whenViewOpens_FireMissleDialogCancelClosesDialog_true() {
        // Find button & click
        onView(withId(R.id.app_button))
                .perform(click())
        ;
        // Ensure Dialog opened
        onView(withText(R.string.dialog_fire_missiles)).check(matches(isDisplayed()));
        // Find cancel and click
        onView(withText(R.string.cancel)).check(matches(isDisplayed())).perform(click());
        // Ensure Dialog closed
        onView(withText(R.string.dialog_fire_missiles)).check(matches(not(isDisplayed())));
    }

    @Test
    public void whenViewOpens_FireMissleDialogFireClosesDialog_true() {
        // Find button & click
        onView(withId(R.id.app_button))
                .check(matches(isClickable()));
        onView(withId(R.id.app_button))
                .perform(click());
        // Ensure Dialog opened
        onView(withText(R.string.dialog_fire_missiles)).check(matches(isDisplayed()));
        // Find cancel and click
        onView(withText(R.string.fire)).check(matches(isDisplayed())).perform(click());
        // Ensure Dialog closed
        onView(withText(R.string.dialog_fire_missiles)).check(matches(not(isDisplayed())));
    }
}