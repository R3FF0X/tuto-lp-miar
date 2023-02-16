package com.example.tuto4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var decalage = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texteOriginal = findViewById<EditText>(R.id.main_texte_original)
        texteOriginal.setText("")

        val affichageDecalage = findViewById<TextView>(R.id.main_affichage_decalage)
        affichageDecalage.text = decalage.toString()

        var boutonChiffrement = findViewById<Button>(R.id.main_bouton_chiffrement)

        val register = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                if (it.data != null) {
                    decalage = it.data!!.getIntExtra("decalage", 0)
                    affichageDecalage.text = decalage.toString()
                }
            }
        }

        boutonChiffrement.setOnClickListener {

            val intentParam = Intent(this, resultActivity::class.java)
            intentParam.putExtra("textOriginal", texteOriginal.text.toString())
            intentParam.putExtra("decalage", decalage)
            startActivity(intentParam)
        }

        var boutonParam = findViewById<Button>(R.id.main_bouton_param)
        boutonParam.setOnClickListener {

            val intentParam = Intent(this, ParamActivity::class.java)
            intentParam.putExtra("decalage", decalage)
            register.launch(intentParam)
        }
    }
}