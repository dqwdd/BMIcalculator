package com.fastcampus.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        //2번째 인자는 받아온 값인 height가 없는 경우를 대비한 기본값임

        val bmi = weight / (height / 100.0).pow(2.0)
        //height/100을 2배로 곱해주세요~

        val resultText = when {
            bmi >= 35.0 -> "고도비만"
            bmi >= 30.0 -> "중정도비만"
            bmi >= 25.0 -> "경도비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }//이렇게 쓰면 when에서 나온 결과값이 바로 resultText에 들어감

        val resultValueTextView = findViewById<TextView>(R.id.text_bmi_result)
        val resultStringTextView = findViewById<TextView>(R.id.text_result)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText

    }
}