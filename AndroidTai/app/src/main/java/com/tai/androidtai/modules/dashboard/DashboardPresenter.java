package com.tai.androidtai.modules.dashboard;

import android.util.Log;

import com.tai.androidtai.domain.bean.DashBoardResponseBean;
import com.tai.androidtai.domain.bean.MealBean;
import com.tai.androidtai.domain.usecase.DashboardUseCase;
import com.tai.androidtai.modules.core.BaseContract;
import com.tai.androidtai.modules.core.BasePresenter;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.ResourceObserver;

public class DashboardPresenter extends BasePresenter implements DashboardContract.Presenter {

    private static final String TAG = DashboardPresenter.class.getSimpleName();
    private final DashboardContract.Router mRouter;
    private final DashboardUseCase mDashboardUseCase;
    private DashboardContract.View mView;

    public DashboardPresenter(DashboardContract.Router router, DashboardUseCase dashboardUseCase) {
        mRouter = router;
        mDashboardUseCase = dashboardUseCase;
    }

    @Override
    public void getInfo() {
        mDashboardUseCase.execute(new GetInfoSubscriber(), new DashboardUseCase.Params());
    }

    @Override
    public void subscribe(BaseContract.View view) {
        mView = (DashboardContract.View) view;
    }

    @Override
    public void unsubscribe(BaseContract.View view) {
        if (mView.equals(view)) {
            mView = null;
        }
    }

    public void goToMealDetails(MealBean mealBean) {
        mRouter.goToMealDetails(mealBean);
    }

    protected class GetInfoSubscriber extends ResourceObserver<DashBoardResponseBean> {

        @Override
        public void onNext(@NonNull DashBoardResponseBean dashBoardResponseBean) {
            if (mView != null) {
                mView.displayInformation(dashBoardResponseBean.getList());
            }
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Log.e(TAG, e.getMessage());
        }

        @Override
        public void onComplete() {
            // Nothing to do
        }
    }
}
