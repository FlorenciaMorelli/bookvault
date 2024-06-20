package com.example.morelli2parcial.data

class GenreRepository {
    val listOfGenres = mutableListOf<Genre>(
        Genre(1, "Fiction"),
        Genre(2, "Non-Fiction"),
        Genre(3, "Science Fiction"),
        Genre(4, "Fantasy")
    )

    fun getGenres(): List<Genre> = listOfGenres

}