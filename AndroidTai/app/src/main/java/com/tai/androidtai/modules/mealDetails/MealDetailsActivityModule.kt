package com.tai.androidtai.modules.mealDetails

import com.tai.androidtai.dagger.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class MealDetailsActivityModule {

    @Provides
    @PerActivity
    internal fun provideMealDetailsPresenter(router: MealDetailsContract.Router): MealDetailsContract.Presenter {
        return MealDetailsPresenter(router)
    }

    @Provides
    @PerActivity
    internal fun provideMealDetailsRouter(): MealDetailsContract.Router {
        return MealDetailsRouter()
    }

}