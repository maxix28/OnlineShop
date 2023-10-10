package com.example.usershop.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.usershop.R
import com.example.usershop.databinding.FragmentCardBinding


class CardFragment : Fragment() {
lateinit var  binding: FragmentCardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_card, container, false)
        binding= FragmentCardBinding.bind(view)

        return  view
    }


}