package com.tai.androidtai;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tai.androidtai.dagger.components.AndroidTaiComponent;
import com.tai.androidtai.dagger.components.ApplicationComponent;

public class AndroidTaiApplication extends Application {

    AndroidTaiComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mApplicationComponent = initializeApplicationComponent();
        mApplicationComponent.inject(this);
        Fresco.initialize(this);
    }

    AndroidTaiComponent initializeApplicationComponent() {
        return ApplicationComponent.Initializer.Companion.init(getApplicationContext());
    }

    public AndroidTaiComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}