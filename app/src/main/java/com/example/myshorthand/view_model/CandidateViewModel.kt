package com.example.myshorthand.view_model

import androidx.databinding.Observable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshorthand.db.Candidate
import com.example.myshorthand.db.CandidateDatabase

class CandidateViewModel @ViewModelInject constructor(
    val candidateDatabase: CandidateDatabase
) : ViewModel(), Observable {
    //    val candidates = candidateRepo.candidates
    var inputCandidateName = MutableLiveData<String>()
    var inputCandidateGrade = MutableLiveData<String>()
    var inputCandidateSubject = MutableLiveData<String>()
    var inputCandidateRatePerClass = MutableLiveData<Int>()

    fun getCandidateList(): LiveData<List<Candidate>> {
        return candidateDatabase.candidateDAO.getAllCandidates()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}