package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name:TextView=findViewById(R.id.tv_name)
        val tv_score:TextView=findViewById(R.id.score)
        val btn_finish:Button=findViewById(R.id.btn_finish)
        tv_name.text=intent.getStringExtra(Constants.USER_NAME)
        tv_score.text="Your score is ${intent.getIntExtra(Constants.CORRECT_ANS,0)} out of ${intent.getIntExtra(Constants.TOTAL_QUE,0)}"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}