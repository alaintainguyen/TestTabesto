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

    @SerializedName("strInstructions")
    private String mMealDescription;

    @SerializedName("strArea")
    private String mMealArea;

    @SerializedName("strIngredient1")
    private String mMealIngredient1;

    @SerializedName("strIngredient2")
    private String mMealIngredient2;

    @SerializedName("strIngredient3")
    private String mMealIngredient3;

    @SerializedName("strYoutube")
    private String mMealYoutube;

    private MealBean(Parcel in) {
        mMealName = in.readString();
        mMealImage = in.readString();
        mMealCategory = in.readString();
        mMealDescription = in.readString();
        mMealArea = in.readString();
        mMealIngredient1 = in.readString();
        mMealIngredient2 = in.readString();
        mMealIngredient3 = in.readString();
        mMealYoutube = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMealName);
        dest.writeString(mMealImage);
        dest.writeString(mMealCategory);
        dest.writeString(mMealDescription);
        dest.writeString(mMealArea);
        dest.writeString(mMealIngredient1);
        dest.writeString(mMealIngredient2);
        dest.writeString(mMealIngredient3);
        dest.writeString(mMealYoutube);
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

    public String getMealDescription() {
        if (mMealDescription == null) {
            mMealDescription = "";
        }
        return mMealDescription;
    }

    public String getMealArea() {
        if (mMealArea == null) {
            mMealArea = "";
        }
        return mMealArea;
    }

    public String getMealIngredient1() {
        if (mMealIngredient1 == null) {
            mMealIngredient1 = "";
        }
        return mMealIngredient1;
    }

    public String getMealIngredient2() {
        if (mMealIngredient2 == null) {
            mMealIngredient2 = "";
        }
        return mMealIngredient2;
    }

    public String getMealIngredient3() {
        if (mMealIngredient3 == null) {
            mMealIngredient3 = "";
        }
        return mMealIngredient3;
    }

    public String getMealYoutube() {
        if (mMealYoutube == null) {
            mMealYoutube = "";
        }
        return mMealYoutube;
    }
}
