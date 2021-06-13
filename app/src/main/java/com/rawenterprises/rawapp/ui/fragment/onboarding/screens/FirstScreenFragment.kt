package com.rawenterprises.rawapp.ui.fragment.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentFirstScreenBinding
import com.rawenterprises.rawapp.databinding.FragmentSecondScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenFragment : Fragment() {

    private lateinit var binding: FragmentFirstScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        binding.firstScreen = this
        binding.lifecycleOwner = this

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btNext.setOnClickListener {
            viewPager?.currentItem = 1
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}