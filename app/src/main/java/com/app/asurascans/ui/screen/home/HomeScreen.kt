package com.app.asurascans.ui.screen.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.asurascans.R
import com.app.asurascans.core.UIState
import com.app.asurascans.ui.item.BottomSlider
import com.app.asurascans.ui.item.LastUpdateGridItem
import com.app.asurascans.ui.item.LastUpdateListItem
import com.app.asurascans.ui.item.MostViewItem
import com.app.asurascans.ui.item.TextSelectedItem
import com.app.asurascans.ui.item.TopSliderItem
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.primaryColor
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import com.app.asurascans.helper.Constant
import com.app.asurascans.helper.launchActivity
import com.app.asurascans.helper.rememberCallbackActivityLauncher
import com.app.asurascans.ui.screen.detail.DetailActivity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeVm: HomeVM) {

    val state = rememberLazyListState()
    var isGridLatestupdate by remember { mutableStateOf(true) }

    val snackbarMessagState by  homeVm?.snackbarMessage?.collectAsStateWithLifecycle()
        ?: remember { mutableStateOf(UIState.OnIdle) }
    Log.d("FirmanTAG", "HomeScreen: ${snackbarMessagState} ")

    LaunchedEffect(key1 = true) {
        homeVm.getHome()
    }
    val resposeState by homeVm.homeState.collectAsStateWithLifecycle()

    LazyColumn(
        state = state,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(modifier = modifier.wrapContentSize()) {
                Spacer(modifier = Modifier.height(10.dp))
                TopSlider()
                Spacer(modifier = Modifier.height(15.dp))
                BottomSlider()
                Spacer(modifier = Modifier.height(15.dp))
                MostView(Modifier)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        item {
            LatestUpdateHeader(homeVm) {
                isGridLatestupdate = it
            }
        }
        when (resposeState) {
            is UIState.OnError -> {

            }

            UIState.OnIdle -> {

            }

            UIState.OnLoading -> {
                item {
                    CircularProgressIndicator(color = ColorWhite)
                }
            }

            is UIState.OnSuccess<*> -> {
                val data = (resposeState as UIState.OnSuccess<*>).data as UpdateModelResponse
                if (isGridLatestupdate) {

                    item {
                        LatestUpdateItemsGrid(data, homeVm)
                    }
                } else {
                    items(3) {
                        LastUpdateListItem(data, homeVm)
                    }
                }
            }
        }


        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            Button(
                onClick = { homeVm.showSnackbar("sasasa", false) },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
            ) {
                Text(
                    text = "Lihat lebih banyak komik",
                    color = ColorBlack,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            Column {
                NewLatestadded()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

    }

}

@Composable
fun NewLatestadded() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Baru di tambahkan",
            modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
        ) {
            Text(
                text = "More", color = ColorBlack, fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        items(10) {
            MostViewItem(true)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LatestUpdateItemsGrid(data: UpdateModelResponse, homeVm: HomeVM) {
    val scrollStateLatestUpdate = rememberLazyListState()
    val list = homeVm.itemsSelected.collectAsStateWithLifecycle()

    val launcher= rememberCallbackActivityLauncher( )

    FlowRow(
        maxItemsInEachRow = 3,
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        list.value.forEach {
            LastUpdateGridItem(data = it) { seriesId ->
                val bundle = Bundle()
                bundle.putString(Constant.SERIES_ID, seriesId)
                 homeVm.context.launchActivity <DetailActivity>(launcher, bundle)
            }
        }
    }
}


@Composable
private fun MostView(modifier: Modifier = Modifier) {
    val listTop = stringArrayResource(id = R.array.list_type_home_top)
    val scrollStateRowMostView = rememberLazyListState()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.most_view),
            modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        LazyRow(
            modifier = Modifier.wrapContentSize(),
        ) {
            itemsIndexed(listTop) { i, value ->
                TextSelectedItem(value, i, 0) {

                }
            }
        }
    }

    Spacer(modifier = Modifier.height(15.dp))

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = scrollStateRowMostView,
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        items(10) {
            MostViewItem()
        }
    }
}


@Composable
private fun LatestUpdateHeader(homeVm: HomeVM, onChangeList: (Boolean) -> Unit) {

    val listBottom = homeVm.listBottom
    // var indexSelected by remember { mutableIntStateOf(homeVm.itemTypeBottomSelectedIndex) }
    var indexselected = homeVm.itemTypeBottomSelectedIndex.collectAsStateWithLifecycle()
    Text(
        text = stringResource(id = R.string.last_update),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp), fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Left
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        LazyRow(modifier = Modifier.weight(1f)) {
            itemsIndexed(listBottom) { i, value ->
                TextSelectedItem(value, i, indexselected.value) { valueClick ->
                    homeVm.setItemTypeBottomSelectedIndex(valueClick)
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_grid),
            "contentDescription",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    onChangeList(true)
                },
        )
        Image(
            painter = painterResource(id = R.drawable.ic_list_inactive),
            "contentDescription",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    onChangeList(false)
                },
            contentScale = ContentScale.Crop
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun TopSlider(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        LazyRow {
            items(5) {
                Box(modifier = Modifier.padding(start = 10.dp, end = 20.dp)) {
                    TopSliderItem()
                }
            }
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
