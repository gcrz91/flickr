package com.example.cvs.di

import com.example.cvs.data.local.database.FlickrDao
import com.example.cvs.data.local.datasource.FlickrSearchLocalDataSource
import com.example.cvs.data.remote.datasource.FlickrSearchRemoteDataSource
import com.example.cvs.data.remote.service.FlickrService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesFlickrSearchLocalDataSource(flickrDao: FlickrDao): FlickrSearchLocalDataSource {
        return FlickrSearchLocalDataSource(flickrDao)
    }

    @Singleton
    @Provides
    fun providesFlickrSearchRemoteDataSource(flickrService: FlickrService): FlickrSearchRemoteDataSource {
        return FlickrSearchRemoteDataSource(flickrService)
    }
}