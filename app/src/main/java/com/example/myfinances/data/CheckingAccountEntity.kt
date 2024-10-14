package com.example.myfinances.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checking_accounts")
data class CheckingAccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val accountNumber: String,
    val currentBalance: Double
)
