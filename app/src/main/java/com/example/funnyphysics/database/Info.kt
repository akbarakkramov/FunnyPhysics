package com.example.funnyphysics.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Infos")
data class Info(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val author: String,
    val description: String,
    var saved: Boolean = false,
//    val image: String
)