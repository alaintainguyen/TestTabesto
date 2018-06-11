package com.tai.androidtai.dagger.components;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.tai.androidtai.dagger.modules.NetworkModule;
import com.tai.androidtai.domain.repository.DashboardRepository;
import com.tai.androidtai.modules.core.BaseActivity;

import io.reactivex.Scheduler;
import retrofit2.Retrofit;

public interface AndroidTaiComponent {

    void inject(BaseActivity activity);

    void inject(Application application);

    void inject(NetworkModule networkModule);

    Context applicationContext();

    Scheduler scheduler();

    Retrofit retrofit();

    Gson gson();

    // put repositories here

    DashboardRepository dashboardRepository();

}
