package com.tai.androidtai.modules.dashboard;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.tai.androidtai.R;
import com.tai.androidtai.domain.bean.MealBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardListAdapter extends RecyclerView.Adapter<DashboardListAdapter.DashboardViewHolder> {

    private ArrayList<Object> mItems;

    private DashboardContract.Presenter mPresenter;

    DashboardListAdapter(DashboardContract.Presenter presenter) {
        mItems = new ArrayList<>();
        mPresenter = presenter;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_display_all_users_info, parent, false);
        return new DashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        Random r = new Random();
        int price = r.nextInt(10 - 2) + 2;
        MealBean mealBean = (MealBean) mItems.get(position);
        holder.mMealName.setText(mealBean.getMealName());
        holder.mMealImage.setImageURI(mealBean.getMealImage());
        holder.mMealCategory.setText(mealBean.getMealCategory());
        holder.mMealPrice.setText(String.valueOf(price).concat("€"));
        holder.mLayout.setOnClickListener(v -> mPresenter.goToMealDetails(mealBean));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    void addInformations(List<MealBean> mealInfo) {
        mItems.addAll(mealInfo);
        notifyDataSetChanged();
    }

    class DashboardViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout)
        ConstraintLayout mLayout;

        @BindView(R.id.dashboard_meal_name)
        TextView mMealName;

        @BindView(R.id.dashboard_meal_price)
        TextView mMealPrice;

        @BindView(R.id.dashboard_meal_category)
        TextView mMealCategory;

        @BindView(R.id.dashboard_meal_image)
        SimpleDraweeView mMealImage;

        DashboardViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
