package com.frank.practicehilt.di

import android.content.Context
import androidx.room.Room
import com.frank.practicehilt.data.database.AppDB
import com.frank.practicehilt.data.database.question.QuestionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton // khoi tao 1 cai cho ca ung dung
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDB {
        return Room.databaseBuilder(appContext, AppDB::class.java, "app_db").build()
    }

    @Singleton
    @Provides
    fun provideQuestionDao(appDB: AppDB) : QuestionDao {
        return appDB.questionDao()
    }
}