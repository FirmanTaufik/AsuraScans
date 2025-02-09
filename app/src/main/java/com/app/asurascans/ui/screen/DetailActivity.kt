package com.app.asurascans.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.ui.bottomsheet.Comments
import com.app.asurascans.ui.item.ChapterDetailItem
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.ColorIcon
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

class DetailActivity : BaseActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun ScreenContent() {
        val state = rememberScrollState()

        var showBottomSheet by remember { mutableStateOf(false) }

        Scaffold(floatingActionButton = {
            IconButton(
                onClick = {  showBottomSheet = true },
                modifier = Modifier
                    .size(70.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = ColorBlack,
                    containerColor = primaryColor
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = null,
                    tint = ColorBlack,
                    modifier = Modifier.size(50.dp)
                )
            }
        }) {
            Box(modifier = Modifier.imePadding()) {
                AsyncImage(
                    model = "https://imgsrv.crunchyroll.com/cdn-cgi/image/fit=contain,format=auto,quality=85,width=480,height=720/catalog/crunchyroll/323c82257b2f6567fabbb7bd55bfa753.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(ColorTransparent, Color.Black)
                                ),
                            ),
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = ColorBlack,
                            ),
                    )
                }


                LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    item {
                        HeaderDetail()
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    item {
                        PosterAndTitle()
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    item {
                        GenreSlider()
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    item {
                        HiglightComment()
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    item {
                        ListChapterArea()
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    items(1000){
                        ChapterDetailItem()
                    }
                }

            }

            if (showBottomSheet) {
                Comments {
                    showBottomSheet = it
                }
            }
        }
    }

    @Composable
    private fun PosterAndTitle() {

        AsyncImage(
            model = "https://imgsrv.crunchyroll.com/cdn-cgi/image/fit=contain,format=auto,quality=85,width=480,height=720/catalog/crunchyroll/323c82257b2f6567fabbb7bd55bfa753.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(180.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(10.dp))
        )


        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "ダンダダン (Dandadan)", color = Color.White, fontSize = 15.sp)

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HeaderDetail() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier
                    //  .background(color = ColorTransparent, shape = CircleShape)
                    .size(50.dp)
                    .align(Alignment.TopStart), onClick = { finish() },
                colors = CardDefaults.cardColors(containerColor = ColorTransparent),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.detail_ic_row_back),
                    contentDescription = null,
                    modifier = Modifier.background(color = Color.Transparent)
                )
            }

            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.TopEnd)
            ) {

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = ColorTransparent, shape = CircleShape)
                ) {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bookmark),
                            contentDescription = null,
                            tint = primaryColor
                        )
                        Text(text = "123", color = Color.White, fontSize = 15.sp)
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = ColorTransparent, shape = CircleShape)
                ) {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_comment),
                            contentDescription = null,
                            tint = primaryColor
                        )
                        Text(text = "123", color = Color.White, fontSize = 15.sp)
                    }
                }
            }
        }

    }

    @Composable
    private fun ListChapterArea() {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(width = 1.dp, color = ColorIcon),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = "Cari Chapter", color = ColorIcon)
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sort_chapter_default),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))


        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HiglightComment() {
        Box(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                                ) {
                                    Text(
                                        text = "Read Now",
                                        color = ColorBlack,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )

                                }
                            }

                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(50.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    contentColor = ColorBlack,
                                    containerColor = ColorButtonRefreshReadChapter
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_bookmark),
                                    contentDescription = null,
                                    tint = ColorWhite,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(50.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    contentColor = ColorBlack,
                                    containerColor = ColorButtonRefreshReadChapter
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_share),
                                    contentDescription = null,
                                    tint = ColorWhite,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "8.7", fontStyle = FontStyle.Normal,
                                fontSize = 18.sp,
                                maxLines = 2, overflow = TextOverflow.Ellipsis, color = ColorWhite
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "(3 Voted)", fontStyle = FontStyle.Normal,
                                fontSize = 13.sp,
                                maxLines = 2, overflow = TextOverflow.Ellipsis, color = ColorWhite
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Apa pendapatmu tentang\nkomik ini?",
                                fontSize = 15.sp,
                                modifier = Modifier.weight(1f),
                                color = ColorWhite,

                                )
                            Card(
                                onClick = {},
                                shape = CircleShape
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_bad),
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(8.dp), contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                onClick = {},
                                shape = CircleShape
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_normal),
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(8.dp), contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                onClick = {},
                                shape = CircleShape
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_amazing),
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(8.dp), contentDescription = null
                                )
                            }
                        }
                    }
                }
            }


            Card(
                colors = CardDefaults.cardColors(containerColor = primaryColor),
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Selengkapnya", color = ColorBlack,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }

    }


    @Composable
    private fun GenreSlider() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center),
                contentPadding = PaddingValues(5.dp)
            ) {
                items(10) {
                    Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = backgroundItemColor)
                        ) {
                            Text(text = "Comedy", color = ColorWhite, textAlign = TextAlign.Center)
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(150.dp)
                    .align(Alignment.CenterStart)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(ColorBlack, Color.Transparent),
                            start = Offset(0f, 0f),  // Starting point of the gradient (left)
                            end = Offset(Float.POSITIVE_INFINITY, 0f) // Ending point (right)
                        )
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){

                Spacer(modifier = Modifier.width(15.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(30.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = ColorBlack,
                        containerColor = ColorIcon
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_genre),
                        contentDescription = null
                    )
                }
            }

            Row(
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(150.dp)
                    .align(Alignment.CenterEnd)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(ColorBlack, Color.Transparent),
                            start = Offset(
                                Float.POSITIVE_INFINITY,
                                0f
                            ),  // Starting point of the gradient (left)
                            end = Offset(0f, 0f) // Ending point (right)
                        )
                    ),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(30.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = ColorBlack,
                        containerColor = ColorIcon
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right_genre),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }

}

