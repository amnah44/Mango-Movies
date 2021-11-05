package com.mango.movies.model.repositiory

import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.domain.searchResponse.SearchResponse
import com.mango.movies.model.network.API
import com.mango.movies.util.Constant
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


object MovieRepository {

    private fun <T> wrapWithFlow(endPointResponse: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = endPointResponse()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e: Exception) {
                State.Error(e.message.toString())
            }
        }

    }


    fun movieDetails(movieId: Int) =
        wrapWithFlow { API.apiService.getMovieDetails(movieId, Constant.api_key) }

    fun latestMovies() = wrapWithFlow { API.apiService.getLatestMovies(Constant.api_key) }
    fun nowPlayingMovies() = wrapWithFlow { API.apiService.getNowPlayingMovies(Constant.api_key) }
    fun popularMovies() = wrapWithFlow { API.apiService.getPopularMovies(Constant.api_key) }
    fun ratedMovies() = wrapWithFlow { API.apiService.getTopRatedMovies(Constant.api_key) }
    fun upcomingMovies() = wrapWithFlow { API.apiService.getUpcomingMovies(Constant.api_key) }



    fun tvShowDetails(tvId: Int) =
        wrapWithFlow { API.apiService.getTvShowDetails(tvId, Constant.api_key) }

    fun popularTvShow() = wrapWithFlow { API.apiService.getLatestTvShow(Constant.api_key) }
    fun topRatedTvShow() = wrapWithFlow { API.apiService.getTopRatedTvShow(Constant.api_key) }


    fun searchMovie(query: String): Flow<State<SearchResponse?>> =
        wrapWithFlow { API.apiService.searchMovie(query, Constant.api_key) }

    fun personPopular(): Flow<State<PersonPopularResponse?>> =
        wrapWithFlow { API.apiService.getPersonPopular(Constant.api_key) }


    fun personDetails(personId: Int): Flow<State<PersonDetailsResponse?>> =
        wrapWithFlow { API.apiService.getPersonDetails(personId, Constant.api_key) }


    fun genres() = wrapWithFlow { API.apiService.getGenre(Constant.api_key) }
}