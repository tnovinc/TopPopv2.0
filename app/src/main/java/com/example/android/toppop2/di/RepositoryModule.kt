package com.example.android.toppop2.di

import com.example.android.toppop2.data.repository.Repository
import com.example.android.toppop2.data.retrofit.RetrofitService
import com.example.android.toppop2.data.room.TopPopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule{

    @Singleton
    @Provides
    fun provideRepository(
        retrofit: RetrofitService,
        database: TopPopDatabase
    ): Repository{
        return Repository(retrofit, database)
    }

}