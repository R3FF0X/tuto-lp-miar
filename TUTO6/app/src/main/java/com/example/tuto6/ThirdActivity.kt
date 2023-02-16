package com.example.tuto6

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val query = findViewById<EditText>(R.id.third_txt_query)
        query.setText("")
        val listview = findViewById<ListView>(R.id.third_listview)
        val adapter = ArrayAdapter<Compagny>(
            this,
            android.R.layout.simple_list_item_1,
            ArrayList<Compagny>()
        )
        listview.adapter = adapter


        val btPlus = findViewById<ImageButton>(R.id.third_bt_plus)
        btPlus.setOnClickListener {
            val strQuery = query.text.toString()
            val url = "https://autocomplete.clearbit.com/v1/companies/suggest?query="+ strQuery
            val queue = Volley.newRequestQueue(this)

            queue.add(StringRequest(
                Request.Method.GET, url,
                { response -> adapter.addAll(Json { ignoreUnknownKeys = true }.decodeFromString<List<Compagny>>(response))},
                { error -> println(error.message)}
            ))
        }

        listview.setOnItemClickListener { adapterView, view, position, l ->
            val intent = Intent(this, FourActivity::class.java)
            intent.putExtra("compagny", adapter.getItem(position))
            startActivity(intent)
        }

    }
}