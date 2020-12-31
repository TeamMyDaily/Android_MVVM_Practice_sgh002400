package org.techtown.mvvm_practice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val todoRepository = TodoRepository(application)
    private val todoItem : LiveData<List<Todo>> = todoRepository.getAll()

    fun getAll() : LiveData<List<Todo>> {
        return this.todoItem
    }

    fun insert(item : Todo) {
        todoRepository.insert(item)
    }
}