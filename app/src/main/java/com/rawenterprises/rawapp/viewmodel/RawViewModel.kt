package com.rawenterprises.rawapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rawenterprises.rawapp.interactor.RawAppInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RawViewModel @Inject constructor(
    app: Application,
    val interactor: RawAppInteractor) : AndroidViewModel(app){

    fun funChamandoRequisicao() {
        TODO("Not yet implemented")
//        interactor.funChamandoRequisicao()
    }
}