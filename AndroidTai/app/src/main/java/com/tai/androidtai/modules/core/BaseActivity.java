package com.tai.androidtai.modules.core;

import android.os.Bundle;

import com.tai.androidtai.AndroidTaiApplication;
import com.tai.androidtai.dagger.components.AndroidTaiComponent;
import com.tai.androidtai.dagger.modules.ActivityModule;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected AndroidTaiComponent getApplicationComponent() {
        return ((AndroidTaiApplication) getApplication()).getApplicationComponent();
    }

}
