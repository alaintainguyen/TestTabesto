package com.tai.androidtai.modules.dashboard;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.tai.androidtai.R;
import com.tai.androidtai.dagger.components.DashboardComponent;
import com.tai.androidtai.domain.bean.MealBean;
import com.tai.androidtai.modules.core.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends BaseActivity implements DashboardContract.View {

    @Inject
    DashboardContract.Presenter mPresenter;

    @BindView(R.id.dashboard_rv)
    RecyclerView mDashboardRecyclerView;

    @BindView(R.id.progressbar_layout)
    RelativeLayout mProgresBarLayout;

    private DashboardListAdapter mDashboardListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        DashboardComponent.Initializer.init(getApplicationComponent(), getActivityModule()).inject(this);
        mPresenter.subscribe(this);
        mDashboardListAdapter = new DashboardListAdapter(mPresenter);
        mDashboardRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDashboardRecyclerView.setLayoutManager(layoutManager);
        mDashboardRecyclerView.setAdapter(mDashboardListAdapter);
        mPresenter.getInfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe(this);
    }

    @Override
    public void displayInformation(List<MealBean> userInfo) {
        mDashboardListAdapter.addInformations(userInfo);
    }

    @Override
    public void hideProgressBar() {
        mProgresBarLayout.setVisibility(View.GONE);
    }
}
