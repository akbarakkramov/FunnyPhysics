package com.example.funnyphysics.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.funnyphysics.R
import com.example.funnyphysics.database.Info
import com.example.funnyphysics.screens.primary.PrimaryViewModel

@Composable
fun HomeView(pvm: PrimaryViewModel) {
    val infos = pvm.infos.observeAsState().value
    LazyColumn {
        items(infos!!) {
            BookItem(it, pvm)
        }
    }
}

@Composable
fun BookItem(info: Info, pvm: PrimaryViewModel) {
    val saved = remember {
        mutableStateOf(info.saved)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                pvm.navigate(info)
            }
            .padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
//        AsyncImage(
//            model = info.image,
//            contentDescription = "",
//            placeholder = painterResource(id = R.drawable.loading),
//            error = painterResource(
//                id = R.drawable.error
//            ),
//            modifier = Modifier.width(60.dp),
//            contentScale = ContentScale.Fit
//        )
        Column(
            Modifier
                .padding(horizontal = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = info.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA7A7A7)
            )
            Text(
                text = info.author,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF666666)
            )
        }
        IconButton(onClick = {
            pvm.updateState(info)
            saved.value = !saved.value
        }) {
            Icon(
                painter = painterResource(
                    id = R.drawable.bookmark
                ),
                contentDescription = "",
                tint = if (saved.value) Color(0xFF676F8D) else Color(0xFFC7C5C5)
            )
        }
    }
}