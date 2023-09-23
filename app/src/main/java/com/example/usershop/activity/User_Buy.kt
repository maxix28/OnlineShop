package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usershop.databinding.ActivityUserBuyBinding
import com.example.usershop.utility.Extra_Product
import com.example.usershop.utility.Product
import com.squareup.picasso.Picasso

class User_Buy : AppCompatActivity() {
    lateinit var binding: ActivityUserBuyBinding
    lateinit var  product : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        product = intent.getParcelableExtra(Extra_Product)!!
        binding.apply {
            productName.text = product.name
            priceFinal.text = "$" + product.price.toString()
            Picasso.get().load(product.image).into(productIMG)
        }
    }
}