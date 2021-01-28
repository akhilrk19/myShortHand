package com.example.myshorthand

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshorthand.adapter.CandidateRecyclerViewAdapater
import com.example.myshorthand.databinding.ActivityMainBindingImpl
import com.example.myshorthand.db.*
import com.example.myshorthand.view_model.CandidateViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.format.DateTimeFormatter
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
        candidateTransactionRepo =
            CandidateTransactionRepo(candidateDatabaseInstance.candidateTransactionDAO)
        binding.vmc = candidateViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
        addCandidateButtonListener()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        candidateRecyclerviewAdapter = CandidateRecyclerViewAdapater()
        binding.recyclerView.adapter = candidateRecyclerviewAdapter
        displayCandidateList()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun addCandidateButtonListener() {
        binding.addCandidate.setOnClickListener {
            addACandidate()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addACandidate() {
        val view = View.inflate(this, R.layout.dialog_layout, null)
        val name = view.findViewById<EditText>(R.id.candidate_name)
        val grade = view.findViewById<EditText>(R.id.candidate_grade)
        val subject = view.findViewById<EditText>(R.id.candidate_subject)
        val rate = view.findViewById<EditText>(R.id.rate_per_class)
        val register = view.findViewById<Button>(R.id.register)
        val dialogBox = AlertDialog.Builder(this)
        dialogBox.setView(view)
        val alert = dialogBox.create()

        register.setOnClickListener {
            GlobalScope.launch {
                candidateRepository.insert(
                    Candidate(
                        0,
                        name.text.trim().toString(), grade.text.trim().toString(),
                        subject.text.trim().toString(), rate.text.trim().toString().toFloat(),
                        DateTimeFormatter.ISO_INSTANT.format(Instant.now()))
                )
            }
            alert.cancel()
        }
        alert.show()

    }

    private fun displayCandidateList() {
        candidateViewModel.getCandidateList().observe(this, Observer {
            println("My Candidates: ${it}")
            it?.run {
                candidateRecyclerviewAdapter.setCandidateList(it)
                candidateRecyclerviewAdapter.notifyDataSetChanged()
            }
        })
    }

}