package com.example.morelli2parcial.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.BookDetailActivity
import com.example.morelli2parcial.R
import com.example.morelli2parcial.data.Book

class BookListAdapter(
    private val bookList: List<Book>,
    private val onBookClick: (Book) -> Unit
) : RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookListViewHolder(layoutInflater.inflate(R.layout.book_item, parent, false))
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = bookList[position]
        holder.bind(book)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BookDetailActivity::class.java)
            intent.putExtra("book", book)
            context.startActivity(intent)
        }
    }
}