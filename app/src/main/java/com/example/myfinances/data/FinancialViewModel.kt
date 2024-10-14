package com.example.myfinances.data


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinances.ViewModel.FinancialRepository
import kotlinx.coroutines.launch

open class FinancialViewModel : ViewModel() {

    // Replace with your actual database or repository
    private val repository: FinancialRepository = FinancialRepository()

    open fun insertCD(cd: CDEntity) {
        viewModelScope.launch {
            repository.insertCD(cd)
        }
    }

    open fun insertLoan(loan: LoanEntity) {
        viewModelScope.launch {
            repository.insertLoan(loan)
        }
    }

    open fun insertCheckingAccount(account: CheckingAccountEntity) {
        viewModelScope.launch {
            repository.insertCheckingAccount(account)
        }
    }
}
