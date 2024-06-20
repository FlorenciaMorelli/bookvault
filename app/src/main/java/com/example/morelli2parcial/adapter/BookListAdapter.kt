package com.example.morelli2parcial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.R
import com.example.morelli2parcial.data.Book

class BookListAdapter(val bookList: List<Book>) : RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookListViewHolder(layoutInflater.inflate(R.layout.book_item, parent, false))
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val item = bookList[position]
        holder.bind(item)
    }
}