package com.unity.techar.adapter

import android.os.Parcel
import android.os.Parcelable

data class BeritaClassFragment (
    var imageB: Int,
    var judulB: String,
    var tanggalB: String,
    var detail_imageB: Int,
    var authorB: String,
    var deskripsiB: String,
    var sumberB: String
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
        parcel.writeInt(imageB)
        parcel.writeString(judulB)
        parcel.writeString(tanggalB)
        parcel.writeInt(detail_imageB)
        parcel.writeString(authorB)
        parcel.writeString(deskripsiB)
        parcel.writeString(sumberB)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BeritaClassFragment> {
        override fun createFromParcel(parcel: Parcel): BeritaClassFragment {
            return BeritaClassFragment(parcel)
        }

        override fun newArray(size: Int): Array<BeritaClassFragment?> {
            return arrayOfNulls(size)
        }
    }
}