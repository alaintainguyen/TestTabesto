package com.tai.androidtai.domain.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashBoardResponseBean implements Parcelable {

    @SerializedName("meals")
    private List<MealBean> mList;

    private DashBoardResponseBean(Parcel in) {
    }

    public DashBoardResponseBean() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DashBoardResponseBean> CREATOR = new Creator<DashBoardResponseBean>() {
        @Override
        public DashBoardResponseBean createFromParcel(Parcel in) {
            return new DashBoardResponseBean(in);
        }

        @Override
        public DashBoardResponseBean[] newArray(int size) {
            return new DashBoardResponseBean[size];
        }
    };

    public List<MealBean> getList() {
        return mList;
    }
}

