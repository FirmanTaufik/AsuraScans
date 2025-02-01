package com.app.asurascans.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun HistoryItem() {
    Column {
        // Header
        Row (verticalAlignment = Alignment.CenterVertically){
            Box (modifier = Modifier
                .background(color = primaryColor, shape = CircleShape)
                .size(10.dp))

            Text(
                text = "Senin",
                modifier = Modifier.padding(16.dp),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

        }

        // Manga Items
        SubItemHistory(
            coverUrl = "https://areajugones.sport.es/wp-content/uploads/2019/09/OnePiecePoster.jpg",
            title = "Dan Da Dan",
            chapter = "Chapter 69",
            timeAgo = "1 jam yang lalu",
            onItemClick = { /* Handle click */ }
        )

        SubItemHistory(
            coverUrl = "https://areajugones.sport.es/wp-content/uploads/2019/09/OnePiecePoster.jpg",
            title = "Dan Da Dan",
            chapter = "Chapter 69",
            timeAgo = "1 jam yang lalu",
            onItemClick = { /* Handle click */ }
        )
    }
}