package com.example.morelli2parcial.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.data.Book
import com.example.morelli2parcial.databinding.BookItemBinding

class BookListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = BookItemBinding.bind(view)

    fun bind(book: Book) {
        binding.tvBookTitle.text = book.title
        binding.tvBookAuthor.text = book.author
    }
}