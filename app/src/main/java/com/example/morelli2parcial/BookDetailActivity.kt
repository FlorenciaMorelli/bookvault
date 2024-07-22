package com.example.morelli2parcial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.morelli2parcial.data.Book

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val titleTextView: TextView = findViewById(R.id.textViewTitle)
        val authorTextView: TextView = findViewById(R.id.textViewAuthor)
        val synopsisTextView: TextView = findViewById(R.id.tv_synopsis)


        // Obtener el libro del Intent
        val book = intent.getSerializableExtra("book") as? Book

        // Configurar las vistas con los datos del libro
        book?.let {
            titleTextView.text = it.title
            authorTextView.text = it.author
            synopsisTextView.text = it.synopsis
        }
    }
}