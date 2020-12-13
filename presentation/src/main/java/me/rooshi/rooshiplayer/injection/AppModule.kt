package me.rooshi.rooshiplayer.injection

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.rooshi.data.manager.PermissionManagerImpl
import me.rooshi.domain.manager.PermissionManager
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providePermissionManager(managerImpl: PermissionManagerImpl): PermissionManager = managerImpl
}