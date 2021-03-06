package com.example.myshorthand.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myshorthand.R
import com.example.myshorthand.databinding.CandidateViewBindingImpl
import com.example.myshorthand.db.Candidate
import java.util.*
import kotlin.collections.ArrayList



class CandidateRecyclerViewAdapater :
    RecyclerView.Adapter<CandidateViewHolder>() {
    var mCandidateList = ArrayList<Candidate>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CandidateViewBindingImpl =
            DataBindingUtil.inflate(layoutInflater, R.layout.candidate_view, parent, false)
        return CandidateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        val candidate = mCandidateList[position]
        holder.bind(candidate)
        holder.candidateViewBinding.addSession.setOnClickListener {
           /* GlobalScope.launch {
                    candidateDatabase.candidateTransactionDAO.insertNewTransaction(
                        CandidateTransaction(
                            0, candidate.id,
                            currentDate, 1
                        )
                    )
            }*/
        }
        var totalAmount: Float? = 0F
        var classCount: Int? = 0

//        holder.candidateViewBinding.totalClasses.text = "Amount to be paid: ${classCount} Classes, Rs.${totalAmount}"
    }

    override fun getItemCount(): Int {
        return mCandidateList.size
    }

    fun setCandidateList(candidateList: List<Candidate>) {
        this.mCandidateList.clear()
        this.mCandidateList.addAll(candidateList)
    }
}

class CandidateViewHolder(val candidateViewBinding: CandidateViewBindingImpl) :
    RecyclerView.ViewHolder(candidateViewBinding.root) {

    fun bind(candidate: Candidate) {
        candidateViewBinding.candidateName.text = "${candidate.name} (ID : ${candidate.id})"
        candidateViewBinding.candidateSubject.text = "${candidate.gradeClass}, ${candidate.subject}"
    }

}