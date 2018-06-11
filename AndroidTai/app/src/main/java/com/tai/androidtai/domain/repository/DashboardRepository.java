package com.tai.androidtai.domain.repository;

import com.tai.androidtai.domain.bean.DashBoardResponseBean;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class DashboardRepository {

    private final LoginService mService;

    @Inject
    public DashboardRepository(Retrofit retrofit) {
        mService = retrofit.create(LoginService.class);
    }

    public Observable<DashBoardResponseBean> getInfo() {
        return mService.getInfo();
    }

    private interface LoginService {
        @GET("api/json/v1/1/latest.php")
        Observable<DashBoardResponseBean> getInfo();
    }
}
