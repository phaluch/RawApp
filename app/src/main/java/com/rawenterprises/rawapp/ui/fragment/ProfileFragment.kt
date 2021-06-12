package com.rawenterprises.rawapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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


        val sharedPref = requireActivity().getSharedPreferences("GlobalVar", Context.MODE_PRIVATE)
        val email = sharedPref.getString("emailGlobal", null)
        Log.d("VIEWMODEL", "Using masterUserEmail=${email}")

        viewmodelProfile.resultadoLoadCurrentUser.observe(viewLifecycleOwner) {r : RawUser ->
            binding.tvProfileNomeUser.setText("${r.nome}")
            binding.tvProfileDescricaoUser.setText("${r.quem_sou}")
        }
        viewmodelProfile.resultadoCountCurrentUserReviews.observe(viewLifecycleOwner) {c : Int ->
            binding.tvProfileNumeroReviews.setText("${c} Reviews")
        }

        Log.d("VIEWMODEL","ProfileFragment>onViewCreated> Chamando método loadCUrrentUserByEmail(${email})")
        if (email != null) {
            Log.d("VIEWMODEL","Passei do  email != null")
            viewmodelProfile.loadCurrentUserByEmail(email)
        }
        //Log.d("VIEWMODEL","ProfileFragment>onViewCreated> Criando resultadoLoadCurrentUser.observe")

        /**viewmodelProfile.resultadoLoadCurrentUser.observe(viewLifecycleOwner) {r : RawUser ->
            binding.tvProfileNomeUser.setText("${r.nome}")
            binding.tvProfileDescricaoUser.setText("${r.quem_sou}")
        }*/

        //Log.d("VIEWMODEL","ProfileFragment>onViewCreated> Criando resultadoCountCurrentUserReviews.observe")

        /**viewmodelProfile.resultadoCountCurrentUserReviews.observe(viewLifecycleOwner) {c : Int ->
            binding.tvProfileNumeroReviews.setText("${c} Reviews")
        }*/


        }
}