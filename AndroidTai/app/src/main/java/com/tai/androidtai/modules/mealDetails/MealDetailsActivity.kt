package com.tai.androidtai.modules.mealDetails

import android.os.Bundle

import android.widget.TextView

import com.facebook.drawee.view.SimpleDraweeView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.MealBean
import com.tai.androidtai.modules.core.BaseActivity

import javax.inject.Inject

import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import dagger.android.AndroidInjection

class MealDetailsActivity : BaseActivity(), MealDetailsContract.View {

    @Inject
    lateinit var mPresenter: MealDetailsContract.Presenter

    @BindView(R.id.meal_cl)
    lateinit var mMealLayout: ConstraintLayout

    @BindView(R.id.meal_image)
    lateinit var mImage: SimpleDraweeView

    @BindView(R.id.meal_link)
    lateinit var mLink: TextView

    @BindView(R.id.meal_description)
    lateinit var mDescription: TextView

    @BindView(R.id.meal_category)
    lateinit var mCategory: TextView

    @BindView(R.id.meal_area)
    lateinit var mArea: TextView

    @BindView(R.id.meal_price)
    lateinit var mPrice: TextView

    @BindView(R.id.meal_ingredient1)
    lateinit var mIngredient1: TextView

    @BindView(R.id.meal_ingredient2)
    lateinit var mIngredient2: TextView

    @BindView(R.id.meal_ingredient3)
    lateinit var mIngredient3: TextView

    @BindView(R.id.meal_movie)
    lateinit var mVideo: SimpleDraweeView

    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.meal_title)
    lateinit var mTitle: TextView

    private var mMovieLink: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
        ButterKnife.bind(this)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)

        if (supportActionBar != null) {
            setSupportActionBar(mToolbar)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        mToolbar.setNavigationIcon(R.drawable.back_arrow)
        mToolbar.setNavigationOnClickListener { view -> finish() }

        displayAllMealInformation(intent.getParcelableExtra("meal"), intent.getStringExtra("price"))
    }

    private fun displayAllMealInformation(mealBean: MealBean, price: String) {
        mImage.setImageURI(mealBean.mealImage)
        mVideo.setImageURI(mealBean.mealImage)
        mTitle.text = mealBean.mealName
        mLink.text = mealBean.mealLink
        mArea.text = mealBean.mealArea
        mCategory.text = mealBean.mealCategory
        mDescription.text = mealBean.mealDescription
        mPrice.text = price
        mIngredient1.text = mealBean.mealIngredient1
        mIngredient2.text = mealBean.mealIngredient2
        mIngredient3.text = mealBean.mealIngredient3
        mMovieLink = mealBean.mealYoutube
    }

}

