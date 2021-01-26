package com.example.myshorthand.db

class CandidateTransactionRepo (private val candidateTransactionDAO: CandidateTransactionDAO) {

    suspend fun insert(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.insertNewTransaction(candidateTransaction)
    }
    suspend fun update(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.updateTransaction(candidateTransaction)
    }
    suspend fun delete(candidateTransaction: CandidateTransaction) {
        candidateTransactionDAO.deleteTransaction(candidateTransaction)
    }
}