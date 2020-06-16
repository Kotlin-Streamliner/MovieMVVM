package com.thisisstreamliner.moviemvvm.data.repository

import androidx.lifecycle.LiveData
import com.thisisstreamliner.moviemvvm.data.api.MovieDbInterface
import com.thisisstreamliner.moviemvvm.data.vo.MovieDetails
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieDetailRepository(private val apiService: MovieDbInterface) {

    lateinit var movieDetailNetworkDataSource: MovieDetailNetworkDataSource

    fun fetchSingleMovieDetail(compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {
        movieDetailNetworkDataSource = MovieDetailNetworkDataSource(apiService, compositeDisposable)
        movieDetailNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailNetworkDataSource.downloadedMovieDetailResponse
    }

    fun getMovieDetailNetworkState() : LiveData<NetworkState> {
        return movieDetailNetworkDataSource.networkState
    }
}