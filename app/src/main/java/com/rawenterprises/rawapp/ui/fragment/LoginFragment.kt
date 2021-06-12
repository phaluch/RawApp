package com.rawenterprises.rawapp.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.rawenterprises.rawapp.domain.RawUser
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

        /** A linha abaixo vincula essa classe a essa parte aqui do .xml
        <data>
        <variable
        name="loginFragment"
        type="com.rawenterprises.rawapp.ui.fragment.LoginFragment" />
        </data>
         */
        binding.loginFragment = this


        binding.lifecycleOwner = this
        Log.d("VIEWMODEL", "bindings OK - LoginFragment")
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** To dizendo aqui que quem controla o ciclo de vida é aqui.
         * Se essa tela fechar, ou algo assim, o que está pendente no 'container de dados' é
         * encerrado
         */
        viewmodel.resultadoLoadUserByEmail.observe(viewLifecycleOwner) {r : RawUser ->
            binding.txEmailLogin.setText("${r.nome}")
        }

        binding.btLogin.setOnClickListener {
            val email = binding.txEmailLogin.text.toString()
            val password = binding.txEmailSenha.text.toString()
            val autenticacao = FirebaseAuth.getInstance()

            val taskDeLogin = autenticacao.signInWithEmailAndPassword(email, password)

            taskDeLogin.addOnCompleteListener { resultado ->
                if(resultado.isSuccessful) {

                    val sharedPref = requireActivity().getSharedPreferences("GlobalVar", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("emailGlobal", email)
                    editor.apply()

                    Log.d("VIEWMODEL", "btLoginListener > Saved ${email}")
                    val intencaoDeChamada = Intent(activity, AppActivity::class.java)
                    activity?.startActivity(intencaoDeChamada)
                } else {
                    Toast.makeText(activity, "Um dos campos está incorreto.", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        binding.tvMainEsqueceuSenha.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recuperarSenhaFragment)
        }

        binding.txCriarCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}