package com.example.funnyphysics.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface InfoDao {
    @Insert
    fun insertInfo(info: Info)

    @Delete
    fun deleteInfo(info: Info)

    @Update
    fun updateInfo(info: Info)

    @Query("SELECT * FROM Infos WHERE id = :id")
    fun getInfo(id: Int): Info

    @Query("SELECT * FROM Infos WHERE saved = 1")
    fun getSavedInfos(): MutableList<Info>

    @Query("SELECT * FROM Infos")
    fun getAllInfos(): MutableList<Info>
}