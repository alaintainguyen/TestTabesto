package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseContract

interface DashboardContract {

    interface View : BaseContract.View {

        fun displayInformation(userList: List<ResultBean>?)

        fun hideProgressBar()
    }

    interface Presenter : BaseContract.Presenter {

        fun getInfo()

        fun goToMealDetails(resultBean: ResultBean, price: String)
    }

    interface Router : BaseContract.Router {
        fun goToMealDetails(resultBean: ResultBean, price: String, view: View?)
    }

}
