package com.example.cvs.utils

import retrofit2.Response
import java.lang.Exception

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure(val msg: String) : NetworkResult<Nothing>()

    companion object {
        suspend operator fun <T> invoke(action: suspend () -> Response<T>): NetworkResult<T> = try {
            val result = action()
            if (result.isSuccessful && result.body() != null) {
                Success(result.body()!!)
            } else {
                Failure("No data found")
            }
        } catch (ex: Exception) {
            Failure(ex.message ?: "Unexpected Error")
        }
    }
}
