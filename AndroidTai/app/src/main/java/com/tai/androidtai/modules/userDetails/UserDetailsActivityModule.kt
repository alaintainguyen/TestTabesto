package com.tai.androidtai.modules.userDetails

import com.tai.androidtai.dagger.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class UserDetailsActivityModule {

    @Provides
    @PerActivity
    internal fun provideMealDetailsPresenter(router: UserDetailsContract.Router): UserDetailsContract.Presenter {
        return UserDetailsPresenter(router)
    }

    @Provides
    @PerActivity
    internal fun provideMealDetailsRouter(): UserDetailsContract.Router {
        return UserDetailsRouter()
    }

}