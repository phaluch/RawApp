package com.rawenterprises.rawapp.domain

import kotlinx.serialization.Serializable

class RawAppDomain {
}

data class Avaliation (
    var objectId: String? = null,
    var down_votos: Int? = null,
    var rating_usabilidade: Int? = null,
    var pros: String? = null,
    var updatedAt: String? = null,
    var contras: String? = null,
    var rawUser: String? = null,
    var rating_qualidade: Int? = null,
    var title: String? = null,
    var produto: String? = null,
    var rating_custo: Int? = null,
    var createdAt: String? = null,
    var up_votos: Int? = null,
    var comentario: String? = null
)

data class Fabricante (
    val objectId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val nome: String? = null,
    val detalhes: String? = null,
    val tempo_mercado: String? = null
)

data class Loja (
    val objectId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val nome: String? = null,
    val info: String? = null,
    val tempo_mercado: String? = null,
    val produtos: List<String>? = null
)

data class Produto (
    val objectId: String,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val Fabricante: Fabricante? = null,
    val descricao: String? = null,
    val info: String? = null,
    val image: String? = null,
    val nome: String? = null,
)

data class RawUser(
    val objectId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val foto: String? = null,
    val quem_sou: String? = null,
    val sobrenome: String? = null,
    val firebase_id: String? = null,
    val nome: String? = null,
    val email: String? = null
)

data class DataGetProdutos(
    val results: List<Produto>
)