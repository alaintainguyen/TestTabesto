package com.tai.androidtai.domain.bean

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class MealBean private constructor(parcel: Parcel) : Parcelable {

    @SerializedName("strMeal")
    private var mMealName: String? = null

    @SerializedName("strMealThumb")
    private var mMealImage: String? = null

    @SerializedName("strCategory")
    private var mMealCategory: String? = null

    @SerializedName("strInstructions")
    private var mMealDescription: String? = null

    @SerializedName("strArea")
    private var mMealArea: String? = null

    @SerializedName("strIngredient1")
    private var mMealIngredient1: String? = null

    @SerializedName("strIngredient2")
    private var mMealIngredient2: String? = null

    @SerializedName("strIngredient3")
    private var mMealIngredient3: String? = null

    @SerializedName("strYoutube")
    private var mMealYoutube: String? = null

    @SerializedName("strSource")
    private var mMealLink: String? = null

    val mealName: String
        get() {
            if (mMealName == null) {
                mMealName = ""
            }
            return mMealName!!
        }

    val mealImage: String
        get() {
            if (mMealImage == null) {
                mMealImage = ""
            }
            return mMealImage!!
        }

    val mealCategory: String
        get() {
            if (mMealCategory == null) {
                mMealCategory = ""
            }
            return mMealCategory!!
        }

    val mealDescription: String
        get() {
            if (mMealDescription == null) {
                mMealDescription = ""
            }
            return mMealDescription!!
        }

    val mealArea: String
        get() {
            if (mMealArea == null) {
                mMealArea = ""
            }
            return mMealArea!!
        }

    val mealIngredient1: String
        get() {
            if (mMealIngredient1 == null) {
                mMealIngredient1 = ""
            }
            return mMealIngredient1!!
        }

    val mealIngredient2: String
        get() {
            if (mMealIngredient2 == null) {
                mMealIngredient2 = ""
            }
            return mMealIngredient2!!
        }

    val mealIngredient3: String
        get() {
            if (mMealIngredient3 == null) {
                mMealIngredient3 = ""
            }
            return mMealIngredient3!!
        }

    val mealYoutube: String
        get() {
            if (mMealYoutube == null) {
                mMealYoutube = ""
            }
            return mMealYoutube!!
        }

    val mealLink: String
        get() {
            if (mMealLink == null) {
                mMealLink = ""
            }
            return mMealLink!!
        }

    init {
        mMealName = parcel.readString()
        mMealImage = parcel.readString()
        mMealCategory = parcel.readString()
        mMealDescription = parcel.readString()
        mMealArea = parcel.readString()
        mMealIngredient1 = parcel.readString()
        mMealIngredient2 = parcel.readString()
        mMealIngredient3 = parcel.readString()
        mMealYoutube = parcel.readString()
        mMealLink = parcel.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(mMealName)
        dest.writeString(mMealImage)
        dest.writeString(mMealCategory)
        dest.writeString(mMealDescription)
        dest.writeString(mMealArea)
        dest.writeString(mMealIngredient1)
        dest.writeString(mMealIngredient2)
        dest.writeString(mMealIngredient3)
        dest.writeString(mMealYoutube)
        dest.writeString(mMealLink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<MealBean> = object : Parcelable.Creator<MealBean> {
            override fun createFromParcel(parcel: Parcel): MealBean {
                return MealBean(parcel)
            }

            override fun newArray(size: Int): Array<MealBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}
