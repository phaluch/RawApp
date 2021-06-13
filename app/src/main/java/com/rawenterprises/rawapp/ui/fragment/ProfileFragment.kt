package com.rawenterprises.rawapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentProfileBinding
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewmodelProfile: RawViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        
        Log.d("VIEWMODEL","ProfileFragment>onCreateView> criando binding")
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.profileFragment = this
        binding.lifecycleOwner = this

        val sharedPref = requireActivity().getSharedPreferences("GlobalVar", Context.MODE_PRIVATE)
        val email = sharedPref.getString("emailGlobal", null)
        if (email != null) {
            Log.d("VIEWMODEL", "Passei do  email != null")
            viewmodelProfile.loadCurrentUserByEmail(email)
        }

        // Inflate the layout for this fragment
        Log.d("VIEWMODEL","ProfileFragment>onCreateView> Retornando binding")
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** To dizendo aqui que quem controla o ciclo de vida é aqui.
         * Se essa tela fechar, ou algo assim, o que está pendente no 'container de dados' é
         * encerrado
         */

        /** Preencher a tela */

        val sharedPref = requireActivity().getSharedPreferences("GlobalVar", Context.MODE_PRIVATE)
        val email = sharedPref.getString("emailGlobal", null)

        viewmodelProfile.resultadoLoadCurrentUser.observe(viewLifecycleOwner) { c : RawUser ->
            Log.d("VIEWMODEL", "Using valores=${c.quem_sou},${c.nome}")
            binding.tvProfileDescricaoUser.setText("${c.quem_sou}")
            binding.tvProfileNomeUser.setText("${c.nome}")
        }

        binding.btProfileEdit.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        binding.btMinhasReviews.setOnClickListener{
            if (email != null) {
                Log.d("VIEWMODEL", "Passei do  email != null")
                viewmodelProfile.loadCurrentUserByEmail(email)
            }
        }

        Log.d("VIEWMODEL", "Using masterUserEmail=${email}")
        if (email != null) {
            Log.d("VIEWMODEL", "Passei do  email != null")
            viewmodelProfile.loadCurrentUserByEmail(email)
        }
    }
}