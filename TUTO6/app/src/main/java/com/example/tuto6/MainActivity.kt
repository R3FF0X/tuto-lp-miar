package com.example.tuto6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.main_bt_suivant).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        val txtImg = findViewById<EditText>(R.id.main_txt_url_img)
        txtImg.setText("https://images.punkapi.com/v2/42.png")
        val btImg = findViewById<Button>(R.id.main_bt_img)
        val img = findViewById<ImageView>(R.id.main_img)

        btImg.setOnClickListener {
            // TODO
            val urlImg = Uri.parse(txtImg.text.toString())
            Picasso.with(this).load(urlImg).into(img)
        }

        val txtGet = findViewById<EditText>(R.id.main_txt_url_get)
        txtGet.setText("https://www.perdu.com")
        val btGet = findViewById<Button>(R.id.main_bt_get)
        val txtResultat = findViewById<TextView>(R.id.main_txt_resultat)

        val queue = Volley.newRequestQueue(this)

        btGet.setOnClickListener {
            val urlGet = Uri.parse(txtGet.text.toString()).toString()
            queue.add(StringRequest(Request.Method.GET, urlGet,
                { response -> txtResultat.text = response},
                { error -> println(error.message)}
            ))
            txtResultat.text = "Url loading"
        }
    }
}