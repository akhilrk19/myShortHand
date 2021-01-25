package com.example.myshorthand.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Candidate::class], version = 1)
abstract class CandidateDatabase: RoomDatabase() {

    abstract val candidateDAO: CandidateDAO
    companion object {
        @Volatile
        private var INSTANCE: CandidateDatabase? = null
        fun getInstance(context: Context): CandidateDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance==null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                    CandidateDatabase::class.java, "CANDIDATE_DATABASE").build()
                }
                return instance
            }
        }
    }
}