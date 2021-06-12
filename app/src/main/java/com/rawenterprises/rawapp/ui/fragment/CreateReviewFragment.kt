package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentCreateReviewBinding
import com.rawenterprises.rawapp.databinding.FragmentLoginBinding

class CreateReviewFragment : Fragment() {

    private lateinit var binding: FragmentCreateReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateReviewBinding.inflate(inflater, container, false)
        binding.createReviewFragment = this
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

}