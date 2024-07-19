package com.example.exam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.data.Movie
import com.example.movieapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private val onClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movies: List<Movie> = listOf()

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.yearTextView.text = movie.releaseDate.split("-")[0]
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.posterPath}").into(binding.posterImageView)
            binding.root.setOnClickListener { onClick(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    fun submitList(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}