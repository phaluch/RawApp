package com.rawenterprises.rawapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.domain.RawUser
import com.rawenterprises.rawapp.interactor.RawAppInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RawViewModel @Inject constructor(
    app: Application,
    private val interactor: RawAppInteractor) : AndroidViewModel(app){

    val resultadoLoadProdutos = MutableLiveData <List<Produto>> () // O tipo de dado é o do que eu vou receber
    val resultadoWriteUser = MutableLiveData < RawUser> () // O tipo de dado é o do que eu vou receber
    val resultadoLoadUserByEmail = MutableLiveData<RawUser> ()
    // val resultadoLoadProdutos = MutableLiveData <List<Produto>> () // O tipo de dado é o do que eu vou receber
    // val resultadoLoadProdutos = MutableLiveData <List<Produto>> () // O tipo de dado é o do que eu vou receber


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

    fun writeUser() {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoWriteUser.value = interactor.writeUser()  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

    fun loadUserByEmail(email : String)
    {
        Log.d("VIEWMODEL","Entrei na Função")

        viewModelScope.launch {
            Log.d("VIEWMODEL","Chamando o Interactor")
            resultadoLoadUserByEmail.value = interactor.loadUserByEmail(email)  // Dentro do tal 'Container' os valores ficam no .value
        }
    }

}