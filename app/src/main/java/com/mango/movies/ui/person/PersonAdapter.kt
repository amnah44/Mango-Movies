package com.mango.movies.ui.person

import android.util.Log
import androidx.navigation.Navigation
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.R
import com.mango.movies.model.domain.person.popular.PersonPopularResult

class PersonAdapter(items: List<PersonPopularResult>, listener: PersonInteractionListener) :
    BaseAdapter<PersonPopularResult>(items, listener) {
    override val layoutId = R.layout.item_people

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.itemView.setOnClickListener{v ->
            Navigation.findNavController(v).navigate(R.id.action_personFragment_to_personDetailsFragment)
        }
    }
}