package com.example.tuto5

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        val gridView = findViewById<GridView>(R.id.grid_gridview)
        gridView.numColumns = 3

        val intentTodo = intent.getParcelableArrayListExtra<Todo>( "todoList")
        val todoAdapter = intentTodo?.let { TodoGridAdapter(this, it) }
        gridView.adapter = todoAdapter

    }
}