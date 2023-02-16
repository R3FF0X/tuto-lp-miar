package com.example.tuto5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val editText = findViewById<EditText>(R.id.todo_texte_desc)
        val interrupteur = findViewById<Switch>(R.id.todo_interrupteur)
        val btOk = findViewById<Button>(R.id.todo_bt_ok)
        btOk.isEnabled = false

        editText.setText(intent.getParcelableExtra<Todo>("todo")?.title)
        interrupteur.isChecked = intent.getParcelableExtra<Todo>("todo")?.completed ?: false

        editText.addTextChangedListener {
            btOk.isEnabled = it.toString().isNotEmpty()
        }

        interrupteur.setOnCheckedChangeListener { _, isChecked ->
            btOk.isEnabled = isChecked && editText.text.isNotEmpty()
        }

        btOk.setOnClickListener {
            val todo = Todo(
                editText.text.toString(),
                interrupteur.isChecked
            )
            val intent = intent
            intent.putExtra("todo", todo)
            intent.putExtra("position", intent.getIntExtra("position", -1))
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}