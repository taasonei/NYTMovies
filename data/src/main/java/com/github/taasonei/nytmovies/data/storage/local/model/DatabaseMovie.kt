package com.github.taasonei.nytmovies.data.storage.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class DatabaseMovie(
    @PrimaryKey
    @ColumnInfo(name = "display_title") val title: String,
    @ColumnInfo(name = "summary_short") val summary: String,
    @ColumnInfo(name = "src") val src: String
)

