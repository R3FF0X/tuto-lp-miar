package com.example.tuto6

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        val txtName = findViewById<TextView>(R.id.four_txt_name)
        val txtDomain = findViewById<TextView>(R.id.four_txt_domain)
        val logo = findViewById<ImageView>(R.id.four_img_logo)

        val company = intent.getParcelableExtra<Compagny>("compagny") as Compagny
        txtName.text = company.name
        txtDomain.text = company.domain
        Picasso.with(this).load(Uri.parse(company.logo)).into(logo)

        // TODO

    }
}