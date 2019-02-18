package com.tai.androidtai.domain.bean

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class DashBoardResponseBean : Parcelable {

    @SerializedName("meals")
    lateinit var list: List<MealBean>

    private constructor(parcel: Parcel) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {}

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<DashBoardResponseBean> = object : Parcelable.Creator<DashBoardResponseBean> {
            override fun createFromParcel(parcel: Parcel): DashBoardResponseBean {
                return DashBoardResponseBean(parcel)
            }

            override fun newArray(size: Int): Array<DashBoardResponseBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}

