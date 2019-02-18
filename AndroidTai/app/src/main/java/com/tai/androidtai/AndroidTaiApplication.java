package com.tai.androidtai;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tai.androidtai.dagger.components.AndroidTaiComponent;
import com.tai.androidtai.dagger.components.ApplicationComponent;

import javax.inject.Inject;

import androidx.annotation.VisibleForTesting;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;

public class AndroidTaiApplication extends DaggerApplication {

    @Inject
    @VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
    public DispatchingAndroidInjector<Activity> mActivityDispatchingAndroidInjector;

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
        return ApplicationComponent.Initializer.Companion.init(this);
    }

    public AndroidTaiComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        mApplicationComponent = ApplicationComponent.Initializer.Companion.init(this);
        mApplicationComponent.inject(this);
        return mApplicationComponent;
    }

}