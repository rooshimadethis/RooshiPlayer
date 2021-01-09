package me.rooshi.rooshiplayer.injection

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.rooshi.data.repository.MediaStorageRepositoryImpl
import me.rooshi.domain.repository.MediaStorageRepository
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMediaStorageRepository(mediaStorageRepositoryImpl: MediaStorageRepositoryImpl) : MediaStorageRepository
}