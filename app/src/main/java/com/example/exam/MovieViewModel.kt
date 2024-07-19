package com.example.exam


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.exam.api.MovieRepository
import com.example.exam.data.Movie

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()

    fun searchMovies(query: String): LiveData<List<Movie>> {
        return repository.searchMovies(query)
    }
}