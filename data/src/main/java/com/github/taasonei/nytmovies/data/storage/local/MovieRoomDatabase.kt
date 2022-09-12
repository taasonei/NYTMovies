package com.github.taasonei.nytmovies.data.storage.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.taasonei.nytmovies.data.storage.local.model.DatabaseMovie

@Database(entities = [DatabaseMovie::class], version = 1)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MovieRoomDatabase::class.java,
                    "movie-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}