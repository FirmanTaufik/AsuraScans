package com.app.asurascans.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.core.BaseViewModel
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ShimmerColor

class ReadActivity : BaseActivity() {


    @Composable
    override fun BaseContent(
        paddingValues: PaddingValues
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { finish() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
                Text(text = "Chapter 200", modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null
                    )
                }
            }


            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Favoritkan komik ini kalau kamu mau menerima notifikasi update dengan cara mengklik tombol LOVE",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    shape = RoundedCornerShape(5.dp),
                                    color = ColorGrey
                                )
                        ) {
                            Text(text = "Cara Baca", color = ColorGrey)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Divider(color = ColorGrey)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    shape = RoundedCornerShape(5.dp),
                                    color = ColorGrey
                                )
                        ) {
                            Text(text = "Bawah ke Atas", color = ColorGrey)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Divider(color = ColorGrey)
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                item {
                    AsyncImage(
                        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIy2iFwrch8iXz2wXTk0GWUVaBT4uZSMtdZQ&s",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    AsyncImage(
                        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIy2iFwrch8iXz2wXTk0GWUVaBT4uZSMtdZQ&s",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            BottomBar()
        }
    }


    @Composable
    private fun BottomBar() {
        Column(modifier = Modifier
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_setting_read_chapter),
                        modifier = Modifier.size(50.dp), contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_report_read_chapter),
                        modifier = Modifier.size(30.dp), contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_love_read_chapter),
                        modifier = Modifier.size(30.dp), contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_maraton_read_chapter),
                        modifier = Modifier.size(30.dp), contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_download_read_chapter),
                        modifier = Modifier.size(30.dp), contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                }
            }
            Divider(color = Color.Black, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_list_read_chapter), contentDescription = null)
                }
                
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = ColorButtonRefreshReadChapter),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(95.dp)
                        .height(35.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Refresh", color = ShimmerColor)
                }
                
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_comment_read_chapter), contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_prev_read_chapter), contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_next_read_chapter), contentDescription = null)
                }
            }
        }
    }


}