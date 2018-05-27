package com.shadowedmindsdesigns.learn.dagger;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.MyDiApplication;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerComponent;
import com.shadowedmindsdesigns.learn.dagger.dependencyinjection.controller.ControllerModule;
import com.shadowedmindsdesigns.learn.dagger.example.MyLogger;
import com.shadowedmindsdesigns.learn.dagger.example.common.controller.BaseActivity;

import android.support.v4.app.FragmentManager;

import junit.framework.Assert;

import javax.inject.Inject;

public class ExampleActivity extends BaseActivity {

    // @Inject added for properties provided by injection
    // Tried to inject the fragment manager but the code complained
    @Inject public Activity activity;
    @Inject public FragmentManager fm;

/*    @UiThread
    @Override
    protected ControllerComponent getControllerComponent(){
        ControllerComponent controllerComponent = ((MyDiApplication) getApplication())
                .getApplicationComponent()
                .newControllerComponent(
                        new ControllerModule(this)
                );
        activity = controllerComponent.getActivity();
        return controllerComponent;
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getControllerComponent().inject(this);
        super.onCreate(savedInstanceState);
        // Still need to do injection first
        setContentView(R.layout.activity_example);
        Button btn = findViewById(R.id.app_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyDiApplication)getApplication()).getMyLogger().d("Button pressed");
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(R.string.dialog_fire_missiles)
                        .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                Dialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

}
