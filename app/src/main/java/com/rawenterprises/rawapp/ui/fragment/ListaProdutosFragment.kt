package com.rawenterprises.rawapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rawenterprises.rawapp.databinding.FragmentListaProdutosBinding
import com.rawenterprises.rawapp.ui.adapter.RawAdapter
import com.rawenterprises.rawapp.viewmodel.RawViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListaProdutosFragment : Fragment() {

    private lateinit var binding: FragmentListaProdutosBinding
    private val viewmodelListaProdutos: RawViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaProdutosBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProduto.layoutManager = LinearLayoutManager(context)

        viewmodelListaProdutos.resultadoLoadProdutos.observe(viewLifecycleOwner) { listProduto ->
            binding.rvProduto.adapter = RawAdapter(listProduto, this)
        }

        loadData(view)

    }
    fun loadData(v: View) {
        viewmodelListaProdutos.loadProdutos()
    }

}