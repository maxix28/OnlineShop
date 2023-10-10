package com.example.usershop.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.usershop.R
import com.example.usershop.databinding.FragmentCardBinding
import com.example.usershop.utility.Card


class CardFragment : Fragment() {
lateinit var  binding: FragmentCardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val card :Card = activity as Card
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_card, container, false)
        binding= FragmentCardBinding.bind(view)
    binding.submitButton.setOnClickListener {
        if(
        binding.cardInputWidget.cardNumberEditText.isCardNumberValid)
        {
         //   Toast.makeText(activity,"Card real",Toast.LENGTH_SHORT).show()
        }
        else{
         //   Toast.makeText(activity,"Card not real",Toast.LENGTH_SHORT).show()

        }
        card.CarValidation(binding.cardInputWidget.cardNumberEditText.isCardNumberValid)

    }
        return  view
    }


}