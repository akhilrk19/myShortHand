package com.example.myshorthand.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "candidate_transaction")
data class CandidateTransaction(
    @ColumnInfo(name = "candidate_id")
    val candidate_id: Int,
    @ColumnInfo(name = "month")
    val month: String,
    @ColumnInfo(name = "class_count")
    val classCount: Int
)