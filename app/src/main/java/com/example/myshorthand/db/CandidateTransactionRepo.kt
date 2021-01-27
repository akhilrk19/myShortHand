package com.example.myshorthand.db

class CandidateTransactionRepo (private val candidateTransactionDAO: CandidateTransactionDAO) {

    suspend fun insert(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.insertNewTransaction(candidateTransaction)
    }
}