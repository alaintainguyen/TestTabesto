package com.tai.androidtai.modules.core;

public abstract class BaseRouter implements BaseContract.Router {

    protected BaseActivity getActivity(BaseContract.View view) {
        if (view instanceof BaseActivity) {
            return (BaseActivity) view;
        } else {
            return null;
        }
    }
}
