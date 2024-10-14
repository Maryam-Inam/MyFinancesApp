package com.example.myfinances.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cds")
data class CDEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val accountNumber: String,
    val initialBalance: Double,
    val currentBalance: Double,
    val interestRate: Double
)
