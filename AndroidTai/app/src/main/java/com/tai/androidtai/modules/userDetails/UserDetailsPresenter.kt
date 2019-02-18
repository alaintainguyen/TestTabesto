package com.tai.androidtai.modules.userDetails

import com.tai.androidtai.modules.core.BaseContract
import com.tai.androidtai.modules.core.BasePresenter

class UserDetailsPresenter(private val mRouter: UserDetailsContract.Router) : BasePresenter(), UserDetailsContract.Presenter {

    override fun subscribe(view: BaseContract.View) {
        // Nothing to do
    }

    override fun unsubscribe(view: BaseContract.View) {
        // Nothing to do
    }

}
