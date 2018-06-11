package com.tai.androidtai.domain.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MealBean implements Parcelable {

    @SerializedName("strMeal")
    private String mMealName;

    @SerializedName("strMealThumb")
    private String mMealImage;

    @SerializedName("strCategory")
    private String mMealCategory;

    private MealBean(Parcel in) {
        mMealName = in.readString();
        mMealImage = in.readString();
        mMealCategory = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMealName);
        dest.writeString(mMealImage);
        dest.writeString(mMealCategory);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MealBean> CREATOR = new Creator<MealBean>() {
        @Override
        public MealBean createFromParcel(Parcel in) {
            return new MealBean(in);
        }

        @Override
        public MealBean[] newArray(int size) {
            return new MealBean[size];
        }
    };
    
    public String getMealName() {
        if (mMealName == null) {
            mMealName = "";
        }
        return mMealName;
    }

    public String getMealImage() {
        if (mMealImage == null) {
            mMealImage = "";
        }
        return mMealImage;
    }

    public String getMealCategory() {
        if (mMealCategory == null ) {
            mMealCategory = "";
        }
        return mMealCategory;
    }
}
