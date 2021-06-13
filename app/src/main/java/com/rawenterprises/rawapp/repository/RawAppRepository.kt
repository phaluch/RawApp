package com.rawenterprises.rawapp.repository

import android.util.Log
import com.rawenterprises.rawapp.di.RawAppModule
import com.rawenterprises.rawapp.domain.Avaliation
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.domain.RawUser
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject

class RawAppRepository @Inject constructor(
    private val request : RawAppModule.RawAppService
) {

    /** PRODUTOS */
    suspend fun loadProdutos(): List<Produto> {
        Log.d("VIEWMODEL","Repository> Instanciando retrofit: Retrofit.Builder()")
        return request.getProducts()
    }
    suspend fun loadProductsBySubstring(): List<Produto> {
        Log.d("VIEWMODEL","Repository> Instanciando retrofit: Retrofit.Builder()")
        return request.getProductsBySubstring()
    }

    /** USERS */
    suspend fun loadUserByEmail(email : String): RawUser {
        Log.d("VIEWMODEL","Repository> loadUserByEmail()")
        return request.getUserByEmail(email)
    }

    suspend fun loadCurrentUserByEmail(email : String): RawUser {
        Log.d("VIEWMODEL","Repository> loadUserByEmail()")
        return request.getUserByEmail(email)
    }

    suspend fun writeUser(u : RawUser): RawUser {
        Log.d("VIEWMODEL","Repository> writeUser()")
        return request.postCreateUser(u)
    }

    suspend fun loadCurrentUserReviews(email: String): List<Avaliation> {
        Log.d("VIEWMODEL","Repository> writeUser()")
        return request.getReviewsByUserEmail(email)
    }

    suspend fun updateUser(u: RawUser) {
        Log.d("VIEWMODEL","Repository> writeUser()")
        request.putUser(u)
    }


}
