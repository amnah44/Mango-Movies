package com.mango.movies.ui.review

import com.mango.movies.R
import com.mango.movies.model.domain.review.ReviewResult
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

class ReviewAdapter(
    item: List<ReviewResult>,
    listener: ReviewInteractionListener?
) : BaseAdapter<ReviewResult>(item, listener) {
    override val layoutId = R.layout.item_review
}

interface ReviewInteractionListener : BaseInteractionListener