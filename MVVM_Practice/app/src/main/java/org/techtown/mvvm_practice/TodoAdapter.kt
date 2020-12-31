package org.techtown.mvvm_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val context : Context) : RecyclerView.Adapter<TodoViewHolder>() {
    var data = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(data[position])
    }


    override fun getItemCount(): Int = data.size

    fun setTodoItem(todolist: List<Todo>) {
        data = todolist.toMutableList()
        notifyDataSetChanged()
    }
}