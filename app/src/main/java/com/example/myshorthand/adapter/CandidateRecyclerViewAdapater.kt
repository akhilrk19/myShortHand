package com.example.myshorthand.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myshorthand.R
import com.example.myshorthand.databinding.CandidateViewBindingImpl
import com.example.myshorthand.db.Candidate


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
        holder.bind(mCandidateList[position])

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
        candidateViewBinding.totalClasses.text = "Amount to be paid: Rs.${7 * 300}"
        candidateViewBinding.addSession.setOnClickListener {
        }
    }

}