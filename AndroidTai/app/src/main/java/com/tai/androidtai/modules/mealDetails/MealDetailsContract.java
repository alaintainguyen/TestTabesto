package com.tai.androidtai.modules.mealDetails;

import com.tai.androidtai.modules.core.BaseContract;

public interface MealDetailsContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter {

        void openMovie(String movieLink);
    }

    interface Router extends BaseContract.Router {

        void openMovie(String movieLink);
    }
}
