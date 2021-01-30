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

    @Query("SELECT candidate_register.candidate_id as id, " +
            "candidate_name as name, candidate_subject as subject, " +
            "candidate_register.candidate_grade as gradeClass, count(class_count) as total_class, rate_per_class, rate_per_class * " +
            "count(class_count) as amount_to_pay FROM candidate_register, " +
            "candidate_transaction where candidate_register.candidate_id = candidate_transaction.candidate_id " +
            "and transaction_date= :month")
    fun getAllCandidates(month: String): LiveData<List<JoinedDatabase>>
}