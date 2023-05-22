package com.rakamin.calculatorinduction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.rakamin.calculatorinduction.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    lateinit var binding : FragmentResultBinding
    var result = ""
    var listAll = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun showResult(result : String){
        this.result += result
        binding.textResult.text = this.result
        println(this.result)
        listAll.add(result)
        if(listAll.isEmpty()){
            Log.d("msg","kosong")
        }
        else{
            Log.d("msg","$listAll")
        }
    }

    fun clearText(){
        this.result = ""
        binding.textResult.text = this.result
        listAll = mutableListOf<String>()
        Log.d("msg","$listAll")
        Log.d("msg2","${this.result}")
    }

    fun calculate(){
        val results = separateString(this.result)
        println(results)
        var listNum = mutableListOf<Double>()
        var listOperator = mutableListOf<Char>()
        results.forEach{
            if (it.toString().isDigitsOnly()){
                listNum.add(it.toString().toDouble())
            }
            else{
                listOperator.add(it as Char)
            }
        }
        val resultCalculate = calculateValue(listNum,listOperator)
        println(resultCalculate)
        binding.textResult.text = resultCalculate.toString()
        }

    private fun calculateValue(numbers: List<Double>, operators: List<Char>): Double? {
        if (numbers.size != operators.size + 1) {
            // Invalid input: Number of numbers and operators mismatch
            return null
        }

        var result = numbers[0]

        for (i in 1 until numbers.size) {
            val operator = operators[i - 1]
            val number = numbers[i]

            when (operator) {
                '+' -> result += number
                '-' -> result -= number
                '*' -> result *= number
                '/' -> {
                    if (number != 0.0) {
                        result /= number
                    } else {
                        return null
                    }
                }
                else -> {
                    return null
                }
            }
        }

        return result
    }

    private fun separateString(input: String): List<Any> {
        val resultList = mutableListOf<Any>()
        var currentNumber = ""

        for (char in input) {
            if (char.isDigit()) {
                currentNumber += char
            } else {
                if (currentNumber.isNotEmpty()) {
                    currentNumber.toIntOrNull()?.let { resultList.add(it) }
                    currentNumber = ""
                }
                if (char in listOf('+', '-', '*', '/')) {
                    resultList.add(char)
                }
            }
        }

        if (currentNumber.isNotEmpty()) {
            currentNumber.toIntOrNull()?.let { resultList.add(it) }
        }

        return resultList
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ResultFragment()
    }
}