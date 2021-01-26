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
import com.example.myshorthand.db.CandidateDatabase
import com.example.myshorthand.db.CandidateRepo
import com.example.myshorthand.db.CandidateTransactionRepo
import com.example.myshorthand.view_model.CandidateViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBindingImpl
    private val candidateViewModel by viewModels<CandidateViewModel>()
    private lateinit var candidateRecyclerviewAdapter: CandidateRecyclerViewAdapater
    private lateinit var candidateRepository: CandidateRepo
    private lateinit var candidateTransactionRepo: CandidateTransactionRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val candidateDAO = CandidateDatabase.getInstance(application).candidateDAO
        val candidateTransactionDAO =  CandidateDatabase.getInstance(application).candidateTransactionDAO
        candidateRepository = CandidateRepo(candidateDAO)
        candidateTransactionRepo = CandidateTransactionRepo(candidateTransactionDAO)
        binding.vmc = candidateViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        candidateRecyclerviewAdapter = CandidateRecyclerViewAdapater()
        binding.recyclerView.adapter = candidateRecyclerviewAdapter
        displayCandidateList()
    }
    private fun displayCandidateList(){
        candidateViewModel.candidates.observe(this, Observer {
            Log.i("My Candidates: ",it.toString())
            candidateRecyclerviewAdapter.setCandidateList(it)
            candidateRecyclerviewAdapter.notifyDataSetChanged()
        })
    }
}