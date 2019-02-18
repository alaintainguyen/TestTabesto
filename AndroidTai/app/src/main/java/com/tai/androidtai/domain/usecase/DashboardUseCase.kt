package com.tai.androidtai.domain.usecase

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.bean.DashBoardResponseBean
import com.tai.androidtai.domain.repository.DashboardRepository

import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.Scheduler

@PerActivity
class DashboardUseCase @Inject
internal constructor(postExecutionThread: Scheduler, private val mRepository: DashboardRepository) : UseCase<DashBoardResponseBean, DashboardUseCase.Params>(postExecutionThread) {

    override fun buildObservable(params: DashboardUseCase.Params): Observable<DashBoardResponseBean> {
        return mRepository.info
    }

    class Params
}
