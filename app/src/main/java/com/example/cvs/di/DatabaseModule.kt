package com.example.cvs.di

import android.content.Context
import androidx.room.Room
import com.example.cvs.data.local.database.FlickrDao
import com.example.cvs.data.local.database.FlickrDataBase
import com.example.cvs.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesCommentDatabase(
        @ApplicationContext context: Context
    ): FlickrDataBase {
        return Room.databaseBuilder(
            context,
            FlickrDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun providesCommentDao(database: FlickrDataBase): FlickrDao {
        return database.getFlickrDao()
    }
}