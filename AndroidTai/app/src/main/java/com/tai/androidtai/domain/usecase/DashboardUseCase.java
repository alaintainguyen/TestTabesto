package com.tai.androidtai.domain.usecase;

import com.tai.androidtai.dagger.scope.PerActivity;
import com.tai.androidtai.domain.bean.DashBoardResponseBean;
import com.tai.androidtai.domain.repository.DashboardRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

@PerActivity
public class DashboardUseCase extends UseCase<DashBoardResponseBean, DashboardUseCase.Params> {

    private DashboardRepository mRepository;

    @Inject
    DashboardUseCase(Scheduler postExecutionThread, DashboardRepository dashboardRepository) {
        super(postExecutionThread);
        this.mRepository = dashboardRepository;
    }

    @Override
    protected Observable<DashBoardResponseBean> buildObservable(DashboardUseCase.Params params) {
        return mRepository.getInfo();
    }

    public static class Params {
    }
}
