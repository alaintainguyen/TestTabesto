package com.tai.androidtai.modules.core

abstract class BaseRouter : BaseContract.Router {

    protected fun getActivity(view: BaseContract.View): BaseActivity? {
        return if (view is BaseActivity) {
            view
        } else {
            null
        }
    }
}
