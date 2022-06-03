package id.krisna.viuit.network

import retrofit2.HttpException

data class Resource<out T>(val status: Status, val data: T?, val exception: HttpException?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: HttpException?, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, exception)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> idle(): Resource<T> {
            return Resource(Status.IDLE, null, null)
        }
    }

    enum class Status {
        IDLE,
        SUCCESS,
        ERROR,
        LOADING
    }
}