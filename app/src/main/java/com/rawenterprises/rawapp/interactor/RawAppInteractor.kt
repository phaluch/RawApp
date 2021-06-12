package com.rawenterprises.rawapp.interactor

import android.util.Log
import com.rawenterprises.rawapp.domain.DataGetProdutos
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.repository.RawAppRepository
import javax.inject.Inject

class RawAppInteractor @Inject constructor(
    private val repository: RawAppRepository
) {
    suspend fun loadProdutos(): List<Produto> {
        // TODO("Not yet implemented")
        Log.d("VIEWMODEL","Interactor> repository()")
        val response = repository.loadProdutos()
        Log.d("VIEWMODEL","Interactor> got response")
        return response
    }

    suspend fun writeUser(): RawUser {
        // TODO("Not yet implemented")
        Log.d("VIEWMODEL","Interactor> repository()")
        val response = repository.writeUser()
        Log.d("VIEWMODEL","Interactor> got response")
        return response
    }

    suspend fun loadUserByEmail(email : String): RawUser {
        // TODO("Not yet implemented")
        Log.d("VIEWMODEL","Interactor> repository()")
        val response = repository.loadUserByEmail(email)
        Log.d("VIEWMODEL","Interactor> got response")
        return response
    }
}