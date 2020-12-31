package org.techtown.mvvm_practice

import android.app.Application
import androidx.lifecycle.LiveData

class TodoRepository(application: Application) {
    private var todoDB : TodoDB = TodoDB.getInstance(application)!!
    private var todoDao : TodoDao = todoDB.todoDao()
    private var todoItem : LiveData<List<Todo>> = todoDao.getAll()

    fun getAll() : LiveData<List<Todo>> {
        return todoItem
    }

    fun insert(item : Todo) {
        Thread(Runnable {
            todoDao.insert(item)
        }).start()
    }
}

