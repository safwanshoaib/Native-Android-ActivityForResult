package com.example.activityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val textInputEditText = findViewById<TextInputEditText>(R.id.TextInput)
        val submitButton = findViewById<Button>(R.id.BtnSecondAct2)

        submitButton.setOnClickListener {
            val inputText = textInputEditText.text.toString()
            if (inputText.isEmpty()) {
                textInputEditText.error = "This field cannot be empty"
            } else if (inputText.contains(" ")) {
                textInputEditText.error = "No spaces are allowed"
            } else {
                // Input is valid, proceed with your action
                val returnIntent = Intent()
                returnIntent.putExtra("inputKey", inputText)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }
        }
    }
}