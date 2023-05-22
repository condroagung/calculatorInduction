package com.rakamin.calculatorinduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import com.rakamin.calculatorinduction.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment() {
    lateinit var binding : FragmentCalculateBinding
    private lateinit var calculatorInterface: CalculatorInterface
    private var checkstate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calculatorInterface = activity as CalculatorInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button0.setOnClickListener {
            checkstate+=0
            calculatorInterface.inputNumber(0)
        }
        binding.button1.setOnClickListener {
            checkstate+=1
            calculatorInterface.inputNumber(1)
        }
        binding.button2.setOnClickListener {
            checkstate+=2
            calculatorInterface.inputNumber(2)
        }
        binding.button3.setOnClickListener {
            checkstate+=3
            calculatorInterface.inputNumber(3)
        }
        binding.button4.setOnClickListener {
            checkstate+=4
            calculatorInterface.inputNumber(4)
        }
        binding.button5.setOnClickListener {
            checkstate+=5
            calculatorInterface.inputNumber(5)
        }
        binding.button6.setOnClickListener {
            checkstate+=6
            calculatorInterface.inputNumber(6)
        }
        binding.button7.setOnClickListener {
            checkstate+=7
            calculatorInterface.inputNumber(7)
        }
        binding.button8.setOnClickListener {
            checkstate+=8
            calculatorInterface.inputNumber(8)
        }
        binding.button9.setOnClickListener {
            checkstate+=9
            calculatorInterface.inputNumber(9)
        }
        binding.buttonPlus.setOnClickListener {
            checkstate=""
            calculatorInterface.inputOperator("+")
        }
        binding.buttonSubstract.setOnClickListener {
            checkstate=""
            calculatorInterface.inputOperator("-")
        }
        binding.buttonMultiple.setOnClickListener {
            checkstate=""
            calculatorInterface.inputOperator("*")
        }
        binding.buttonDivide.setOnClickListener {
            checkstate=""
            calculatorInterface.inputOperator("/")
        }
        binding.buttonResult.setOnClickListener {
            calculatorInterface.calculateNow()
        }

        binding.buttonClear.setOnClickListener {
            calculatorInterface.clearAll()
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            CalculateFragment()
    }
}