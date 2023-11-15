package com.unity.techar.learning_hub

import android.os.Parcel
import android.os.Parcelable

class LearningClass (
    var gambar: Int,
    var nama: String?,
    var ahli: String?,
    var detail_gambar: Int,
    var deskripsi: String?,
    var sumber: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gambar)
        parcel.writeString(nama)
        parcel.writeString(ahli)
        parcel.writeInt(detail_gambar)
        parcel.writeString(deskripsi)
        parcel.writeString(sumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LearningClass> {
        override fun createFromParcel(parcel: Parcel): LearningClass {
            return LearningClass(parcel)
        }

        override fun newArray(size: Int): Array<LearningClass?> {
            return arrayOfNulls(size)
        }
    }
}