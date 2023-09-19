package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usershop.databinding.ActivityItemBinding
import com.example.usershop.databinding.ProductItemBinding
import com.example.usershop.utility.Extra_Product
import com.example.usershop.utility.Product
import com.squareup.picasso.Picasso

class Item_activity : AppCompatActivity() {
    lateinit var binding: ActivityItemBinding
    lateinit var  product:Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ItemActivity")
        binding= ActivityItemBinding.inflate(layoutInflater)
        product= intent.getParcelableExtra(Extra_Product)!!
        println("ItemActivity2")


       // Picasso.get().load(product.image).into(imageView)
            binding.  ProdName.text= product.name.toString()
        binding.price.text= product.price.toString()
        binding. description.text= product.description.toString()



        println("ItemActivity3")

    }
}


