package com.app.asurascans.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.ui.item.BookmarkItem
import com.app.asurascans.ui.item.ContentAlphabetItem
import com.app.asurascans.ui.item.HistoryItem
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorNav
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.grayColor
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun HistoryBookmark(modifier: Modifier = Modifier) {
    var isBookmark by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackroundColor)
    ) {
        Box(
            modifier = Modifier
                .background(grayColor, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { isBookmark = false },
                    colors = ButtonDefaults.buttonColors(containerColor =if (!isBookmark) primaryColor else ColorNav  ),
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "History",
                        color = if (!isBookmark)  ColorBlack else   ColorWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        isBookmark = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = if (isBookmark) primaryColor else ColorNav),
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Bookmark",
                        color = if (isBookmark)  ColorBlack  else ColorWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (isBookmark)
            BookmarkContent()
        else HistoryContent()


    }
}

@Composable
private fun BookmarkContent() {
    val list = (0..12).toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 items per row
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(list) { index, item ->
            BookmarkItem()
        }
    }
}

@Composable
private fun HistoryContent() {
    LazyColumn {
       items(3){
           HistoryItem()
       }
    }
}