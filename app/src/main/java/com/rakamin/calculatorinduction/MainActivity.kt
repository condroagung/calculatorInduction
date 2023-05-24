package com.rakamin.calculatorinduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.rakamin.calculatorinduction.databinding.ActivityMainBinding
import com.rakamin.calculatorinduction.databinding.FragmentCalculateBinding
import com.rakamin.calculatorinduction.databinding.FragmentResultBinding
import com.rakamin.calculatorinduction.databinding.FragmentScienceCalculateBinding

class MainActivity : AppCompatActivity(), CalculatorInterface {

    lateinit var resultBinding : FragmentResultBinding
    lateinit var fragmentContainer : LinearLayout
    lateinit var calculateBinding: FragmentCalculateBinding
    lateinit var resultFragment: ResultFragment
    lateinit var calculateFragment: CalculateFragment
    lateinit var scienceCalculateFragment: ScienceCalculateFragment
    lateinit var scienceCalculateBinding: FragmentScienceCalculateBinding
    lateinit var mainBinding: ActivityMainBinding
    private var stateNow = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        resultFragment = supportFragmentManager.findFragmentById(R.id.fragmentResult) as ResultFragment
        fragmentContainer = findViewById(R.id.fragmentContainer)
        calculateFragment = CalculateFragment()
        scienceCalculateFragment = ScienceCalculateFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, calculateFragment)
            .commit()

        resultBinding = resultFragment.binding
    }

    fun switchFragment(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        val nextFragment = if (currentFragment is CalculateFragment) scienceCalculateFragment else calculateFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, nextFragment)
            .commit()
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