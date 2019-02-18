package com.tai.androidtai.modules.dashboard

import android.content.Intent
import com.tai.androidtai.domain.bean.MealBean
import com.tai.androidtai.modules.core.BaseRouter
import com.tai.androidtai.modules.mealDetails.MealDetailsActivity

class DashboardRouter : BaseRouter(), DashboardContract.Router {

    override fun goToMealDetails(mealBean: MealBean, price: String, view: DashboardContract.View?) {
        val intent = Intent(getActivity(view), MealDetailsActivity::class.java)
        intent.putExtra("meal", mealBean)
        intent.putExtra("price", price)
        getActivity(view)?.startActivity(intent)
    }
}
