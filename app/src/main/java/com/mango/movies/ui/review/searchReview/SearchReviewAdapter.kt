package com.mango.movies.ui.review.searchReview

import com.mango.movies.R
import com.mango.movies.model.domain.review.ReviewResult
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

class SearchReviewAdapter(
    item: List<ReviewResult>,
    listener: SearchReviewInteractionListener?
) : BaseAdapter<ReviewResult>(item, listener) {
    override val layoutId: Int = R.layout.item_review
}

interface SearchReviewInteractionListener: BaseInteractionListener