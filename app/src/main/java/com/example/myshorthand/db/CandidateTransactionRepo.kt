package com.example.myshorthand.db

class CandidateTransactionRepo (private val candidateTransactionDAO: CandidateTransactionDAO) {
//    val candidates = candidateDAO.getAllCandidates()

    suspend fun insert(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.insertClassSession(candidateTransaction)
    }
    suspend fun update(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.updateClassSession(candidateTransaction)
    }
    suspend fun delete(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.deleteClassSession(candidateTransaction)
    }
}