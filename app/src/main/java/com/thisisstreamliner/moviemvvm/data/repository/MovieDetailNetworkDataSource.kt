package com.thisisstreamliner.moviemvvm.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thisisstreamliner.moviemvvm.data.api.MovieDbInterface
import com.thisisstreamliner.moviemvvm.data.vo.MovieDetails
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailNetworkDataSource(
    private val serviceApi: MovieDbInterface,
    private val compositeDisposable: CompositeDisposable
) {
    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState // with this get, no need to implement get function to get networkState

    private val _donwloadedMovieDetailResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieDetailResponse: LiveData<MovieDetails>
        get() = _donwloadedMovieDetailResponse

    fun fetchMovieDetails(movieId: Int) {
        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                serviceApi.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        _donwloadedMovieDetailResponse.postValue(it)
                        _networkState.postValue(NetworkState.LOADED)
                    }, {
                        _networkState.postValue(NetworkState.ERROR)
                        Log.e("MovieDetailDataSource", it.message ?: "error")
                    })
            )
        } catch (e: Exception) {
            Log.e("MovieDetailDataSource", e.message ?: "error")
        }
    }
}