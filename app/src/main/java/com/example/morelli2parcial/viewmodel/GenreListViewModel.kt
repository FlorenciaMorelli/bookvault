package com.example.morelli2parcial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.morelli2parcial.data.Genre
import com.example.morelli2parcial.data.GenreRepository

class GenreListViewModel : ViewModel() {
    private val _genreList = MutableLiveData<List<Genre>>()
    val genreList: LiveData<List<Genre>> = _genreList

    init {
        _genreList.value = GenreRepository.listOfGenres
    }

    fun addGenre(name: String) {
        val genre = Genre(name)
        val updatedList = _genreList.value.orEmpty().toMutableList()
        updatedList.add(genre)
        _genreList.value = updatedList
    }
}