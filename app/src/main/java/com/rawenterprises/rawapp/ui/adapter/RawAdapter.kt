package com.rawenterprises.rawapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.stream.JsonToken
import com.rawenterprises.rawapp.R
import com.rawenterprises.rawapp.databinding.ItemListProdutoBinding
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.ui.fragment.ListaProdutosFragment
import com.rawenterprises.rawapp.ui.fragment.ListaProdutosFragmentDirections
import kotlinx.serialization.json.Json
import javax.inject.Inject

class RawAdapter @Inject constructor(
    private val lista: List<Produto>,
    private val cont : ListaProdutosFragment
) : RecyclerView.Adapter<ProdutoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        val template = LayoutInflater.from(parent.context).inflate(R.layout.item_list_produto, parent, false)
        return ProdutoViewHolder(template)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = lista[position]
        holder.binding.produto = produto
        holder.binding.executePendingBindings()
        val oId = produto.objectId

        holder.binding.tvName.setOnClickListener{
            val action = ListaProdutosFragmentDirections
                .actionListaProdutosFragmentToProductInfoFragment(produto.objectId)
            NavHostFragment.findNavController(cont).navigate(action)
            Log.d("VIEWMODEL", ">>> holder.binding.tvName.setOnClickListener = ")
        }
    }

    override fun getItemCount() = lista.size

}
class ProdutoViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding: ItemListProdutoBinding = ItemListProdutoBinding.bind(v)
}