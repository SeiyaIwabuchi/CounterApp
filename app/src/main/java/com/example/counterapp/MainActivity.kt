package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSize = 25f

        var btnCount = findViewById<Button>(R.id.btnCount)
        var textCountNum = findViewById<TextView>(R.id.textCountNum)
        var btnReset = findViewById<Button>(R.id.btnReset)

        textCountNum.textSize = textSize * 2
        btnCount.textSize = textSize
        btnReset.textSize = textSize

        //setContentView(R.layout.activity_main)
        //こいつを書くと画面更新ができなくなる

        var count: Long = 0

        btnCount.setOnClickListener {
            Log.d("btnCount","Clicked")
            count++
            textCountNum.setText(count.toString())
        }
        btnReset.setOnClickListener {
            Log.d("btnReset","Clicked")
            count = 0
            textCountNum.setText(count.toString())
        }

    }
}
