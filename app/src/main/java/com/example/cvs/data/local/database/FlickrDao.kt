package com.example.cvs.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
abstract class FlickrDao {

    @Query("SELECT * FROM flickr_search")
    abstract fun getUserQueries(): Flow<List<FlickrSearch>>

    @Insert
    abstract suspend fun insertSearch(search: FlickrSearch)

    @Query("DELETE FROM flickr_search where id NOT IN (SELECT id from flickr_search ORDER BY id DESC LIMIT 5)")
    abstract suspend fun deleteOldestSearch()

    @Transaction
    suspend fun insertAndDeleteExtraQueries(search: FlickrSearch) {
        deleteOldestSearch()
        insertSearch(search)
    }
}