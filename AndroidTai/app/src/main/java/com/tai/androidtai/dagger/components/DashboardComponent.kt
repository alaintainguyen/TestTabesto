package com.tai.androidtai.dagger.components

import com.tai.androidtai.dagger.modules.ActivityModule
import com.tai.androidtai.dagger.modules.DashboardModule
import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.modules.dashboard.DashboardActivity
import com.tai.androidtai.modules.mealDetails.MealDetailsActivity

import dagger.Component

@PerActivity
@Component(dependencies = [AndroidTaiComponent::class], modules = [ActivityModule::class, DashboardModule::class])
interface DashboardComponent {

    class Initializer private constructor() {

        init {
            throw UnsupportedOperationException()
        }

        companion object {

            fun init(applicationComponent: AndroidTaiComponent,
                     activityModule: ActivityModule): DashboardComponent {
                return DaggerDashboardComponent.builder()
                        .androidTaiComponent(applicationComponent)
                        .activityModule(activityModule)
                        .dashboardModule(DashboardModule())
                        .build()
            }
        }
    }

    fun inject(dashboardActivity: DashboardActivity)

    fun inject(mealDetailsActivity: MealDetailsActivity)
}
