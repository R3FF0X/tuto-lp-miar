package com.example.tuto5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var todoList: ArrayList<Todo>
    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoList = Todos.initTodolist()
        todoAdapter = TodoAdapter(this, todoList)

        val todoListView = findViewById<ListView>(R.id.main_lv_todo)
        todoListView.adapter = todoAdapter

        val registerPlus = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                if (it.data != null) {
                    todoAdapter.add(it.data!!.getParcelableExtra("todo") )
                }
            }
        }

        val btPlus = findViewById<ImageButton>(R.id.main_bt_plus)
        btPlus.setOnClickListener {
            val intent = Intent(this, AjoutActivity::class.java)
            registerPlus.launch(intent)
        }

        val btSort = findViewById<ImageButton>(R.id.main_bt_sort)
        btSort.setOnClickListener {
            todoAdapter.sort(Todos.COMPARATEUR)
        }

        val btDelete = findViewById<ImageButton>(R.id.main_bt_delete)
        btDelete.setOnClickListener {
            todoAdapter.clear()
        }

        val btLoad = findViewById<ImageButton>(R.id.main_bt_load)
        btLoad.setOnClickListener {
            todoAdapter.clear()
            todoAdapter.addAll(Todos.initTodolist())
        }


        val registerListView = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                if (it.data != null) {
                    val todo = it.data!!.getParcelableExtra<Todo>("todo")
                    val position = it.data!!.getIntExtra("position", -1)
                    todoAdapter.remove(todoAdapter.getItem(position))
                    todoAdapter.insert(todo, position)
                }
            }
        }

        // TODO todoListView <-> OnItemClick
        todoListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, TodoActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("todo", todoAdapter.getItem(position))
            registerListView.launch(intent)
        }

        // TODO todoListView <-> OnItemLongClick
        todoListView.setOnItemLongClickListener { parent, view, position, id ->
            todoAdapter.remove(todoAdapter.getItem(position))
            true
        }

        val btGrid = findViewById<ImageButton>(R.id.main_bt_grid)
        btGrid.setOnClickListener {
            val intent = Intent(this, GridActivity::class.java)
            intent.putExtra("todoList", todoList)
            startActivity(intent)
        }
    }
}
