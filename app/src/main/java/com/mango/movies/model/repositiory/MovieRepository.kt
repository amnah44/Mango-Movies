package com.mango.movies.model.repositiory

import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
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
        wrapWithFlow {
            API.apiService.getMovieDetails(movieId, Constant.api_key)
        }

    fun latestMovies() = wrapWithFlow {
        API.apiService.getLatestMovies(Constant.api_key, "en-US")
    }

    fun ratedMovies() = wrapWithFlow {
        API.apiService.getTopRatedMovies(Constant.api_key)
    }

    fun upcomingMovies() = wrapWithFlow {
        API.apiService.getUpcomingMovies(Constant.api_key)
    }

    fun tvShowDetails(tvId: Int) =
        wrapWithFlow {
            API.apiService.getTvShowDetails(tvId, Constant.api_key)
        }

    fun latestTV() = wrapWithFlow {
        API.apiService.getLatestTvShow(Constant.api_key)
    }

    fun popularTvShow() = wrapWithFlow {
        API.apiService.getLatestTvShow(Constant.api_key)
    }

    fun topRatedTvShow() = wrapWithFlow {
        API.apiService.getTopRatedTvShow(Constant.api_key)
    }

    fun tvTrending() = wrapWithFlow {
        API.apiService.getTrendingTV(mediaType = "tv", timeWindow = "week", Constant.api_key)
    }

    fun searchMovie(query: String): Flow<State<BaseResponse<Movie>?>> = wrapWithFlow {
        API.apiService.searchMovie(query, Constant.api_key)
    }

    fun personPopular(): Flow<State<PersonPopularResponse?>> =
        wrapWithFlow {
            API.apiService.getPersonPopular(Constant.api_key)
        }

    fun personDetails(personId: Int): Flow<State<PersonDetailsResponse?>> =
        wrapWithFlow {
            API.apiService.getPersonDetails(personId, Constant.api_key)
        }

    fun genres(flag: Boolean): Flow<State<GenerResponse?>> {
        return if (flag) wrapWithFlow { API.apiService.getMovieGenre(Constant.api_key) }
        else wrapWithFlow { API.apiService.getTvGenre(Constant.api_key) }
    }

    fun getGenreMovieOrTv(
        genre: Int?, flag: Boolean
    ): Flow<State<MovieAndTvByGenreResponse?>> =
        if (flag) wrapWithFlow { API.apiService.getGenreMovie(genre, Constant.api_key) }
        else wrapWithFlow { API.apiService.getGenreTv(genre, Constant.api_key) }

}