package com.github.taasonei.nytmovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.taasonei.nytmovies.R
import com.github.taasonei.nytmovies.databinding.MovieItemBinding
import com.github.taasonei.nytmovies.domain.model.Movie

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                titleTextView.text = movie.title
                summaryTextView.text = movie.summary
            }
            Glide.with(binding.root.context)
                .load(movie.src)
                .error(R.drawable.ic_broken_image)
                .into(binding.movieImageView)
        }

    }

}
