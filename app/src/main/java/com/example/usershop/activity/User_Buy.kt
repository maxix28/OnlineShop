package com.example.usershop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usershop.R
import com.example.usershop.databinding.ActivityUserBuyBinding
import com.example.usershop.utility.*
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class User_Buy : AppCompatActivity(),Card {
    lateinit var binding: ActivityUserBuyBinding
    lateinit var  product : Product
    lateinit var firebaceRef: DatabaseReference
    lateinit var client: Client
    lateinit var  order: order
     private var card: Boolean?=null
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

        firebaceRef = FirebaseDatabase.getInstance().getReference("orders")

        binding.apply {


            verificate.setOnClickListener {
                Toast.makeText(this@User_Buy,"Open card fragment",Toast.LENGTH_SHORT).show()
supportFragmentManager.beginTransaction().apply {
    replace(R.id.CardFragment,CardFragment())
    addToBackStack(null)

    commit()
}
            }


            buyNowBTN.setOnClickListener {
           //     if(CarValidation(real))

                val name = clientName.text.toString()
                if (name.isEmpty()) {
                    clientName.error = "Input your name"
                }
                val phone = phoneNumber.text.toString()
                if (phone.isEmpty()) phoneNumber.error = "Input your phone number"

                val email= emailOrder.text.toString()
                if(email.isEmpty())emailOrder.error = " Input your email"
                if ( card==false){
                    Toast.makeText(this@User_Buy,"Verify yourself",Toast.LENGTH_SHORT).show()
                }
                val contactID = firebaceRef.push().key!!

                order = order(product.name.toString(),product.price!!.toInt(),name,phone,product.ID.toString(),contactID,email)

                firebaceRef.child(contactID).setValue(order)
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



//            buyNowBTN.setOnClickListener {
//            GlobalScope.launch(Dispatchers.IO) {
//                // if(clientName.isEm)
//                val name = clientName.text.toString()
//                if (name.isEmpty()) {
//                    clientName.error = "Input your name"
//                }
//                val secondName = clientSecondName.text.toString()
//                if (secondName.isEmpty()) clientSecondName.error = "Input your second name "
//                val phone = phoneNumber.text.toString()
//                if (phone.isEmpty()) phoneNumber.error = "Input your phone number"
//                val contactID = firebaceRef.push().key!!
//                client = Client(name, secondName, phone, product.ID.toString(),product.name.toString())
//                var client1= product.price?.let { it1 ->
//                    Client1(name,
//                        it1.toInt(),phone,product.ID.toString(),product.name.toString())
//                }
//                println(client1)
//                //println(client)
//                firebaceRef.child(contactID).setValue(client1)
//                    .addOnCompleteListener {
//                        Toast.makeText(
//                            this@User_Buy,
//                            "we will call you later",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                    .addOnFailureListener {
//                        Toast.makeText(this@User_Buy, "error ${it.message}", Toast.LENGTH_SHORT)
//                            .show()
//
//                    }
//            }
//            // Toast.makeText(this@User_Buy,client.toString(),Toast.LENGTH_SHORT).show()
//
//        }

        }


    }

    override fun CarValidation(real: Boolean) {
        card = real
       Toast.makeText(this,"Real card is ${card} ", Toast.LENGTH_SHORT).show()
    }
}