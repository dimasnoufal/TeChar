package com.unity.techar.adapter

import android.os.Parcel
import android.os.Parcelable

data class KonsultasiClass (
    var gambarK: Int,
    var namaK: String,
    var bidangK: String,
    var detailgambarK: Int,
    var deskripsiK: String,
    var linkK: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gambarK)
        parcel.writeString(namaK)
        parcel.writeString(bidangK)
        parcel.writeInt(detailgambarK)
        parcel.writeString(deskripsiK)
        parcel.writeString(linkK)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KonsultasiClass> {
        override fun createFromParcel(parcel: Parcel): KonsultasiClass {
            return KonsultasiClass(parcel)
        }

        override fun newArray(size: Int): Array<KonsultasiClass?> {
            return arrayOfNulls(size)
        }
    }
}