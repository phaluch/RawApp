package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentHomeBinding
import com.rawenterprises.rawapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.profileFragment = this
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

}