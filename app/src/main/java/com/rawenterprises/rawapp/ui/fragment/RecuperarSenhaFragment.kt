package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.rawenterprises.rawapp.databinding.FragmentRecuperarSenhaBinding
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.btRecuperarSenha.setOnClickListener {
            val email = binding.emForgotEmail.text.toString()
            val auth = FirebaseAuth.getInstance()
            auth.sendPasswordResetEmail(email)
            Toast.makeText(view.context, "Se o email estiver cadastrado receberá link para recadastro!", Toast.LENGTH_LONG).show()

        }

    }

}
