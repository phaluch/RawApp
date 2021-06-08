package com.rawenterprises.rawapp.interactor

import com.rawenterprises.rawapp.repository.RawAppRepository
import javax.inject.Inject

class RawAppInteractor @Inject constructor(
    val repository: RawAppRepository
) {
    fun funChamandoRequisicao() {
        TODO("Not yet implemented")
        repository.funChamandoRequisicao()
    }
}