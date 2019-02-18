package com.tai.androidtai

import android.app.Activity
import android.app.Application

import com.facebook.drawee.backends.pipeline.Fresco
import com.tai.androidtai.dagger.components.AndroidTaiComponent
import com.tai.androidtai.dagger.components.ApplicationComponent

import javax.inject.Inject

import androidx.annotation.VisibleForTesting
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication

class AndroidTaiApplication : DaggerApplication() {

    @Inject
    @VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
    lateinit var mActivityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var applicationComponent: AndroidTaiComponent

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        applicationComponent = initializeApplicationComponent()
        applicationComponent.inject(this)
        Fresco.initialize(this)
    }

    private fun initializeApplicationComponent(): AndroidTaiComponent {
        return ApplicationComponent.Initializer.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = ApplicationComponent.Initializer.init(this)
        applicationComponent.inject(this)
        return applicationComponent
    }

}