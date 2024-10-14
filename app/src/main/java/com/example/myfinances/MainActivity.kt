package com.example.myfinances

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfinances.data.CDEntity
import com.example.myfinances.data.CheckingAccountEntity
import com.example.myfinances.data.LoanEntity
import com.example.myfinances.data.FinancialViewModel // Updated package name to lowercase

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: FinancialViewModel

    override fun onCreate(savedInstanceState: Bundle?) { // Ensure you are using the correct parameters
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(FinancialViewModel::class.java)

        setContent {
            MyFinancesScreen(viewModel)
        }
    }
}


@Composable
fun MyFinancesScreen(viewModel: FinancialViewModel) {
    var selectedAccountType by remember { mutableStateOf("CD") }
    var accountNumber by remember { mutableStateOf("") }
    var initialBalance by remember { mutableStateOf("") }
    var currentBalance by remember { mutableStateOf("") }
    var interestRate by remember { mutableStateOf("") }
    var paymentAmount by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text("Select Account Type:")
        Row {
            RadioButton(
                selected = selectedAccountType == "CD",
                onClick = { selectedAccountType = "CD" }
            )
            Text("CD")
            RadioButton(
                selected = selectedAccountType == "Loan",
                onClick = { selectedAccountType = "Loan" }
            )
            Text("Loan")
            RadioButton(
                selected = selectedAccountType == "Checking",
                onClick = { selectedAccountType = "Checking" }
            )
            Text("Checking")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = accountNumber,
            onValueChange = { accountNumber = it },
            label = { Text("Account Number") }
        )

        if (selectedAccountType == "CD" || selectedAccountType == "Loan") {
            TextField(
                value = initialBalance,
                onValueChange = { initialBalance = it },
                label = { Text("Initial Balance") }
            )
            TextField(
                value = currentBalance,
                onValueChange = { currentBalance = it },
                label = { Text("Current Balance") }
            )
            TextField(
                value = interestRate,
                onValueChange = { interestRate = it },
                label = { Text("Interest Rate") }
            )
        }

        if (selectedAccountType == "Loan") {
            TextField(
                value = paymentAmount,
                onValueChange = { paymentAmount = it },
                label = { Text("Payment Amount") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            when (selectedAccountType) {
                "CD" -> {
                    viewModel.insertCD(
                        CDEntity(
                            accountNumber = accountNumber,
                            initialBalance = initialBalance.toDoubleOrNull() ?: 0.0,
                            currentBalance = currentBalance.toDoubleOrNull() ?: 0.0,
                            interestRate = interestRate.toDoubleOrNull() ?: 0.0
                        )
                    )
                }
                "Loan" -> {
                    viewModel.insertLoan(
                        LoanEntity(
                            accountNumber = accountNumber,
                            initialBalance = initialBalance.toDoubleOrNull() ?: 0.0,
                            currentBalance = currentBalance.toDoubleOrNull() ?: 0.0,
                            paymentAmount = paymentAmount.toDoubleOrNull() ?: 0.0,
                            interestRate = interestRate.toDoubleOrNull() ?: 0.0
                        )
                    )
                }
                "Checking" -> {
                    viewModel.insertCheckingAccount(
                        CheckingAccountEntity(
                            accountNumber = accountNumber,
                            currentBalance = currentBalance.toDoubleOrNull() ?: 0.0
                        )
                    )
                }
            }

            // Clear fields and show saved message
            accountNumber = ""
            initialBalance = ""
            currentBalance = ""
            interestRate = ""
            paymentAmount = ""
            showMessage = true
            messageText = "Data saved successfully!"
        }) {
            Text("Save")
        }

        Button(onClick = {
            // Clear fields without saving
            accountNumber = ""
            initialBalance = ""
            currentBalance = ""
            interestRate = ""
            paymentAmount = ""
            showMessage = false
        }) {
            Text("Cancel")
        }

        // Display saved message
        if (showMessage) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = messageText, color = MaterialTheme.colorScheme.primary)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyFinancesScreen() {

    val viewModel = FinancialViewMdl()

    MyFinancesScreen(viewModel)
}


class FinancialViewMdl : FinancialViewModel() {
    override fun insertCD(cd: CDEntity) {
    }

    override fun insertLoan(loan: LoanEntity) {
    }

    override fun insertCheckingAccount(account: CheckingAccountEntity) {
    }
}
