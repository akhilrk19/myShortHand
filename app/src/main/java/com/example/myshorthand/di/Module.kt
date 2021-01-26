package com.example.myshorthand.di

import android.content.Context
import androidx.room.Room
import com.example.myshorthand.db.CandidateDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class Module {
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): CandidateDatabase {
        return Room.databaseBuilder(context.applicationContext,
            CandidateDatabase::class.java, "CANDIDATE_DATABASE").build()
    }
}