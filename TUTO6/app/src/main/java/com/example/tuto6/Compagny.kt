package com.example.tuto6

import android.os.Parcel
import android.os.Parcelable

@kotlinx.serialization.Serializable
data class Compagny(
    val name: String, // nom
    val domain: String, // site internet
    val logo: String // url du logo
) : Parcelable {

    override fun toString(): String {
        return "$name: $domain"
    }

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(domain)
        parcel.writeString(logo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Compagny> {
        override fun createFromParcel(parcel: Parcel): Compagny {
            return Compagny(parcel)
        }

        override fun newArray(size: Int): Array<Compagny?> {
            return arrayOfNulls(size)
        }
    }
}


fun initJsonTxt() = "  {\n" +
        "    \"name\": \"Kotlin\",\n" +
        "    \"domain\": \"kotlinlang.org\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/kotlinlang.org\"\n" +
        "  }"

fun initJsonArrayTxt() = "[\n" +
        "  {\n" +
        "    \"name\": \"Starbucks\",\n" +
        "    \"domain\": \"starbucks.com\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/starbucks.com\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"name\": \"Stardew Valley Wiki\",\n" +
        "    \"domain\": \"stardewvalleywiki.com\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/stardewvalleywiki.com\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"name\": \"Startpage\",\n" +
        "    \"domain\": \"startpage.com\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/startpage.com\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"name\": \"Starz\",\n" +
        "    \"domain\": \"starz.com\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/starz.com\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"name\": \"Star Tribune\",\n" +
        "    \"domain\": \"startribune.com\",\n" +
        "    \"logo\": \"https://logo.clearbit.com/startribune.com\"\n" +
        "  }\n" +
        "]"
