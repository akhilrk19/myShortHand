package com.example.myshorthand.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidate_transaction")
data class CandidateTransaction(
    @ColumnInfo(name = "txn_id")
    @PrimaryKey(autoGenerate = true)
    val transaction_id: Int,
    @ColumnInfo(name = "candidate_id")
    val candidate_id: Int,
    @ColumnInfo(name = "month")
    val month: String,
    @ColumnInfo(name = "class_count")
    val classCount: Int
)