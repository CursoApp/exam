package com.example.exam

import android.telecom.Call
import com.example.exam.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/?apikey=7c0c761b")
    fun searchMovies(@Query("s") query: String): MovieResponse
}

//, @Query("api_key") apiKey: String)