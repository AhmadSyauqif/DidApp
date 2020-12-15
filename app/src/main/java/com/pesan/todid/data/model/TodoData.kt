package com.pesan.todid.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class TodoData (
    @PrimaryKey(autoGenerate = true)
    var Id : Int,
    var title : String,
    var priority: Priority,
    var descripcion : String
) : Parcelable
