package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentLoginBinding
import com.rawenterprises.rawapp.databinding.FragmentRegisterBinding
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewmodelRegister: RawViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerFragment = this
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegisterRegistrar.setOnClickListener {
            cadastrar()
        }

    }
    private fun cadastrar() {
        val email = binding.etRegisterEmail.text.toString()
        val password = binding.etPasswordRegister.text.toString()
        val retype = binding.etConfirmPasswordRegister.text.toString()

        if (password != retype) {
            Toast.makeText(activity, "Senhas diferentes!", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val taskDeLogin = auth.createUserWithEmailAndPassword(email, password)

        taskDeLogin.addOnCompleteListener { resultado ->
            if (resultado.isSuccessful) {
                viewmodelRegister.writeUser(RawUser(email = email))
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            } else {
                Toast.makeText(activity, "Algo deu errado no cadastro", Toast.LENGTH_LONG).show()
            }
        }
    }
}

