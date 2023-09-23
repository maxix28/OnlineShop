package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usershop.databinding.ActivityItem2Binding
import com.example.usershop.utility.Extra_Product
import com.example.usershop.utility.Product
import com.squareup.picasso.Picasso

class item2_activity : AppCompatActivity() {
    lateinit var binding: ActivityItem2Binding
    lateinit var  product_: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityItem2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this,"Work",Toast.LENGTH_SHORT).show()
product_= intent.getParcelableExtra(Extra_Product)!!
        binding.apply {
            Picasso.get().load(product_.image).into(imgProd)
            prodName.text = product_.name
            price1.text= "$"+product_.price.toString()
            Decscriptoin.text= product_.description
        }

    }
}