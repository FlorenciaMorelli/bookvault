package com.example.morelli2parcial.data

import java.io.Serializable

data class Book(
    val title: String,
    val author: String,
    val genre: String,
    val synopsis: String
) : Serializable