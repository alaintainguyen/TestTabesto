package com.tai.androidtai.dagger.modules;

import android.support.v7.app.AppCompatActivity;

import com.tai.androidtai.dagger.scope.PerActivity;
import com.tai.androidtai.domain.usecase.DashboardUseCase;
import com.tai.androidtai.modules.dashboard.DashboardContract;
import com.tai.androidtai.modules.dashboard.DashboardPresenter;
import com.tai.androidtai.modules.dashboard.DashboardRouter;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    @PerActivity
    DashboardContract.Presenter provideLogiPresenter(DashboardContract.Router router, DashboardUseCase dashboardUseCase) {
        return new DashboardPresenter(router, dashboardUseCase);
    }

    @Provides
    @PerActivity
    DashboardContract.Router provideLoginRouter(AppCompatActivity activity) {
        return new DashboardRouter(activity);
    }

}
