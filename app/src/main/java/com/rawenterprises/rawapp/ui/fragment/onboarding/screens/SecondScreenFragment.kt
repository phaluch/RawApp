package com.rawenterprises.rawapp.ui.fragment.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentSecondScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SecondScreenFragment : Fragment() {

    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        binding.secondScreen = this
        binding.lifecycleOwner = this

        binding.btFinish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onboardingFinished()
        }

        return binding.root
    }

    private fun onboardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}