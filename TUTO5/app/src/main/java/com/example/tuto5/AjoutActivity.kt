package com.example.tuto5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AjoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajout)

        findViewById<Button>(R.id.ajout_bt_ok).setOnClickListener {
            intent.putExtra("todo", Todo(findViewById<EditText>(R.id.ajout_texte_desc).text.toString()))
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}