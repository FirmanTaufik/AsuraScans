package com.app.asurascans.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.R
import com.app.asurascans.ui.item.AlphabetItem
import com.app.asurascans.ui.item.ContentAlphabetItem
import com.app.asurascans.ui.item.TextSelectedItem
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun AlphabetScreen(modifier: Modifier = Modifier) {
    val topState = rememberLazyListState()
    val topList = stringArrayResource(id = R.array.list_type_home_bottom)
    Column(modifier = modifier.fillMaxWidth()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            state = topState,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemsIndexed(topList) { i, value ->
                TextSelectedItem(value)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxSize()) {
            Alphabet()
            ListItemArea()
        }
    }
}

@Composable
private fun ListItemArea() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
            .background(color = backgroundItemColor, shape = RoundedCornerShape(20.dp))
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .horizontalScroll(state)) {
            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(
                        color = BackroundColor,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Text(
                    text = "A-Z Lists", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(
                        color = primaryColor,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Text(
                    text = "75 Judul komik di temukan", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        val items = List(50) { "Item ${it + 1}" }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 items per row
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(items) {  i, value ->
                ContentAlphabetItem()
            }
        }
    }
}

@Composable
private fun Alphabet() {
    val alphabetList = ('A'..'Z').toList()
    val state = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight(),
        state = state
    ) {
        itemsIndexed(alphabetList) { index, item ->
            AlphabetItem(text = item.toString())
        }
    }
}