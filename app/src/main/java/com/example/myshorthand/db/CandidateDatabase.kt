package com.example.myshorthand.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Candidate::class, CandidateTransaction::class], version = 1, exportSchema = false)
abstract class CandidateDatabase: RoomDatabase() {

    abstract val candidateDAO: CandidateDAO
    abstract val candidateTransactionDAO: CandidateTransactionDAO
    /*companion object {
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
    }*/
}