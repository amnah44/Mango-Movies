package com.mango.movies.model.repositiory

import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.CelebrityPopularResult
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.review.ReviewResponse
import com.mango.movies.model.network.API
import com.mango.movies.model.repositiory.FlowWrapper.wrapWithFlow
import com.mango.movies.util.Constant
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow

object Repository {
    fun movieDetails(movieId: Int) =
        wrapWithFlow {
            API.apiService.getMovieDetails(movieId, Constant.api_key)
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

    fun topRatedTvShow() = wrapWithFlow {
        API.apiService.getTopRatedTvShow(Constant.api_key)
    }

    fun tvTrending() = wrapWithFlow {
        API.apiService.getTrendingTV(mediaType = "tv", timeWindow = "week", Constant.api_key)
    }

    fun searchMovie(query: String): Flow<State<BaseResponse<Movie>?>> = wrapWithFlow {
        API.apiService.searchMovie(query, Constant.api_key)
    }

    fun getSimilarMovie(movieId: Int): Flow<State<BaseResponse<Movie>?>> =
        wrapWithFlow {
            API.apiService.getSimilarMovie(movieId, Constant.api_key)
        }

    fun getSimilarSeries(tvId: Int): Flow<State<BaseResponse<Series>?>> =
        wrapWithFlow {
            API.apiService.getSimilarSeries(tvId, Constant.api_key)
        }

    fun personPopular(): Flow<State<BaseResponse<CelebrityPopularResult>?>> =
        wrapWithFlow {
            API.apiService.getPersonPopular(Constant.api_key)
        }

    fun genres(flag: Boolean): Flow<State<GenerResponse?>> =
        if (flag) wrapWithFlow { API.apiService.getMovieGenre(Constant.api_key) }
        else wrapWithFlow { API.apiService.getTvGenre(Constant.api_key) }

    fun getGenreMovieOrTv(
        genre: Int?, flag: Boolean
    ): Flow<State<MovieAndTvByGenreResponse?>> =
        if (flag) wrapWithFlow { API.apiService.getGenreMovie(genre, Constant.api_key) }
        else wrapWithFlow { API.apiService.getGenreTv(genre, Constant.api_key) }

    fun movieReview() = wrapWithFlow {
        API.reviewApiServices.getMovieReviews(Constant.api_key_review)
    }

    fun searchMovieReview(query: String): Flow<State<ReviewResponse?>> = wrapWithFlow {
        API.reviewApiServices.searchMovieReviews(query, Constant.api_key_review)
    }
}
