package com.frank.practicehilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatcherModule {
    @Provides
    @IODispatcher
    fun providerIODispatcher(): CoroutineDispatcher  = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun providerMainDispatcher(): CoroutineDispatcher  = Dispatchers.Main

    @Provides
    @DefaultDispatcher
    fun providerDefaultDispatcher(): CoroutineDispatcher  = Dispatchers.Default
}
