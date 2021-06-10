package com.rawenterprises.rawapp.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentFirstScreenBinding
import com.rawenterprises.rawapp.databinding.FragmentViewPagerBinding
import com.rawenterprises.rawapp.ui.fragment.onboarding.screens.FirstScreenFragment
import com.rawenterprises.rawapp.ui.fragment.onboarding.screens.SecondScreenFragment


class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        binding.vpFragment = this
        binding.lifecycleOwner = this

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }
}