package com.thisisstreamliner.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thisisstreamliner.moviemvvm.data.repository.MovieDetailRepository
import com.thisisstreamliner.moviemvvm.data.repository.NetworkState
import com.thisisstreamliner.moviemvvm.data.vo.MovieDetails
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SingleMovieViewModel(
    private val movieDetailRepository: MovieDetailRepository,
    private val movieId: Int
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieDetailRepository.fetchSingleMovieDetail(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieDetailRepository.getMovieDetailNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}