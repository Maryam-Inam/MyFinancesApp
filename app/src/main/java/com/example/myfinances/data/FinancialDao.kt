package com.example.myfinances.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FinancialDao {
    @Insert
    suspend fun insertCD(cd: CDEntity)

    @Insert
    suspend fun insertLoan(loan: LoanEntity)

    @Insert
    suspend fun insertCheckingAccount(account: CheckingAccountEntity)

    @Query("SELECT * FROM cds")
    suspend fun getAllCDs(): List<CDEntity>

    @Query("SELECT * FROM loans")
    suspend fun getAllLoans(): List<LoanEntity>

    @Query("SELECT * FROM checking_accounts")
    suspend fun getAllCheckingAccounts(): List<CheckingAccountEntity>
}
