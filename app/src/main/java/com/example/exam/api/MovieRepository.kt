package com.example.exam.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exam.api.RetrofitInstance
import com.example.exam.data.Movie
import com.example.exam.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private val movieApiService = RetrofitInstance.api

    fun searchMovies(query: String): LiveData<List<Movie>> {
        val data = MutableLiveData<List<Movie>>()

        movieApiService.searchMovies(query).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }
}

