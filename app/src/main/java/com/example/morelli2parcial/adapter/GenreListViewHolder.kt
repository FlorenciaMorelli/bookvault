package com.example.morelli2parcial.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.morelli2parcial.BooksActivity
import com.example.morelli2parcial.data.Genre
import com.example.morelli2parcial.databinding.GenreItemBinding

class GenreListViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val binding = GenreItemBinding.bind(view)

    fun bind(genre: Genre){
        binding.tvGenreName.text = genre.name
        binding.btnGenre.setOnClickListener{
            val intent = Intent(itemView.context, BooksActivity::class.java)
            intent.putExtra("genre", genre.name)
            itemView.context.startActivity(intent)
        }
    }


}