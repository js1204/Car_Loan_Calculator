package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //Getting input data from the user
        val carPrice = editTextCarPrice.text.toString().toInt()
        val downPayement = editTextDownPayment.text.toString().toInt()
        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRate = editTextInterestRate.text.toString().toFloat()

        val carLoan = carPrice - downPayement
        val interest = carLoan * interestRate *loanPeriod
        val monthlyRepayment = (carLoan+interest)/loanPeriod/12

        textViewCarLoan.text = ":${carLoan}"
        //val textViewCarLoan: TextView = findViewById(R.id.textViewCarLoan)

        textViewInterest.text = getString(R.string.interest)+":${interest}"
        //val textViewInterest:TextView = findViewById(R.id.textViewInterest)

        textViewMonthlyPayment.text = getString(R.string.monthly_repayment)+":${monthlyRepayment}"
        //val monthlyPayment : TextView = findViewById(R.id.textViewMonthlyPayment)





    }

     fun resetInput(view : View){
            editTextCarPrice.text = null
            editTextDownPayment.text =null
            editTextInterestRate.text =null
            editTextLoanPeriod.text = null

            textViewCarLoan.text =  getString(R.string.car_loan)
            textViewMonthlyPayment.text =  getString(R.string.monthly_repayment)
            textViewInterest.text = getString(R.string.interest)

        }


}
