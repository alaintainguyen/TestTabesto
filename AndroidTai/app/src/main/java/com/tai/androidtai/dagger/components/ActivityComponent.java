package com.tai.androidtai.dagger.components;

import android.support.v7.app.AppCompatActivity;

import com.tai.androidtai.dagger.modules.ActivityModule;
import com.tai.androidtai.dagger.scope.PerActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation @PerActivity
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Expose those object to sub-graphs
    AppCompatActivity activity();
}