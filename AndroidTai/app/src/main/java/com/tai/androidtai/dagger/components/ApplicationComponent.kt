package com.tai.androidtai.dagger.components

import android.content.Context

import com.tai.androidtai.dagger.modules.AndroidModule
import com.tai.androidtai.dagger.modules.ApplicationModule
import com.tai.androidtai.dagger.modules.NetworkModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [AndroidModule::class, ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent : AndroidTaiComponent {

    class Initializer private constructor() {

        init {
            throw UnsupportedOperationException()
        }

        companion object {

            fun init(context: Context): ApplicationComponent {
                return DaggerApplicationComponent.builder()
                        .androidModule(AndroidModule(context))
                        .applicationModule(ApplicationModule())
                        .networkModule(NetworkModule())
                        .build()
            }
        }
    }
}

