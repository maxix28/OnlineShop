package com.example.usershop.utility

data class order (val product:String,
                  val price:Int,
                  val client:String,
                  val phoneClient:String,
                  val itemId:String,
                  val orderId: String,
                  val email:String? = null,
                  val cardIsReal:Boolean?=null
){
}