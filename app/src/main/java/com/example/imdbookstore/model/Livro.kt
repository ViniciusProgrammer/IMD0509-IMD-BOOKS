package com.example.imdbookstore.model

// Modelo de Livro
data class Livro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val editora: String?,
    val isbn: String,
    val descricao: String?,
    val imagemUrl: String?
)