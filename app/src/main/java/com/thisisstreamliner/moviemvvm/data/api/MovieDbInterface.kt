package com.thisisstreamliner.moviemvvm.data.api

import com.thisisstreamliner.moviemvvm.data.vo.MovieDetails
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDbInterface {
    @GET("movie/{movieId}")
    fun getMovieDetails(@Path("movieId") id: Int) : Single<MovieDetails>
}