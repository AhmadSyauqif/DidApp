package com.pesan.todid.data.Respository

import androidx.lifecycle.LiveData
import com.pesan.todid.data.ToDoDao
import com.pesan.todid.data.model.TodoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData : LiveData<List<TodoData>> = toDoDao.getAllData()
    val sortByHighPriority : LiveData<List<TodoData>> = toDoDao.sortByHighPriority()
    val sortByLowPriority : LiveData<List<TodoData>> = toDoDao.sortByLowPriority()

    suspend fun insertData(todoData: TodoData){
        toDoDao.insertData(todoData)
    }
    suspend fun updateData (todoData: TodoData){
        toDoDao.updateData(todoData)
    }
    suspend fun deleteData(toDoData: TodoData) {
        toDoDao.deleteData(toDoData)
    }

    suspend fun deleteAllData(toDoData: TodoData) {
        toDoDao.deleteAllData()
    }
}