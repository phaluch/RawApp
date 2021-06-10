package com.rawenterprises.rawapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.rawenterprises.rawapp.databinding.FragmentLoginBinding
import com.rawenterprises.rawapp.ui.activity.AppActivity
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewmodel: RawViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginFragment = this
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener {
            val email = binding.txEmailLogin.text.toString()
            val password = binding.txEmailSenha.text.toString()
            val autenticacao = FirebaseAuth.getInstance()

            val taskDeLogin = autenticacao.signInWithEmailAndPassword(email, password)

            taskDeLogin.addOnCompleteListener { resultado ->
                if(resultado.isSuccessful) {
                    val intencaoDeChamada = Intent(activity, AppActivity::class.java)
                    activity?.startActivity(intencaoDeChamada)
                } else {
                    Toast.makeText(activity, "Um dos campos está incorreto.", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

}