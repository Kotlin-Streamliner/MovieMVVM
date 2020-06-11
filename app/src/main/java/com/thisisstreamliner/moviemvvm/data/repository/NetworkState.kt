package com.thisisstreamliner.moviemvvm.data.repository


enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {

    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(status = Status.SUCCESS, msg = "Success")

            LOADING = NetworkState(status = Status.RUNNING, msg = "Running")

            ERROR = NetworkState(status = Status.FAILED, msg = "Something went wrong")
        }
    }
}