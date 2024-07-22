package com.example.morelli2parcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.morelli2parcial.adapter.BookListAdapter
import com.example.morelli2parcial.data.Book
import com.example.morelli2parcial.data.BookRepository
import com.example.morelli2parcial.databinding.ActivityBooksBinding
import com.example.morelli2parcial.databinding.DialogBookBinding
import com.example.morelli2parcial.viewmodel.BookListViewModel

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding
    private lateinit var bookListViewModel: BookListViewModel
    private lateinit var dialogBookBinding: DialogBookBinding
    private lateinit var adapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBooksBinding.inflate(layoutInflater)
        dialogBookBinding = DialogBookBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(dialogBookBinding.root)
        val alertDialog = alertDialogBuilder.create()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val genreName = intent.getStringExtra("genre")
        binding.tvBooks.text = genreName

        bookListViewModel = BookListViewModel()
        bookListViewModel.bookList.observe(this){ book ->
            initRecycler(BookRepository.listOfBooks)
        }

        setListener(alertDialog)

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            // Finish the activity and return to the previous screen
            finish()
        }
    }

    fun initRecycler(books: List<Book>) {
        adapter = BookListAdapter(books.toMutableList()) { selectedBook ->
            val intent = Intent(this, BookDetailActivity::class.java)
            intent.putExtra("book", selectedBook)
            startActivity(intent)
        }
        binding.rvBooks.layoutManager = LinearLayoutManager(this)
        binding.rvBooks.adapter = adapter
    }

    fun setListener(alertDialog: AlertDialog) {
        binding.fabAddBook.setOnClickListener {
            showAlertDialog(alertDialog)
        }
    }

    fun showAlertDialog(alertDialog: AlertDialog) {
        alertDialog.show()
        clearEditTexts()

        dialogBookBinding.btnAddBook.setOnClickListener {
            val title = addTitleBook()
            val author = addAuthorBook()
            val genre = addGenreBook()
            val synopsis = addSynopsisBook()
            if (title.isNotEmpty() && author.isNotEmpty() && genre.isNotEmpty() && synopsis.isNotEmpty()) {
                bookListViewModel.addBook(title, author, genre, synopsis)
                alertDialog.dismiss()
            }
        }
    }

    fun addTitleBook(): String {
        val title = dialogBookBinding.etTitle.text.toString()
        return title
    }

    fun addAuthorBook(): String {
        val author = dialogBookBinding.etAuthor.text.toString()
        return author
    }
    fun addGenreBook(): String {
        val title = dialogBookBinding.etGenre.text.toString()
        return title
    }

    fun addSynopsisBook(): String {
        val author = dialogBookBinding.etSynopsis.text.toString()
        return author
    }

    fun clearEditTexts() {
        dialogBookBinding.etTitle.text.clear()
        dialogBookBinding.etAuthor.text.clear()
        dialogBookBinding.etGenre.text.clear()
        dialogBookBinding.etSynopsis.text.clear()
    }
}