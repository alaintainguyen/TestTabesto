package com.tai.androidtai.modules.dashboard

import android.content.Intent
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseRouter
import com.tai.androidtai.modules.mealDetails.MealDetailsActivity

class DashboardRouter : BaseRouter(), DashboardContract.Router {

    override fun goToMealDetails(resultBean: ResultBean, price: String, view: DashboardContract.View?) {
        val intent = Intent(getActivity(view!!), MealDetailsActivity::class.java)
        intent.putExtra("meal", resultBean)
        intent.putExtra("price", price)
        getActivity(view)?.startActivity(intent)
    }
}
