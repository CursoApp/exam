package com.example.exam.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("imdbID") val id: Int,
    @SerializedName("Title") val title: String,
    @SerializedName("Released") val release_date: String,
    @SerializedName("Poster") val posterPath: String,
    @SerializedName("Plot") val overview: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Genre") val genres: String,
    @SerializedName("country") val country: String,
)

//Título
//o Año
//o Poster
//o Sinopsis
//o Duración
//o Director
//o Género
//o País

