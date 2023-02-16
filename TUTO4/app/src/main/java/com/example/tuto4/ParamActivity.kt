package com.example.tuto4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class ParamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)

        val selectionDecalage = findViewById<SeekBar>(R.id.param_selection_decalage)
        selectionDecalage.max = 26
        selectionDecalage.progress = intent.getIntExtra("decalage", 0)
        val affichageDecalage = findViewById<TextView>(R.id.param_affichage_decalage)
        affichageDecalage.text = intent.getIntExtra("decalage", 0).toString()

        selectionDecalage.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                affichageDecalage.text = p1.toString()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        val boutonOk = findViewById<Button>(R.id.param_bouton_ok)
        boutonOk.setOnClickListener {
            intent.putExtra("decalage", selectionDecalage.progress)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}