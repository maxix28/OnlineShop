package com.example.usershop.activity

import RvCategoryAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usershop.R
import com.example.usershop.databinding.ActivityMainBinding
import com.example.usershop.utility.Category
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  lateinit var  categoryRef : DatabaseReference
    lateinit var CategoryList:java.util.ArrayList<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        categoryRef = FirebaseDatabase.getInstance().getReference("Category")
        CategoryList= arrayListOf()

        fetch()
        binding.rvCategory.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
        }

    }

    private fun fetch() {

        Toast.makeText(this@MainActivity,"stat fetch ", Toast.LENGTH_SHORT).show()

        categoryRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // Toast.makeText(this@categoty_choose,"stat fetch 2 ", Toast.LENGTH_SHORT).show()

                CategoryList.clear()
                if(snapshot.exists()){
                    for(contactSnap in snapshot.children){
                        val contacts= contactSnap.getValue(Category::class.java)
                        CategoryList.add(contacts!!)
                    }
                    //  Toast.makeText(this@categoty_choose,"$CategoryList ", Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(this@MainActivity,"no category ", Toast.LENGTH_SHORT).show()

                }
                val rvAdapter= RvCategoryAdapter(CategoryList,this@MainActivity)
                binding.rvCategory.adapter=rvAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"$error ", Toast.LENGTH_SHORT).show()

            }

        })

    }

}