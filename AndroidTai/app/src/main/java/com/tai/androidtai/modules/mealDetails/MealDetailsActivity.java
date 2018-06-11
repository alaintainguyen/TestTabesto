package com.tai.androidtai.modules.mealDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.tai.androidtai.R;
import com.tai.androidtai.domain.bean.MealBean;
import com.tai.androidtai.modules.TabestoSnackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MealDetailsActivity extends AppCompatActivity {

    @BindView(R.id.meal_cl)
    ConstraintLayout mMealLayout;

    @BindView(R.id.meal_image)
    SimpleDraweeView mImage;

    @BindView(R.id.meal_name)
    TextView mName;

    @BindView(R.id.meal_description)
    TextView mDescription;

    @BindView(R.id.meal_category)
    TextView mCategory;

    @BindView(R.id.meal_area)
    TextView mArea;

    @BindView(R.id.meal_price)
    TextView mPrice;

    @BindView(R.id.meal_ingredient1)
    TextView mIngredient1;

    @BindView(R.id.meal_ingredient2)
    TextView mIngredient2;

    @BindView(R.id.meal_ingredient3)
    TextView mIngredient3;

    @BindView(R.id.meal_movie)
    SimpleDraweeView mVideo;

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar mToolbar;

    @BindView(R.id.meal_title)
    TextView mTitle;

    private String mMovieLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mToolbar.setNavigationIcon(R.drawable.back_arrow);
        mToolbar.setNavigationOnClickListener(view -> finish());

        displayAllMealInformation(getIntent().getParcelableExtra("meal"), getIntent().getStringExtra("price"));
    }

    private void displayAllMealInformation(MealBean mealBean, String price) {
        mImage.setImageURI(mealBean.getMealImage());
        mVideo.setImageURI(mealBean.getMealImage());
        mTitle.setText(mealBean.getMealName());
        mName.setText(mealBean.getMealName());
        mArea.setText(mealBean.getMealArea());
        mCategory.setText(mealBean.getMealCategory());
        mDescription.setText(mealBean.getMealDescription());
        mPrice.setText(price);
        mIngredient1.setText(mealBean.getMealIngredient1());
        mIngredient2.setText(mealBean.getMealIngredient2());
        mIngredient3.setText(mealBean.getMealIngredient3());
        mMovieLink = mealBean.getMealYoutube();
    }

    @OnClick(R.id.meal_order)
    public void order() {
        TabestoSnackbar.make(mMealLayout, "Votre commande a été prise en compte", Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.meal_movie)
    public void movie() {
        startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse(mMovieLink)));
    }
}

