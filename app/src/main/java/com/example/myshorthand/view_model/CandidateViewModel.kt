package com.example.myshorthand.view_model

import androidx.databinding.Observable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshorthand.db.Candidate
import com.example.myshorthand.db.CandidateDatabase
import com.example.myshorthand.db.JoinedDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

val sdf = SimpleDateFormat("dd/M/yyyy")
val currentDate = sdf.format(Date())
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

    fun insertCandidate(name: String, grade: String,
    subject: String, rate: String) {
        GlobalScope.launch {
            candidateDatabase.candidateDAO.insertCandidate(
                    Candidate(
                            0,
                            name.trim(), grade.trim(),
                            subject.trim(), rate.trim().toFloat(),
                            currentDate)
            )
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}