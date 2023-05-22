package com.rakamin.calculatorinduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rakamin.calculatorinduction.databinding.ActivityMainBinding
import com.rakamin.calculatorinduction.databinding.FragmentCalculateBinding
import com.rakamin.calculatorinduction.databinding.FragmentResultBinding

class MainActivity : AppCompatActivity(), CalculatorInterface {

    lateinit var resultBinding : FragmentResultBinding
    lateinit var calculateBinding: FragmentCalculateBinding
    lateinit var resultFragment: ResultFragment
    lateinit var calculateFragment: CalculateFragment
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        resultFragment = supportFragmentManager.findFragmentById(R.id.fragmentResult) as ResultFragment
        calculateFragment = supportFragmentManager.findFragmentById(R.id.fragmentCalculate) as CalculateFragment

        resultBinding = resultFragment.binding
        calculateBinding = calculateFragment.binding
    }

    override fun inputNumber(number : Int) {
        resultFragment.showResult(number.toString())
    }

    override fun inputOperator(operator: String) {
        resultFragment.showResult(operator)
    }

    override fun clearAll() {
        resultFragment.clearText()
    }

    override fun calculateNow() {
        resultFragment.calculate()
    }
}