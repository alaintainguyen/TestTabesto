package com.tai.androidtai.modules.mealDetails

import com.tai.androidtai.modules.core.BaseContract
import com.tai.androidtai.modules.core.BasePresenter

class MealDetailsPresenter(private val mRouter: MealDetailsContract.Router) : BasePresenter(), MealDetailsContract.Presenter {

    override fun subscribe(view: BaseContract.View) {
        // Nothing to do
    }

    override fun unsubscribe(view: BaseContract.View) {
        // Nothing to do
    }

}
