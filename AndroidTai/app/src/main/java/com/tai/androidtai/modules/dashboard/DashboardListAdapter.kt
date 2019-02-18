package com.tai.androidtai.modules.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.facebook.drawee.view.SimpleDraweeView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.MealBean

import java.util.ArrayList
import java.util.Random
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

class DashboardListAdapter internal constructor(private val mPresenter: DashboardContract.Presenter) : RecyclerView.Adapter<DashboardListAdapter.DashboardViewHolder>() {

    private val mItems: ArrayList<Any>

    init {
        mItems = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display_all_users_info, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val r = Random()
        val price = r.nextInt(10 - 2) + 2
        val rprice = price.toString() + "€"
        val mealBean = mItems[position] as MealBean
        holder.mMealName!!.text = mealBean.mealName
        holder.mMealImage!!.setImageURI(mealBean.mealImage)
        holder.mMealCategory!!.text = mealBean.mealCategory
        holder.mMealPrice!!.text = rprice
        holder.mLayout!!.setOnClickListener { v -> mPresenter.goToMealDetails(mealBean, rprice) }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    internal fun addInformations(mealInfo: List<MealBean>) {
        mItems.addAll(mealInfo)
        notifyDataSetChanged()
    }

    internal inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.layout)
        var mLayout: ConstraintLayout? = null

        @BindView(R.id.dashboard_meal_name)
        var mMealName: TextView? = null

        @BindView(R.id.dashboard_meal_price)
        var mMealPrice: TextView? = null

        @BindView(R.id.dashboard_meal_category)
        var mMealCategory: TextView? = null

        @BindView(R.id.dashboard_meal_image)
        var mMealImage: SimpleDraweeView? = null

        init {

            ButterKnife.bind(this, itemView)
        }
    }
}
