package com.tai.androidtai.modules.dashboard

import android.os.Bundle

import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.MealBean
import com.tai.androidtai.modules.core.BaseActivity

import javax.inject.Inject

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection

class DashboardActivity : BaseActivity(), DashboardContract.View {

    @Inject
    lateinit var mPresenter: DashboardContract.Presenter

    @BindView(R.id.dashboard_rv)
    lateinit var mDashboardRecyclerView: RecyclerView

    private lateinit var mDashboardListAdapter: DashboardListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        ButterKnife.bind(this)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)
        mDashboardListAdapter = DashboardListAdapter(mPresenter)
        mDashboardRecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mDashboardRecyclerView.layoutManager = layoutManager
        mDashboardRecyclerView.adapter = mDashboardListAdapter
        mPresenter.getInfo()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

    override fun displayInformation(userList: List<MealBean>) {
        mDashboardListAdapter.addInformations(userList)
    }

    override fun hideProgressBar() {
        // Nothing to do
    }
}
