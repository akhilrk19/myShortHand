package com.example.myshorthand.view_model

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshorthand.db.CandidateRepo
import com.example.myshorthand.db.CandidateTransactionRepo

class CandidateViewModel() : ViewModel(),Observable {
//    val candidates = candidateRepo.candidates
    var inputCandidateName = MutableLiveData<String>()
    var inputCandidateGrade = MutableLiveData<String>()
    var inputCandidateSubject = MutableLiveData<String>()
    var inputCandidateRatePerClass = MutableLiveData<Int>()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}