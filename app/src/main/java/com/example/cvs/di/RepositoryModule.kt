package com.example.cvs.di

import com.example.cvs.data.local.datasource.FlickrSearchLocalDataSource
import com.example.cvs.data.remote.datasource.FlickrSearchRemoteDataSource
import com.example.cvs.data.repository.FlickrRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesFlickRepository(
        localDataSource: FlickrSearchLocalDataSource,
        remoteDataSource: FlickrSearchRemoteDataSource
    ): FlickrRepository {
        return FlickrRepository(localDataSource, remoteDataSource)
    }
}