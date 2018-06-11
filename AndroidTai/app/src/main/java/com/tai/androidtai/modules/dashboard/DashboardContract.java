package com.tai.androidtai.modules.dashboard;


import com.tai.androidtai.domain.bean.MealBean;
import com.tai.androidtai.modules.core.BaseContract;

import java.util.List;

public interface DashboardContract {

    interface View extends BaseContract.View {

        void displayInformation(List<MealBean> userList);
    }

    interface Presenter extends BaseContract.Presenter {

        void getInfo();

        void goToMealDetails(MealBean mealBean);
    }

    interface Router extends BaseContract.Router {
        void goToMealDetails(MealBean mealBean);
    }

}
