package com.tai.androidtai.domain.repository

import com.tai.androidtai.domain.bean.DashBoardResponseBean

import javax.inject.Inject

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET

class DashboardRepository @Inject
constructor(retrofit: Retrofit) {

    private val mService: LoginService

    val info: Observable<DashBoardResponseBean> get() = mService.info

    init {
        mService = retrofit.create(LoginService::class.java)
    }

    private interface LoginService {
        @get:GET("api/character/?page=1")
        val info: Observable<DashBoardResponseBean>
    }
}
