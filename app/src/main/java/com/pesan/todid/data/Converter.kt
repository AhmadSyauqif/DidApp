package com.pesan.todid.data

import androidx.room.TypeConverter
import com.pesan.todid.data.model.Priority

class Converter {
    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }
    @TypeConverter
    fun toPriority(priority: String): Priority{
        return Priority.valueOf(priority)
    }
}