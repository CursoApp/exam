package com.example.exam.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.data.Movie
import com.example.exam.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso



class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getStringExtra("movie")

        movie?.let {
            binding.titleTextView.text = it.title
            binding.yearTextView.text = it.releaseDate.split("-")[0]
            binding.overviewTextView.text = it.overview
            binding.runtimeTextView.text = "Duration: ${it.runtime} minutes"
            binding.directorTextView.text = "Director: ${it.director}"
            binding.genresTextView.text = "Genres: ${it.genres.joinToString(", ")}"
            binding.countryTextView.text = "Country: ${it.country}"
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${it.posterPath}").into(binding.posterImageView)
        }
    }
}