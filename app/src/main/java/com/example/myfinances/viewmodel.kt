
package com.example.myfinances.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.myfinances.data.CDEntity
import com.example.myfinances.data.CheckingAccountEntity
import com.example.myfinances.data.LoanEntity

class FinancialViewModel : ViewModel() {

    // Simulating a repository
    private val repository = FinancialRepository()

    fun insertCD(cd: CDEntity) {
        viewModelScope.launch {
            repository.insertCD(cd)
        }
    }

    fun insertLoan(loan: LoanEntity) {
        viewModelScope.launch {
            repository.insertLoan(loan)
        }
    }

    fun insertCheckingAccount(checkingAccount: CheckingAccountEntity) {
        viewModelScope.launch {
            repository.insertCheckingAccount(checkingAccount)
        }
    }
}

// Dummy repository class
class FinancialRepository {
    fun insertCD(cd: CDEntity) {
        // Insert CD entity into the database (implementation not shown)
    }

    fun insertLoan(loan: LoanEntity) {
        // Insert Loan entity into the database (implementation not shown)
    }

    fun insertCheckingAccount(checkingAccount: CheckingAccountEntity) {
        // Insert CheckingAccount entity into the database (implementation not shown)
    }
}
