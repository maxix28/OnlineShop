package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.add_poduct.adapters.ProductAdapter
import com.example.usershop.R
import com.example.usershop.databinding.ActivityProductViewBinding
import com.example.usershop.utility.Category
import com.example.usershop.utility.Extra_Category
import com.example.usershop.utility.Product
import com.google.firebase.database.*

class ProductView : AppCompatActivity() {
    lateinit var binding: ActivityProductViewBinding
    lateinit var category_:Category
    private  lateinit var  productRef : DatabaseReference
    lateinit var ProductList:java.util.ArrayList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        category_= intent.getParcelableExtra(Extra_Category)!!//отримуємо обєкт з вибраної категорії
        binding.categoryName.text= category_.name.toString()
        productRef= FirebaseDatabase.getInstance().getReference("${category_.name}")
        ProductList= arrayListOf()
        fetchData()
        binding.rvPdoduct.apply {
            setHasFixedSize(true)
            val layoutmanager= GridLayoutManager(this@ProductView,2)

        }

    }

    private fun fetchData() {

        productRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ProductList.clear()
                if(snapshot.exists()){
                    for(contactSnap in snapshot.children){
                        val product= contactSnap.getValue(Product::class.java)
                        var id: String
                        println(product)
                        ProductList.add(product!!)
                    }
                }


                val rvAdapter= ProductAdapter(ProductList,this@ProductView)
                binding.rvPdoduct.adapter= rvAdapter
                println(ProductList)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ProductView,"$error ", Toast.LENGTH_SHORT).show()

            }

        }

        )    }
}