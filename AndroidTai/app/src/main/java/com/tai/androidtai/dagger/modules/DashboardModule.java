package com.tai.androidtai.dagger.modules;

import android.support.v7.app.AppCompatActivity;

import com.tai.androidtai.dagger.scope.PerActivity;
import com.tai.androidtai.domain.usecase.DashboardUseCase;
import com.tai.androidtai.modules.dashboard.DashboardContract;
import com.tai.androidtai.modules.dashboard.DashboardPresenter;
import com.tai.androidtai.modules.dashboard.DashboardRouter;
import com.tai.androidtai.modules.mealDetails.MealDetailsContract;
import com.tai.androidtai.modules.mealDetails.MealDetailsPresenter;
import com.tai.androidtai.modules.mealDetails.MealDetailsRouter;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    @PerActivity
    DashboardContract.Presenter provideDashboardPresenter(DashboardContract.Router router, DashboardUseCase dashboardUseCase) {
        return new DashboardPresenter(router, dashboardUseCase);
    }

    @Provides
    @PerActivity
    DashboardContract.Router provideDashboardRouter(AppCompatActivity activity) {
        return new DashboardRouter(activity);
    }

    @Provides
    @PerActivity
    MealDetailsContract.Presenter provideMealDetailsPresenter(MealDetailsContract.Router router) {
        return new MealDetailsPresenter(router);
    }

    @Provides
    @PerActivity
    MealDetailsContract.Router provideMealDetailsRouter(AppCompatActivity activity) {
        return new MealDetailsRouter(activity);
    }

}
