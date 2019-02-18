package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.MealBean
import com.tai.androidtai.modules.core.BaseContract

interface DashboardContract {

    interface View : BaseContract.View {

        fun displayInformation(userList: List<MealBean>)

        fun hideProgressBar()
    }

    interface Presenter : BaseContract.Presenter {

        fun getInfo()

        fun goToMealDetails(mealBean: MealBean, price: String)
    }

    interface Router : BaseContract.Router {
        fun goToMealDetails(mealBean: MealBean, price: String)
    }

}
