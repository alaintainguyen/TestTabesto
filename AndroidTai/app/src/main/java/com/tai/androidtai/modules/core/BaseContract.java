package com.tai.androidtai.modules.core;

public interface BaseContract {

    interface View {

    }

    interface Presenter {

        void subscribe(BaseContract.View view);

        void unsubscribe(BaseContract.View view);

    }

    interface Router {

    }
}

