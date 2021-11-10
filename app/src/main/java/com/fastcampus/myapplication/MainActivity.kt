package com.fastcampus.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val height_text: EditText 이대로 하면 에러남
        //코틀린은 널과 널이 아닌걸 구분하기 때문

        val heightEditText = findViewById<EditText>(R.id.edit_height)
        val weightEditText = findViewById<EditText>(R.id.edit_weight)
        val resultButton = findViewById<Button>(R.id.btn_result)

        resultButton.setOnClickListener {

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty())
            {
                Toast.makeText(this, "빈 칸을 채워주세요!", Toast.LENGTH_SHORT).show()
                //이 함수 자체가 예외처리니까 이 예외처리 한 코드 이후에는 실행이 안되어야 함(밑에 코드들 실행이 안되어야 함)
                //그래서 return 씀
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            val my_intent = Intent(this, ResultActivity::class.java)

            my_intent.putExtra("height", height)
            my_intent.putExtra("weight", weight)

            startActivity(my_intent)

        }

    }
}