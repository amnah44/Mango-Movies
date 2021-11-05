package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

//class HomeAdapter(
//    item: List<Genre>,
//    listener: HomeInteractionListener
//) : BaseAdapter<Genre>(item, listener) {
//    override val layoutId: Int = R.layout.item_genre
//}
//
interface HomeInteractionListener : BaseInteractionListener {
//    fun onClickCategory(genre: Genre)
    fun onClickMovie(movieNowPlayingResult: MovieNowPlayingResult)
    fun onTopRateClick(movieTopRate: MovieTopRatedResult)
}

class NowPlayingMovieAdapter(
    item: List<MovieNowPlayingResult>,
    listener: HomeInteractionListener
) : BaseAdapter<MovieNowPlayingResult>(item, listener) {
    override val layoutId: Int = R.layout.item_now_playing_movie
}
class TopRateMovieAdapter(
    item: List<MovieTopRatedResult>,
    listener: HomeInteractionListener
) : BaseAdapter<MovieTopRatedResult>(item, listener) {
    override val layoutId: Int = R.layout.item_top_rate_movie
}