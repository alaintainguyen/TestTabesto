package com.tai.androidtai.dagger.components;

import com.tai.androidtai.dagger.modules.ActivityModule;
import com.tai.androidtai.dagger.modules.DashboardModule;
import com.tai.androidtai.dagger.scope.PerActivity;
import com.tai.androidtai.modules.dashboard.DashboardActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AndroidTaiComponent.class, modules = {ActivityModule.class, DashboardModule.class})
public interface DashboardComponent {

    final class Initializer {

        private Initializer() {
            throw new UnsupportedOperationException();
        }

        public static DashboardComponent init(AndroidTaiComponent applicationComponent,
                                              ActivityModule activityModule) {
            return DaggerDashboardComponent.builder()
                    .androidTaiComponent(applicationComponent)
                    .activityModule(activityModule)
                    .dashboardModule(new DashboardModule())
                    .build();
        }
    }

    void inject(DashboardActivity activity);

}
