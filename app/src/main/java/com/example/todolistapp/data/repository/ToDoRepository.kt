package com.example.todolistapp.data.repository

import androidx.lifecycle.LiveData
import com.example.todolistapp.data.ToDoDao
import com.example.todolistapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }

}