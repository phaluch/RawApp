package com.rawenterprises.rawapp.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.RemoteViews
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rawenterprises.rawapp.domain.Avaliation
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.interactor.RawAppInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class RawViewModel @Inject constructor(
    app: Application,
    private val interactor: RawAppInteractor) : AndroidViewModel(app){

    val resultadoLoadProdutos = MutableLiveData <List<Produto>> () // O tipo de dado é o do que eu vou receber
    val resultadoWriteUser = MutableLiveData < RawUser> () // O tipo de dado é o do que eu vou receber
    val resultadoLoadUserByEmail = MutableLiveData<RawUser> ()
    val resultadoLoadProdutoById = MutableLiveData <Produto> ()


    /** Usuário Logado */
    val resultadoLoadCurrentUser = MutableLiveData<RawUser> () // Esse é o mesmo tipo de response
    val resultadoLoadUserReviews = MutableLiveData <List<Avaliation>> ()
    var resultadoCountCurrentUserReviews = MutableLiveData<Int> ()

    // da linha de cima, mas é só pra separar

    /** Criando um container (resultado) que pode ter os dados dentro dele mutáveis (LiveData), e que
     * notifica constantemente todos os que estiverem 'ouvindo'.
     * Ela que vai receber o resultado da requisição
     */


    ////////////////////////////////////////
    ///// PDM-0504 ~ 1:50:00
    ////////////////////////////////////////


    fun loadProdutos() {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoLoadProdutos.value = interactor.loadProdutos()  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun loadProdutoById(oid : String) {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoLoadProdutoById.value = interactor.loadProdutoById(oid)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun writeUser(u : RawUser) {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoWriteUser.value = interactor.writeUser(u)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun updateUser(u : RawUser) {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            interactor.updateUser(u)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun loadUserByEmail(email : String, editor : SharedPreferences.Editor)
    {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            val response = interactor.loadUserByEmail(email)
            resultadoLoadUserByEmail.value = response // Dentro do tal 'Container' os valores ficam no .value

            editor.putString("emailGlobal", response.email)
            editor.putString("objectId", response.objectId)
            Log.d("VIEWMODEL","putStrings no sharedRefs (emailGlobal=${response.email}, objectId=${response.objectId})")
            editor.apply()
        }
    }
    fun loadCurrentUserByEmail(email : String)
    {
        Log.d("VIEWMODEL","loadCurrentUserByEmail(${email})")

        viewModelScope.launch {
            Log.d("VIEWMODEL","RawViewModel.loadCurrentUserByEmail(${email}) >  resultadoLoadCurrentUser.value")
            resultadoLoadCurrentUser.value = interactor.loadCurrentUserByEmail(email)  // Dentro do tal 'Container' os valores ficam no .value
            Log.d("VIEWMODEL","RawViewModel.loadCurrentUserByEmail(${email}) >  resultadoCountCurrentUserReviews.value")
            resultadoCountCurrentUserReviews.value = interactor.countCurrentUserReviews(email)
        }
    }

    fun loadCurrentUserReviews(email : String)
    {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoLoadUserReviews.value = interactor.loadCurrentUserReviews(email)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun countCurrentUserReviews(email : String)
    {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoCountCurrentUserReviews.value = interactor.countCurrentUserReviews(email)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }



}