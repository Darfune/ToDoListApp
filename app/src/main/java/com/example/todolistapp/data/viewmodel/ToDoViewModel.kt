package com.example.todolistapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.ToDoDatabase
import com.example.todolistapp.data.models.ToDoData
import com.example.todolistapp.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel (application: Application): AndroidViewModel(application){

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository = ToDoRepository(toDoDao)

    val getAllData: LiveData<List<ToDoData>> = repository.getAllData


    fun insertData(toDoData: ToDoData){
        viewModelScope.launch { Dispatchers.IO }
    }

}