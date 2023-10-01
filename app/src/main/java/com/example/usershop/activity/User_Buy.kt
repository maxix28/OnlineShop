package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usershop.databinding.ActivityUserBuyBinding
import com.example.usershop.utility.Client
import com.example.usershop.utility.Extra_Product
import com.example.usershop.utility.Product
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class User_Buy : AppCompatActivity() {
    lateinit var binding: ActivityUserBuyBinding
    lateinit var  product : Product
    lateinit var firebaceRef: DatabaseReference
    lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        product = intent.getParcelableExtra(Extra_Product)!!
println(product)

        binding.apply {
            productName.text = product.name
            priceFinal.text = "$" + product.price.toString()
            Picasso.get().load(product.image).into(productIMG)
        }

        firebaceRef = FirebaseDatabase.getInstance().getReference("clients")

        binding.apply {
            buyNowBTN.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // if(clientName.isEm)
                val name = clientName.text.toString()
                if (name.isEmpty()) {
                    clientName.error = "Input your name"
                }
                val secondName = clientSecondName.text.toString()
                if (secondName.isEmpty()) clientSecondName.error = "Input your second name "
                val phone = phoneNumber.text.toString()
                if (phone.isEmpty()) phoneNumber.error = "Input your phone number"
                val contactID = firebaceRef.push().key!!
                client = Client(name, secondName, phone, product.ID.toString(),product.name.toString())
                println(client)
                firebaceRef.child(contactID).setValue(client)
                    .addOnCompleteListener {
                        Toast.makeText(
                            this@User_Buy,
                            "we will call you later",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this@User_Buy, "error ${it.message}", Toast.LENGTH_SHORT)
                            .show()

                    }
            }
            // Toast.makeText(this@User_Buy,client.toString(),Toast.LENGTH_SHORT).show()

        }

        }


    }
}