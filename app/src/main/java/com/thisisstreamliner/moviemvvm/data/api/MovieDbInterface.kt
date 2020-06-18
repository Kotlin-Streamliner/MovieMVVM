package com.thisisstreamliner.moviemvvm.data.api

import com.thisisstreamliner.moviemvvm.data.vo.MovieDetails
import com.thisisstreamliner.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbInterface {

    @GET("movie/{movieId}")
    fun getMovieDetails(@Path("movieId") id: Int) : Single<MovieDetails>

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int) : Single<PopularMoviesResponse>
}