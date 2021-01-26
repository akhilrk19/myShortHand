package com.example.myshorthand

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshorthand.adapter.CandidateRecyclerViewAdapater
import com.example.myshorthand.databinding.ActivityMainBindingImpl
import com.example.myshorthand.db.Candidate
import com.example.myshorthand.db.CandidateDatabase
import com.example.myshorthand.db.CandidateRepo
import com.example.myshorthand.db.CandidateTransactionRepo
import com.example.myshorthand.view_model.CandidateViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBindingImpl
    private lateinit var candidateRecyclerviewAdapter: CandidateRecyclerViewAdapater
    private lateinit var candidateRepository: CandidateRepo
    private lateinit var candidateTransactionRepo: CandidateTransactionRepo
    @Inject
    lateinit var candidateDatabaseInstance: CandidateDatabase
    val candidateViewModel by viewModels<CandidateViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val candidateDatabaseInstance = CandidateDatabase.getInstance(application)
        candidateRepository = CandidateRepo(candidateDatabaseInstance.candidateDAO)
        candidateTransactionRepo = CandidateTransactionRepo(candidateDatabaseInstance.candidateTransactionDAO)
        binding.vmc = candidateViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        candidateRecyclerviewAdapter = CandidateRecyclerViewAdapater()
        binding.recyclerView.adapter = candidateRecyclerviewAdapter
        GlobalScope.launch {
            candidateRepository.deleteAllCandidates()
            candidateRepository.insert(Candidate(0,"Akhil","Btech","CS",300.0F))
            candidateRepository.insert(Candidate(0,"Akhil","Btech","CS",300.0F))
            candidateRepository.insert(Candidate(0,"Akhil","Btech","CS",300.0F))
            candidateRepository.insert(Candidate(0,"Akhil","Btech","CS",300.0F))
            candidateRepository.insert(Candidate(0,"Akhil","Btech","CS",300.0F))
        }
        displayCandidateList()
    }

    private fun displayCandidateList() {
         candidateViewModel.getCandidateList().observe(this, Observer {
             println("My Candidates: ${it}")
             candidateRecyclerviewAdapter.setCandidateList(it)
             candidateRecyclerviewAdapter.notifyDataSetChanged()
         })

    }
}