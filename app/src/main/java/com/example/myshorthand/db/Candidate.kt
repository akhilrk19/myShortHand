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
    val gradeClass: String,

    @ColumnInfo(name= "candidate_subject")
    val subject: String,

    @ColumnInfo(name = "rate_per_class")
    val tution_fee: Float,

    @ColumnInfo(name = "registration_date")
    val registration_date: String

)
