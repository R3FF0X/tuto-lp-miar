package com.example.tuto5

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class TodoAdapter(
    context: Context,
    todos: MutableList<Todo>
) : ArrayAdapter<Todo>(context, 0, todos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.listview_todo, parent, false)

        val todo = getItem(position)
        if (todo != null) {
            view.findViewById<TextView>(R.id.listview_titre).text = todo.title
            view.findViewById<CheckBox>(R.id.chkboxCompleted).isChecked = todo.completed
        }
        return view
    }
}