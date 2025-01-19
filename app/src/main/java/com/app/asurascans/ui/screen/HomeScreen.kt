package com.app.asurascans.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.app.asurascans.ui.item.LastUpdateGridItem
import com.app.asurascans.ui.item.LastUpdateListItem
import com.app.asurascans.ui.item.MostViewItem
import com.app.asurascans.ui.item.TextSelectedItem
import com.app.asurascans.ui.item.TopSliderItem
import com.app.asurascans.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val state = rememberScrollState()
    Column(modifier = modifier.verticalScroll(state)) {
        Spacer(modifier = Modifier.height(5.dp))
        Divider()
        Spacer(modifier = Modifier.height(5.dp))
        TopSlider()
        Spacer(modifier = Modifier.height(5.dp))
        BottomSlider()
        Spacer(modifier = Modifier.height(15.dp))
        MostView()
        Spacer(modifier = Modifier.height(15.dp))
        LatestUpdate()

    }

}


@Composable
private fun MostView(modifier: Modifier = Modifier) {
    val listTop = stringArrayResource(id = R.array.list_type_home_top)
    val scrollStateRowMostView = rememberLazyListState()
    val scrollStateColumn = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.most_view),
            modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        LazyRow(modifier = Modifier.wrapContentSize()) {
            itemsIndexed(listTop) { i, value ->
                TextSelectedItem(value)
            }
        }
    }

    Spacer(modifier = Modifier.height(15.dp))

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = scrollStateRowMostView
    ) {
        items(10) {
            MostViewItem()
        }
    }
}


@Composable
private fun LatestUpdate() {
    var isGrid by remember {  mutableStateOf(true)   }
    val scrollStateLatestUpdate = rememberLazyListState()
    val listBottom = stringArrayResource(id = R.array.list_type_home_bottom)
    Text(
        text = stringResource(id = R.string.last_update),
        modifier = Modifier.wrapContentSize(), fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    Row(modifier = Modifier.fillMaxWidth()) {
        LazyRow(modifier = Modifier.weight(1f)) {
            itemsIndexed(listBottom) { i, value ->
                TextSelectedItem(value)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_grid),
            "contentDescription",
            modifier = Modifier.size(30.dp)
                .clickable {
                    isGrid=true
                },
        )
        Image(
            painter = painterResource(id = R.drawable.ic_list_inactive),
            "contentDescription",
            modifier = Modifier.size(30.dp)
                .clickable {
                    isGrid=false
                },
            contentScale = ContentScale.Crop
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = scrollStateLatestUpdate
    ) {
        items(10) {
            if (isGrid) LastUpdateGridItem()
            else LastUpdateListItem()
        }
    }
}

@Composable
fun TopSlider(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
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
