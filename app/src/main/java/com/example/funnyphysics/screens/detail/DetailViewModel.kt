package com.example.funnyphysics.screens.detail

import com.example.funnyphysics.database.Info
import com.example.funnyphysics.screens.primary.PrimaryModel

class DetailViewModel(val model: PrimaryModel) {
    fun updateState(info: Info) {
        info.saved = !info.saved
        model.update(info)
    }
}