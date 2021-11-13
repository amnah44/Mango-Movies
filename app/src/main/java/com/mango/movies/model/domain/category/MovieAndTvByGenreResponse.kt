package com.mango.movies.model.domain.category

import com.mango.movies.model.domain.category.Result

data class MovieAndTvByGenreResponse(
    val id: Int?,
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)