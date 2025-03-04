package com.example.morelli2parcial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.morelli2parcial.data.Book
import com.example.morelli2parcial.data.BookRepository

class BookListViewModel : ViewModel() {
    private val _bookList = MutableLiveData<List<Book>>()
    val bookList: LiveData<List<Book>> = _bookList

    init {
        _bookList.value = BookRepository.listOfBooks
    }

    fun addBook(title: String, author: String, genre: String, synopsis: String) {
        val book = Book(title, author, genre, synopsis)
        BookRepository.addBook(book)
        val updatedList = _bookList.value.orEmpty().toMutableList()
        updatedList.add(book)
        _bookList.value = updatedList
    }

    fun deleteBook(book: Book) {
        BookRepository.deleteBook(book.title)
        val updatedList = _bookList.value.orEmpty().toMutableList()
        updatedList.remove(book)
        _bookList.value = updatedList
    }
}