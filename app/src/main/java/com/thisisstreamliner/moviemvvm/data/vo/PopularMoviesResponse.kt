package com.thisisstreamliner.moviemvvm.data.vo


import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    val page: Int,
    @SerializedName("results")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)