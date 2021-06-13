package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavGraph
import androidx.navigation.fragment.navArgs
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.FragmentProductInfoBinding
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class ProductInfoFragment : Fragment() {

    private lateinit var binding: FragmentProductInfoBinding
    private val viewmodelProductInfo: RawViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductInfoBinding.inflate(inflater, container, false)
        binding.productInfoFragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodelProductInfo.resultadoLoadProdutoById.observe(viewLifecycleOwner) {c : Produto ->
            Log.d("VIEWMODEL", "Entrei no lambda do .observe()")
            binding.tvProdutoTitulo.setText("${c.nome}")
            binding.tvProdutoInfo.setText("${c.info}")
            binding.tvFabricanteNome.setText("${c.Fabricante?.nome}")
            binding.tvFabricanteInfo.setText("${c.Fabricante?.detalhes}")
            binding.tvDetalhesProduto.setText("${c.descricao}")
        }

        val args : ProductInfoFragmentArgs by navArgs()
        Log.d("VIEWMODEL","Valor de args.objectId={$args.objectId}")

        Log.d("VIEWMODEL", "Using masterUserEmail=${args.objectId}")
        if (args.objectId != null) {
            Log.d("VIEWMODEL", "Passei do  email != null")
            viewmodelProductInfo.loadProdutoById(args.objectId)
        }
    }



}