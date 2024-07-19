package com.example.exam.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(
        @SerializedName("Search") val results: List<Movie>
){
}