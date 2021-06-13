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
import com.rawenterprises.rawapp.databinding.FragmentEditProfileBinding
import com.rawenterprises.rawapp.databinding.FragmentProfileBinding
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment : Fragment() {

    private val viewmodelEditProfile: RawViewModel by viewModels()
    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("VIEWMODEL","ProfileFragment>onCreateView> criando binding")
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        binding.editProfileFragment = this
        binding.lifecycleOwner = this

        /** Requisicao pra pegar infos do usuário */

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

        binding.btEditProfileEnviar.setOnClickListener {
            Log.d("VIEWMODEL","btEditProfileEnviar > Clicked")
            sendData()
        }

    }

    private fun sendData() {
        Log.d("VIEWMODEL","EditProfileFragment.sendData > VOU PEGAR curUser")
        val curUser = viewmodelEditProfile.resultadoLoadCurrentUser.value
        Log.d("VIEWMODEL","EditProfileFragment.sendData > Peguei curUser")
        if (curUser != null) {
            Log.d("VIEWMODEL","Valores: (objectId=${curUser.objectId}, email=${curUser.email}, nome=${curUser.nome}")
        }

        val sharedPref = requireActivity().getSharedPreferences("GlobalVar", Context.MODE_PRIVATE)

        val email = sharedPref.getString("emailGlobal", null)
        Log.d("VIEWMODEL","EditProfileFragment.sendData > email=$email do SharedPref.emailGlobal")

        val objectId = sharedPref.getString("objectId", null)
        Log.d("VIEWMODEL", "EditProfileFragment.sendData> objectId (do sharedPref.getString) == ${objectId}")

        val newNome = binding.etEditProfileNomeUser.text.toString()
        val newDescr = binding.etEditProfileDescricaoUser.text.toString()

        val updatedUser = RawUser(objectId = objectId, nome = newNome, quem_sou = newDescr)
        Log.d("VIEWMODEL","ProfileFragment>onViewCreated> Chamando método loadCUrrentUserByEmail(${email})")

        viewmodelEditProfile.updateUser(updatedUser)
        findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
    }
}


