package com.example.myshorthand.db

import androidx.room.*

@Dao
interface CandidateTransactionDAO {
    @Insert
    suspend fun insertNewTransaction(candidateTransaction: CandidateTransaction): Long

    @Query("select SUM(class_count) from candidate_transaction where transaction_date= :tDate")
    suspend fun getTransactionCount(tDate: String): Int
}