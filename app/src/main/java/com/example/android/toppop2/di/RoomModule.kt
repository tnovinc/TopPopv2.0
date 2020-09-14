package com.example.android.toppop2.di

import android.content.Context
import com.example.android.toppop2.data.room.TopPopDatabase
import com.example.android.toppop2.data.room.getDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context): TopPopDatabase{
        return getDatabase(context)
    }
}