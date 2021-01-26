package com.example.myshorthand.db

class CandidateRepo (private val candidateDAO: CandidateDAO) {
  val candidates = candidateDAO.getAllCandidates()

    suspend fun insert(candidate: Candidate) {
        candidateDAO.insertCandidate(candidate)
    }
    suspend fun update(candidate: Candidate) {
        candidateDAO.updateCandidate(candidate)
    }
    suspend fun delete(candidate: Candidate) {
        candidateDAO.deleteCandidate(candidate)
    }
    suspend fun deleteAllCandidates() {
        candidateDAO.deleteAllCandidates()
    }
}