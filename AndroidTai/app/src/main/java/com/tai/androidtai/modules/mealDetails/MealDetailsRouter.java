package com.tai.androidtai.modules.mealDetails;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

public class MealDetailsRouter implements MealDetailsContract.Router {

    private final AppCompatActivity mActivity;

    public MealDetailsRouter(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void openMovie(String movieLink) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movieLink));
        mActivity.startActivity(intent);
    }
}
