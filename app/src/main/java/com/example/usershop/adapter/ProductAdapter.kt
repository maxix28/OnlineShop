package com.example.add_poduct.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usershop.activity.Item_activity
import com.example.usershop.activity.item2_activity

import com.example.usershop.databinding.ProductItemBinding
import com.example.usershop.utility.Extra_Product
import com.example.usershop.utility.Product
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ProductAdapter(private val productList:java.util.ArrayList<Product>, var context : Context):RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    class ViewHolder (val binding: ProductItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ProductAdapter.ViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return  productList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem= productList[position]
        holder.binding.apply{
            Picasso.get().load(currentItem.image).into(imgProd)

            ProdNAme.text= currentItem.name.toString()
            ProdPrice.text= "$${currentItem.price}"
rvContainer.setOnClickListener {
    val itemIntent= Intent(context, item2_activity::class.java)
    itemIntent.putExtra(Extra_Product,currentItem)
    println("ITEM")
    context.startActivity(itemIntent)
}
        }

    }
}