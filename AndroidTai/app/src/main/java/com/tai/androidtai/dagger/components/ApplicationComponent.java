package com.tai.androidtai.dagger.components;

import android.content.Context;

import com.tai.androidtai.dagger.modules.AndroidModule;
import com.tai.androidtai.dagger.modules.ApplicationModule;
import com.tai.androidtai.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class, ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent extends AndroidTaiComponent {

    final class Initializer {

        private Initializer() {
            throw new UnsupportedOperationException();
        }

        public static ApplicationComponent init(Context context) {
            return DaggerApplicationComponent.builder()
                    .androidModule(new AndroidModule(context))
                    .applicationModule(new ApplicationModule())
                    .networkModule(new NetworkModule())
                    .build();
        }
    }
}

