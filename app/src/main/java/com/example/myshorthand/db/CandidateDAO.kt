package com.example.myshorthand.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CandidateDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCandidate(candidate: Candidate): Long

    @Update
    suspend fun updateCandidate(candidate: Candidate)

    @Delete
    suspend fun deleteCandidate(candidate: Candidate)

    @Query("DELETE FROM candidate_register")
    suspend fun deleteAllCandidates()

    @Query("SELECT * FROM candidate_register")
    fun getAllCandidates(): LiveData<List<Candidate>>
}