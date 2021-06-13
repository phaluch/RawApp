package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentHomeBinding
import com.rawenterprises.rawapp.databinding.FragmentMapsBinding


class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.mapsFragment = this
        binding.lifecycleOwner = this
        return binding.root
    }


}