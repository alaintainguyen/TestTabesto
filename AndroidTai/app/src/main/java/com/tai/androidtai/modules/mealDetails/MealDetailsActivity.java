package com.tai.androidtai.modules.mealDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.tai.androidtai.R;
import com.tai.androidtai.domain.bean.MealBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MealDetailsActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        ButterKnife.bind(this);

        displayAllMealInformation(getIntent().getParcelableExtra("meal"), getIntent().getStringExtra("price"));
    }

    private void displayAllMealInformation(MealBean mealBean, String price) {
        mImage.setImageURI(mealBean.getMealImage());
        mName.setText(mealBean.getMealName());
        mArea.setText(mealBean.getMealArea());
        mCategory.setText(mealBean.getMealCategory());
        mDescription.setText(mealBean.getMealDescription());
        mPrice.setText(price);
        mIngredient1.setText(mealBean.getMealIngredient1());
        mIngredient2.setText(mealBean.getMealIngredient2());
        mIngredient3.setText(mealBean.getMealIngredient3());
    }

    @OnClick(R.id.meal_order)
    public void order() {
        Toast.makeText(this, "Votre commande a été prise en compte", Toast.LENGTH_SHORT).show();
    }
}
