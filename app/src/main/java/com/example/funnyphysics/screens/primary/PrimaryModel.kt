package com.example.funnyphysics.screens.primary

import com.example.funnyphysics.database.AppDatabase
import com.example.funnyphysics.database.Info

class PrimaryModel(val db: AppDatabase) {
    fun getAllBooks() = db.getBookDao().getAllInfos()
    fun getSavedBooks() = db.getBookDao().getSavedInfos()
    fun update(info: Info) = db.getBookDao().updateInfo(info)


}