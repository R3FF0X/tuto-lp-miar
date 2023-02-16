package com.example.tuto3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boutonEffacer = findViewById<Button>(R.id.main_bouton_effacer)
        val boutonChiffrement = findViewById<Button>(R.id.main_bouton_chiffrement)

        val textEditOriginal = findViewById<EditText>(R.id.main_texte_original)
        val textEditChiffre = findViewById<EditText>(R.id.main_texte_chiffre)
        val textDecalage = findViewById<TextView>(R.id.main_affichage_decalage)

        textEditOriginal.setText("")
        textEditChiffre.setText("")

        //textEditOriginal.isEnabled = false

        val seekBarDecalage = findViewById<SeekBar>(R.id.main_selection_decalage)
        seekBarDecalage.progress = 3
        seekBarDecalage.max = 26
        textDecalage.setText(seekBarDecalage.progress.toString())
        seekBarDecalage.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textDecalage.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        boutonEffacer.isEnabled = false // desactive le bouton "Effacer"
        boutonChiffrement.setOnClickListener {
            val textOriginal = textEditOriginal.text.toString()
            val decalage = seekBarDecalage.progress

            textEditChiffre.setText(ChiffreCesar.chiffrement(textOriginal, decalage))
            boutonEffacer.isEnabled = true
        }

        boutonEffacer.setOnClickListener{
            textEditOriginal.text.clear()
            textEditChiffre.text.clear()
            boutonEffacer.isEnabled = false
        }

    }
}