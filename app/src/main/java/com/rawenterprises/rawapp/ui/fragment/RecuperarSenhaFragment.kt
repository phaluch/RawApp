package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rawenterprises.rawapp.databinding.FragmentRecuperarSenhaBinding
import com.rawenterprises.rawapp.viewmodel.RawViewModel


class RecuperarSenhaFragment : Fragment() {

    private lateinit var binding: FragmentRecuperarSenhaBinding
    private val viewmodel: RawViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecuperarSenhaBinding.inflate(inflater, container, false)
        binding.recuperarSenhaFragment = this
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }
}