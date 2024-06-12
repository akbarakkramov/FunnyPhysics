package com.example.funnyphysics.screens.saved

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.funnyphysics.screens.home.BookItem
import com.example.funnyphysics.screens.primary.PrimaryViewModel

@Composable
fun SavedView(pvm: PrimaryViewModel){
    val books = pvm.savedInfos.observeAsState().value!!
    LazyColumn {
        items(books) {
            BookItem(it, pvm)
        }
    }
}