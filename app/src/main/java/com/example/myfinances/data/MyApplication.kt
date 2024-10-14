package com.example.myfinances

import android.app.Application
import androidx.room.Room
import com.example.myfinances.data.FinancialDatabase

class MyApplication : Application() {
    lateinit var database: FinancialDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            FinancialDatabase::class.java,
            "financial_database"
        ).build()
    }
}
