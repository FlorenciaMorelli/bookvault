package com.example.morelli2parcial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.morelli2parcial.adapter.BookListAdapter
import com.example.morelli2parcial.data.Book
import com.example.morelli2parcial.data.BookRepository
import com.example.morelli2parcial.databinding.ActivityBooksBinding
import com.example.morelli2parcial.viewmodel.BookListViewModel

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding
    private lateinit var bookListViewModel: BookListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBooksBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        bookListViewModel = BookListViewModel()
        bookListViewModel.bookList.observe(this){ book ->
            initRcycler(BookRepository.listOfBooks)
        }
    }

    fun initRcycler(book: List<Book>) {
        binding.rvBooks.layoutManager = LinearLayoutManager(this)
        binding.rvBooks.adapter = BookListAdapter(book)
    }
}