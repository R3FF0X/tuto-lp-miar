package com.example.tuto4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val texteChiffre = findViewById<EditText>(R.id.result_texte_chiffre)
        texteChiffre.setText(ChiffreCesar.chiffrement(intent.getStringExtra("textOriginal"), intent.getIntExtra("decalage", 0)))

        val boutonEnvoi = findViewById<Button>(R.id.result_bouton_envoi)
        boutonEnvoi.setOnClickListener {
            val sendMsg = Intent(Intent.ACTION_SEND)
            sendMsg.type = "text/plain"
            sendMsg.putExtra(Intent.EXTRA_TEXT, texteChiffre.text.toString())
            startActivity(sendMsg)
        }
    }
}