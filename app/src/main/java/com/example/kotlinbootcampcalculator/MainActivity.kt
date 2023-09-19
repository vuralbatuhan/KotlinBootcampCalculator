package com.example.kotlinbootcampcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.kotlinbootcampcalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        calculator = binding.editTextText

        setKeyButtonListeners(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
        )

        binding.buttonAC.setOnClickListener {
            binding.editTextText.setText("0")
        }
        setPlusButtonListener(binding.buttonPlus)
        setEqualsButtonListener(binding.buttonEsittir)

    }

    private fun setKeyButtonListeners(vararg buttons: Button) {
        buttons.forEach { button ->
            button.setOnClickListener {

                val newText = if (calculator.text.toString() == "0") {
                    button.text
                } else {
                    calculator.text.toString().plus(button.text)
                }

                calculator.text = newText

            }
        }

    }


    private fun setPlusButtonListener(buttonPlus: Button) {
        buttonPlus.setOnClickListener {

            calculator.text = calculator.text.toString().plus("+")

        }
    }

    private fun setEqualsButtonListener(buttonEsittir: Button) {
        buttonEsittir.setOnClickListener {

            val result = ExpressionBuilder(calculator.text.toString()).build().evaluate().toInt()

            calculator.text =result.toString()
        }
    }



}