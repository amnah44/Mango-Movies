package com.mango.movies.util

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_MOVIE_URL = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"
    const val BASE_PERSON_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val api_key = "68ff47a440b5f644e1533eb5afbd1669"

    val GENRE_KEY= mutableMapOf(28 to 10759,
        12 to 10759,
        16 to 16,
        35 to 35,
        80 to 80,
        99 to 99,
        18 to 18,
        10751 to 10751,
        14 to 18,
        36 to 18,
        27 to 18,
        10402 to 18,
        9648 to 9648,
        10749 to 18,
        878 to 18,
        10770 to 18,
        53 to 18,
        10752 to 10768,
        37 to 37)

    //Log tags to be used inside the fragments classes
    const val HOME_FRAGMENT = "Home Fragment"
    const val DETAILS_FRAGMENT = "Details Fragment"
    const val PEOPLE_FRAGMENT = "People Fragment"
    const val CATEGORY_FRAGMENT = "Category Fragment"
    const val PERSON_DETAILS_FRAGMENT = "Person Details Fragment"
    const val SHOW_MORE_MOVIES_FRAGMENT = "Show More Movies Fragment"
    const val SHOW_MORE_SERIES_FRAGMENT = "Show More Series Fragment"
    const val FAVORITES_FRAGMENT = "Favorites Fragment"
    const val SEARCH_FRAGMENT = "Search Fragment"
    const val SETTINGS_FRAGMENT = "Settings Fragment"
}