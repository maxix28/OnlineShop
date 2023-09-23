package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        Toast.makeText(this,"ItemActivity",Toast.LENGTH_SHORT).show()
        println("ItemActivity")
        binding= ActivityItemBinding.inflate(layoutInflater)
        product= intent.getParcelableExtra(Extra_Product)!!
        println("ItemActivity2")

        Toast.makeText(this,"ItemActivity2",Toast.LENGTH_SHORT).show()

       // Picasso.get().load(product.image).into(imageView)

        binding.ProdName.text= product.name.toString()
        binding.price.text= product.price.toString()
        binding. description.text= product.description.toString()


        Toast.makeText(this,"ItemActivity3",Toast.LENGTH_SHORT).show()


        println("ItemActivity3")

    }
}


