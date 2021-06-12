package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentProductInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductInfoFragment : Fragment() {
    private lateinit var binding: FragmentProductInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductInfoBinding.inflate(inflater, container, false)
        binding.productInfoFragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

}