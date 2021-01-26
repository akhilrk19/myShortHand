package com.example.myshorthand.db

import androidx.lifecycle.LiveData
import androidx.room.*

interface CandidateTransactionDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewTransaction(candidateTransaction: CandidateTransaction): Long

    @Update
    suspend fun updateTransaction(candidateTransaction: CandidateTransaction)

    @Delete
    suspend fun deleteTransaction(candidateTransaction: CandidateTransaction)
}