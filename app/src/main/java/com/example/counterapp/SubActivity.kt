package com.example.counterapp

import android.text.Editable
import com.example.counterapp.R
import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var edCountLimit : EditText = findViewById(R.id.editTextCountLimit)
        var swLoopEnable : Switch = findViewById(R.id.swLoopEnable)

        edCountLimit.setText(MainActivity.countLimit.toString())
        swLoopEnable.isChecked = MainActivity.countLoop

        edCountLimit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    MainActivity.countLimit = edCountLimit.text.toString().toLong()
                    Log.d("afterTextChanged",p0.toString().toLong().toString())
                }catch (e : Exception){
                    //特にない
                }
                if(MainActivity.countLimit == 0.toLong()){
                    swLoopEnable.isChecked = false
                }
            }
        })
        swLoopEnable.setOnCheckedChangeListener { compoundButton, b ->
            if(MainActivity.countLimit > 0) {
                MainActivity.countLoop = b
            }else{
                MainActivity.countLoop = false
                swLoopEnable.isChecked = false
            }
        }
    }
}