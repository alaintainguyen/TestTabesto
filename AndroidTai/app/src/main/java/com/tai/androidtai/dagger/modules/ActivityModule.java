package com.tai.androidtai.dagger.modules;

import android.support.v7.app.AppCompatActivity;

import com.tai.androidtai.dagger.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */

    @Provides
    @PerActivity
    AppCompatActivity activity() {
        return mActivity;
    }
}
