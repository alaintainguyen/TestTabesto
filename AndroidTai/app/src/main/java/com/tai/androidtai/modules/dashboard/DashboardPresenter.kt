package com.tai.androidtai.modules.dashboard

import android.util.Log

import com.tai.androidtai.domain.bean.DashBoardResponseBean
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.domain.usecase.DashboardUseCase
import com.tai.androidtai.modules.core.BaseContract
import com.tai.androidtai.modules.core.BasePresenter

import io.reactivex.annotations.NonNull
import io.reactivex.observers.ResourceObserver

class DashboardPresenter(private val mRouter: DashboardContract.Router, private val mDashboardUseCase: DashboardUseCase) : BasePresenter(), DashboardContract.Presenter {

    private var mView: DashboardContract.View? = null

    companion object {
        private val TAG = DashboardPresenter::class.java.simpleName
    }

    override fun getInfo() {
        mDashboardUseCase.execute(GetInfoSubscriber(), null)
    }

    override fun subscribe(view: BaseContract.View) {
        mView = view as DashboardContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun goToMealDetails(resultBean: ResultBean, price: String) {
        mRouter.goToMealDetails(resultBean, price, mView)
    }

    private inner class GetInfoSubscriber : ResourceObserver<DashBoardResponseBean>() {

        override fun onNext(@NonNull dashBoardResponseBean: DashBoardResponseBean) {
            mView?.displayInformation(dashBoardResponseBean.mResultBean)
            mView?.hideProgressBar()
        }

        override fun onError(@NonNull e: Throwable) {
            Log.e(TAG, e.message)
        }

        override fun onComplete() {
            // Nothing to do
        }
    }


}
