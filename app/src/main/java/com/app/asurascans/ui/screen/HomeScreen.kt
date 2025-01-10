package com.app.asurascans.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.item.BottomSlider
import com.app.asurascans.ui.item.MostViewItem
import com.app.asurascans.ui.item.TextSelectedItem
import com.app.asurascans.ui.item.TopSliderItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val listTop = stringArrayResource(id = R.array.list_type_home_top)
    val scrollStateColumn = rememberScrollState()
    val scrollStateRowMostView = rememberLazyListState()


    Column(modifier = modifier.verticalScroll(scrollStateColumn)) {
        Header()
        Spacer(modifier = Modifier.height(5.dp))
        Divider()
        Spacer(modifier = Modifier.height(5.dp))
        TopSlider()
        Spacer(modifier = Modifier.height(5.dp))
        BottomSlider()
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = R.string.most_view),
                modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
            LazyRow(modifier = Modifier.wrapContentSize()) {
                itemsIndexed(listTop){ i, value->
                    TextSelectedItem(value)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyRow(modifier = Modifier.fillMaxWidth(),
            state = scrollStateRowMostView) {
            items(10){
                MostViewItem()
            }
        }
    }
    
    /*val listState = rememberLazyListState()
    
    LazyColumn(modifier = modifier,
        state = listState) {
        item {
            Header()
        }
        item {
            Spacer(modifier = Modifier.height(5.dp))
        }
        item { Divider() }
        item {
            Spacer(modifier = Modifier.height(5.dp))
        }
        item {
            TopSlider()
        }
        item {
            BottomSlider()
        }
    }*/
}

@Composable
fun TopSlider(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {
        Box(modifier = Modifier.padding(horizontal = 10.dp)) {
            TopSliderItem()
        }
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_row_left), contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_row_right), contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            AsyncImage(model = R.drawable.ic_small_app, contentDescription = null)
            //  Icon(painter = painterResource(id = R.drawable.ic_small_app), contentDescription =null )
        }
        Row(modifier = Modifier.wrapContentSize()) {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Icon(painter = painterResource(id = R.drawable.ic_notif), contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            AsyncImage(
                model = R.drawable.ic_person, contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Header()
}