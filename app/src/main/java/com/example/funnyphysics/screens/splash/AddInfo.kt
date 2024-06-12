package com.example.funnyphysics.screens.splash

import android.content.Context
import android.icu.text.IDNA.Info
import com.example.funnyphysics.database.AppDatabase

fun AddInfo(context: Context) {
    val books = listOf(
        com.example.funnyphysics.database.Info(
            name = "Funny Fact1",
            author = "Author 1",
            description = "Description 1 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact2",
            author = "Author 2",
            description = "Description 2 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact3",
            author = "Author 3",
            description = "Description 3 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact4",
            author = "Funny Fact4",
            description = "Description 4 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact5",
            author = "Author 5",
            description = "Description 5 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact6",
            author = "Author 6",
            description = "Description 6 description description description description description description description description.",

        ),
        com.example.funnyphysics.database.Info(
            name = "Funny Fact7",
            author = "Author 7",
            description = "Description 7 description description description description description description description description.",

        ),

    )
    val dao = AppDatabase.getInstance(context).getBookDao()
    books.forEach {
        dao.insertInfo(it)
    }
}