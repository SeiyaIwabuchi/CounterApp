package com.example.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        var countLimit : Long = 0
        var countLoop : Boolean = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSize = 25f

        var btnCount = findViewById<Button>(R.id.btnCount)
        var textCountNum = findViewById<TextView>(R.id.textCountNum)
        var btnReset = findViewById<Button>(R.id.btnReset)
        var btnSetting = findViewById<Button>(R.id.btnSetting)

        var intent = Intent(this,SubActivity::class.java)

        //setContentView(R.layout.activity_main)
        //こいつを書くと画面更新ができなくなる

        var count: Long = 0

        btnCount.setOnClickListener {
            Log.d("btnCount","Clicked")
            Log.d("btnCount", countLimit.toString())
            count++
            if (count > countLimit && countLoop && 0.toLong() != countLimit){
                count = 0
            }else if(count > countLimit && !countLoop && 0.toLong() != countLimit){
                count = countLimit
            }
            textCountNum.setText(count.toString())
        }
        btnReset.setOnClickListener {
            Log.d("btnReset","Clicked")
            count = 0
            textCountNum.setText(count.toString())
        }
        btnSetting.setOnClickListener {
            Log.d("btnSetting","Clicked")
            startActivity(intent)
        }
    }
}
