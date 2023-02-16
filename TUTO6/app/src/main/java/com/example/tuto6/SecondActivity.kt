package com.example.tuto6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<ImageButton>(R.id.second_bt_suivant).setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        val txtJson = findViewById<EditText>(R.id.second_txt_json)
        txtJson.setText(initJsonTxt())
        val txtJsonArray = findViewById<EditText>(R.id.second_txt_json_array)
        txtJsonArray.setText(initJsonArrayTxt())

        val txtResultat = findViewById<EditText>(R.id.second_txt_resultat)
        txtResultat.isEnabled = false

        val btJson = findViewById<Button>(R.id.second_bt_json)
        btJson.setOnClickListener {
            val strJson = txtJson.text.toString()

            try {
                val compagnies =
                    Json { ignoreUnknownKeys = true }
                        .decodeFromString<Compagny>(strJson)
                txtResultat.setText(compagnies.toString())
            }
            catch(e : SerializationException) {
                txtResultat.setText(e.message)
            }
        }

        val btJsonArray = findViewById<Button>(R.id.second_bt_json_array)
        btJsonArray.setOnClickListener {
            val strJson = txtJsonArray.text.toString()

            try {
                val compagnies =
                    Json { ignoreUnknownKeys = true }
                        .decodeFromString<List<Compagny>>(strJson)
                txtResultat.setText(compagnies.toString())
            }
            catch(e : SerializationException) {
                txtResultat.setText(e.message)
            }
        }
    }
}

