package com.tai.androidtai.modules.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.tai.androidtai.domain.bean.MealBean;
import com.tai.androidtai.modules.mealDetails.MealDetailsActivity;

public class DashboardRouter implements DashboardContract.Router {

    private final AppCompatActivity mActivity;

    public DashboardRouter(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void goToMealDetails(MealBean mealBean) {
        Intent intent = new Intent(mActivity, MealDetailsActivity.class);
        mActivity.startActivity(intent);
    }
}
