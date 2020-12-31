package org.techtown.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.mvvm_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        todoAdapter = TodoAdapter(this)
        rcv.layoutManager =LinearLayoutManager(this)

        todoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(TodoViewModel::class.java)
        todoViewModel.getAll().observe(this, Observer<List<Todo>> {
            todoAdapter.setTodoItem(it)
        })

        fab_add.setOnClickListener{
            val item = Todo(null, main_title.text.toString(), main_content.text.toString() )
            todoViewModel.insert(item)
        }

    }
}