package com.example.morelli2parcial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.R
import com.example.morelli2parcial.data.Genre

class GenreListAdapter(val genreList: List<Genre>): RecyclerView.Adapter<GenreListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GenreListViewHolder(layoutInflater.inflate(R.layout.genre_item, parent, false))
    }

    override fun getItemCount() = genreList.size

    override fun onBindViewHolder(holder: GenreListViewHolder, position: Int) {
        val genre = genreList[position]
        holder.bind(genre)
    }
}