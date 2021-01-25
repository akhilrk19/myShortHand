package com.example.myshorthand.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidate_register")
data class Candidate(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "candidate_id")
    val id: Int,

    @ColumnInfo(name = "candidate_name")
    val name: String,

    @ColumnInfo(name = "candidate_grade")
    val gradeClass: String

)