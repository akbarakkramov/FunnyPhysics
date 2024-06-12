package com.example.funnyphysics.screens.primary

import com.example.funnyphysics.database.AppDatabase
import com.example.funnyphysics.database.Info

class PrimaryModel(val db: AppDatabase) {
    fun getAllBooks() = db.getInfoDao().getAllInfos()
    fun getSavedBooks() = db.getInfoDao().getSavedInfos()
    fun update(info: Info) = db.getInfoDao().updateInfo(info)


}