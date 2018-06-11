package com.tai.androidtai.modules.mealDetails;

import com.tai.androidtai.modules.core.BaseContract;
import com.tai.androidtai.modules.core.BasePresenter;

public class MealDetailsPresenter extends BasePresenter implements MealDetailsContract.Presenter{

    private final MealDetailsContract.Router mRouter;

    public MealDetailsPresenter(MealDetailsContract.Router router) {
        mRouter = router;
    }

    @Override
    public void subscribe(BaseContract.View view) {
        // Nothing to do
    }

    @Override
    public void unsubscribe(BaseContract.View view) {
        // Nothing to do
    }

    @Override
    public void openMovie(String movieLink) {
        mRouter.openMovie(movieLink);
    }
}
