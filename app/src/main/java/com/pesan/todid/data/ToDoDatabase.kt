package com.pesan.todid.data

import android.content.Context
import androidx.room.*
import com.pesan.todid.data.model.TodoData

@Database(entities = [TodoData::class],version = 1,  exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDaDao(): ToDoDao

    companion object{
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
        }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, ToDoDatabase::class.java,
                    "todo_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}