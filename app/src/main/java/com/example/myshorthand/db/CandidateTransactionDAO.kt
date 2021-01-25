package com.example.myshorthand.db

import androidx.lifecycle.LiveData
import androidx.room.*

interface CandidateTransactionDAO {
    @Insert
    suspend fun insertClassSession(candidateTransaction: CandidateTransaction): Long

    @Update
    suspend fun updateClassSession(candidateTransaction: CandidateTransaction)

    @Delete
    suspend fun deleteClassSession(candidateTransaction: CandidateTransaction)
}