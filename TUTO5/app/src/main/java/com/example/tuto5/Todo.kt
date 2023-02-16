package com.example.tuto5

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    var title: String,
    var completed: Boolean = false
) : Comparable<Todo>, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun toString(): String {
        return "${if (title.length >= 25) title.substring(0..24) + "..." else title}" + "${if (completed) "    [ok]" else ""}"
    }

    override fun compareTo(other: Todo): Int {
        return title.compareTo(other.title)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeByte(if (completed) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }

}


