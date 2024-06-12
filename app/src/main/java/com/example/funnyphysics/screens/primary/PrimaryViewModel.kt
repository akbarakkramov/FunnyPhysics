package com.example.funnyphysics.screens.primary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.funnyphysics.database.Info

class PrimaryViewModel(private val model: PrimaryModel, private val navController: NavController) {
    private val _infos = MutableLiveData<List<Info>>()
    val infos: LiveData<List<Info>> = _infos

    private val _savedInfos = MutableLiveData<List<Info>>()
    val savedInfos: LiveData<List<Info>> = _savedInfos

    init {
        _infos.value = model.getAllBooks()
        _savedInfos.value = model.getSavedBooks()
    }

    fun updateState(info: Info) {
        info.saved = !info.saved
        model.update(info)
        _infos.value = model.getAllBooks()
        _savedInfos.value = model.getSavedBooks()
    }

    fun navigate(info: Info) {
        navController.navigate("detail_screen/${info.id}")
    }
}