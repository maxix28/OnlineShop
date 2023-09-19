package com.example.usershop.utility

import android.os.Parcel
import android.os.Parcelable

data class Product(val category:String? = null,
                   val name:String? = null,
                   val image :String? = null,
                   var price :Int?= null,
                   val ID:String? = null,
                   var amount:Int?=null,
                   var description:String? = null  ):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(category)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeValue(price)
        parcel.writeString(ID)
        parcel.writeValue(amount)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}
