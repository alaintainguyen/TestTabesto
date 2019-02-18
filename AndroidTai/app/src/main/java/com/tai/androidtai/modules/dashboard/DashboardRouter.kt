package com.tai.androidtai.modules.dashboard

import android.content.Intent

import com.tai.androidtai.domain.bean.MealBean
import com.tai.androidtai.modules.mealDetails.MealDetailsActivity

import androidx.appcompat.app.AppCompatActivity

class DashboardRouter(private val mActivity: AppCompatActivity) : DashboardContract.Router {

    override fun goToMealDetails(mealBean: MealBean, price: String) {
        val intent = Intent(mActivity, MealDetailsActivity::class.java)
        intent.putExtra("meal", mealBean)
        intent.putExtra("price", price)
        mActivity.startActivity(intent)
    }
}
