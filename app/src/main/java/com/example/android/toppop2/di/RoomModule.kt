package com.example.android.toppop2.di

import android.content.Context
import androidx.room.Room
import com.example.android.toppop2.common.Const
import com.example.android.toppop2.data.room.TopPopDatabase
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
        return Room.databaseBuilder(
            context,
            TopPopDatabase::class.java,
            Const.Database.DB_NAME
        ).build()
    }
}