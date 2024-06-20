package com.example.morelli2parcial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.morelli2parcial.adapter.GenreListAdapter
import com.example.morelli2parcial.data.Genre
import com.example.morelli2parcial.data.GenreRepository
import com.example.morelli2parcial.databinding.ActivityMainBinding
import com.example.morelli2parcial.viewmodel.GenreListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var genreListViewModel: GenreListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        genreListViewModel = GenreListViewModel()

        genreListViewModel.genreList.observe(this) { genre ->
            initRecycler(GenreRepository.listOfGenres)
        }


    }

    fun initRecycler(genres: List<Genre>) {
        binding.rvGenres.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvGenres.adapter = GenreListAdapter(genres)
    }
}