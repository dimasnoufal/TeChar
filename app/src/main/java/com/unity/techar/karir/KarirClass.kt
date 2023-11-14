package com.unity.techar.karir

import android.os.Parcel
import android.os.Parcelable

data class KarirClass (
    var gambar: Int,
    var nama: String,
    var keahlian: String,
    var detail_gambar: Int,
    var gaji: String,
    var deskripsi: String,
    var detail_keahlian: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gambar)
        parcel.writeString(nama)
        parcel.writeString(keahlian)
        parcel.writeInt(detail_gambar)
        parcel.writeString(gaji)
        parcel.writeString(deskripsi)
        parcel.writeString(detail_keahlian)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KarirClass> {
        override fun createFromParcel(parcel: Parcel): KarirClass {
            return KarirClass(parcel)
        }

        override fun newArray(size: Int): Array<KarirClass?> {
            return arrayOfNulls(size)
        }
    }
}
