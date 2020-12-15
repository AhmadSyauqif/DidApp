package com.pesan.todid.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pesan.todid.data.model.TodoData

@Dao
interface ToDoDao {
    @Query("SELECT * FROM TODO_TABLE ORDER BY ID ASC")
    fun getAllData() : LiveData<List<TodoData>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: TodoData)

    @Update
    suspend fun updateData(toDoData: TodoData)

    @Delete
    suspend fun deleteData(toDoData: TodoData)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllData()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun SearchDatabase(searchQuery : String) : LiveData<List<TodoData>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 2 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE '%L' THEN 3 END")
    fun sortByHighPriority() : LiveData<List<TodoData>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 2 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE '%H' THEN 3 END")
    fun sortByLowPriority() : LiveData<List<TodoData>>
}