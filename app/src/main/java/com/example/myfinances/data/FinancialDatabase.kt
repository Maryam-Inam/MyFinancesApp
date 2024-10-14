package com.example.myfinances.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CDEntity::class, LoanEntity::class, CheckingAccountEntity::class], version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun financialDao(): FinancialDao
}
