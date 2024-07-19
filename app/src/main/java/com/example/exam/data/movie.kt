package com.example.exam.data

import android.media.Image
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("imdbID") val id: Int,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val image: String,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Genre") val genre: String,
    @SerializedName("Country") val country: String,
)

//Título
//o Año
//o Poster
//o Sinopsis
//o Duración
//o Director
//o Género
//o País

