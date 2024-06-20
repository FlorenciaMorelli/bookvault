package com.example.morelli2parcial.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.data.Genre
import com.example.morelli2parcial.databinding.GenreItemBinding

class GenreListViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val binding = GenreItemBinding.bind(view)

    fun bind(genre: Genre){
        binding.tvGenreName.text = genre.name
    }
}