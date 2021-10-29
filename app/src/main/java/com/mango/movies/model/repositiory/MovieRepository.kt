package com.mango.movies.model.repositiory

import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


object MovieRepository {

    private fun <T> wrapWithFlow(endPointResponse: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            emit(checkStateResponse(endPointResponse()))
        }
    }

    private fun <T> checkStateResponse(response: Response<T>): State<T?> {
        return try {
            if (response.isSuccessful) State.Success(response.body())
            else State.Error(response.message())
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }
    }

}