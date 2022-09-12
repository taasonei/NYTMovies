package com.github.taasonei.nytmovies.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.github.taasonei.nytmovies.domain.model.Movie

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}
