package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var mathOperation: TextView
    private lateinit var mathResult: TextView
    private lateinit var btnAc: TextView
    private lateinit var btnParenthesisStart: TextView
    private lateinit var btnParenthesisEnd: TextView
    private lateinit var btnDivide: TextView
    private lateinit var btnMultiply: TextView
    private lateinit var btnPlus: TextView
    private lateinit var btnMinus: TextView
    private lateinit var btnDot: TextView
    private lateinit var btnBack: TextView
    private lateinit var btnEquals: TextView

    private lateinit var btnNum0: TextView
    private lateinit var btnNum1: TextView
    private lateinit var btnNum2: TextView
    private lateinit var btnNum3: TextView
    private lateinit var btnNum4: TextView
    private lateinit var btnNum5: TextView
    private lateinit var btnNum6: TextView
    private lateinit var btnNum7: TextView
    private lateinit var btnNum8: TextView
    private lateinit var btnNum9: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_main)

        mathOperation = findViewById(R.id.math_operation)
        mathResult = findViewById(R.id.math_result)
        btnAc = findViewById(R.id.btn_ac)
        btnParenthesisStart = findViewById(R.id.btn_parenthesis_start)
        btnParenthesisEnd = findViewById(R.id.btn_parenthesis_end)
        btnDivide = findViewById(R.id.btn_divide)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnDot = findViewById(R.id.btn_dot)
        btnBack = findViewById(R.id.btn_back)
        btnEquals = findViewById(R.id.btn_equals)

        btnNum0 = findViewById(R.id.btn_num_0)
        btnNum1 = findViewById(R.id.btn_num_1)
        btnNum2 = findViewById(R.id.btn_num_2)
        btnNum3 = findViewById(R.id.btn_num_3)
        btnNum4 = findViewById(R.id.btn_num_4)
        btnNum5 = findViewById(R.id.btn_num_5)
        btnNum6 = findViewById(R.id.btn_num_6)
        btnNum7 = findViewById(R.id.btn_num_7)
        btnNum8 = findViewById(R.id.btn_num_8)
        btnNum9 = findViewById(R.id.btn_num_9)


        btnAc.setOnClickListener {
            mathOperation.text = ""
            mathResult.text = ""
        }
        btnParenthesisStart.setOnClickListener { setTextFields("(") }
        btnParenthesisEnd.setOnClickListener { setTextFields(")") }
        btnDivide.setOnClickListener { setTextFields("/") }
        btnMultiply.setOnClickListener { setTextFields("*") }
        btnPlus.setOnClickListener { setTextFields("+") }
        btnMinus.setOnClickListener { setTextFields("-") }
        btnDot.setOnClickListener { setTextFields(".") }
        btnBack.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty())
                mathOperation.text = str.substring(0, str.length - 1)

            mathResult.text = ""
        }
        btnEquals.setOnClickListener {
            try {
                if (mathOperation.text.toString() != "") {
                    val ex = ExpressionBuilder(mathOperation.text.toString()).build()

                    val result = ex.evaluate()

                    val longRes = result.toLong()
                    if (result == longRes.toDouble())
                        mathResult.text = longRes.toString()
                    else
                        mathResult.text = result.toString()
                }
            } catch (ex: Exception) {
                mathResult.text = "Ошибка"
            }
        }

        btnNum0.setOnClickListener { setTextFields("0") }
        btnNum1.setOnClickListener { setTextFields("1") }
        btnNum2.setOnClickListener { setTextFields("2") }
        btnNum3.setOnClickListener { setTextFields("3") }
        btnNum4.setOnClickListener { setTextFields("4") }
        btnNum5.setOnClickListener { setTextFields("5") }
        btnNum6.setOnClickListener { setTextFields("6") }
        btnNum7.setOnClickListener { setTextFields("7") }
        btnNum8.setOnClickListener { setTextFields("8") }
        btnNum9.setOnClickListener { setTextFields("9") }
    }

    fun setTextFields(str: String) {
        if (mathResult.text == "Ошибка") {
            mathOperation.text = ""
            mathResult.text = ""
        }
        if (mathResult.text != "") {
            mathOperation.text = mathResult.text
            mathResult.text = ""
        }
        mathOperation.append(str)
    }
}