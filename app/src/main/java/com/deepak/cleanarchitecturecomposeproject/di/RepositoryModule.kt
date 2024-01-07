package com.deepak.cleanarchitecturecomposeproject.di

import com.deepak.cleanarchitecturecomposeproject.data.remote.Service
import com.deepak.cleanarchitecturecomposeproject.data.repository.UsersRepositoryImpl
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
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
    fun provideUsersRepository(service: Service) : UsersRepository = UsersRepositoryImpl(service)
}