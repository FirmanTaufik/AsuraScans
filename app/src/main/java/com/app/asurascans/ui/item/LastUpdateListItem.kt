package com.app.asurascans.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.screen.home.UpdateModelResponse
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorRed
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.ColorTransparentChip

@Composable
fun LastUpdateListItem(modifier: UpdateModelResponse = Modifier) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 10.dp, horizontal = 13.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/id/4/46/Jujutsu_kaisen.jpg",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = ColorTransparent)
            )

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                AsyncImage(
                    model = "https://upload.wikimedia.org/wikipedia/id/4/46/Jujutsu_kaisen.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(130.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Spacer(modifier = Modifier.height(25.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Solo Leveling", color = Color.White, fontSize = 25.sp,
                            fontWeight = FontWeight.Bold, maxLines = 2, overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Manhwa",
                            color = ColorRed,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .background(
                                    color = ColorTransparentChip,
                                    shape = RoundedCornerShape(
                                        topStart = 10.dp,
                                        bottomStart = 10.dp
                                    )
                                )
                        ) {
                            Image(
                                modifier = Modifier.align(Alignment.Center),
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .background(
                                    color = Color.Black,
                                    shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "7.0",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }

                LazyColumn(modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    item {
                        Column {
                            repeat(2) {
                                Box(
                                    modifier = Modifier
                                        .padding(vertical = 3.dp)
                                        .wrapContentSize()
                                        .background(
                                            color = Color.Black,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                ) {
                                    Text(
                                        text = "CH 1002", modifier = Modifier
                                            .padding(vertical = 8.dp, horizontal = 15.dp),
                                        fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold
                                    )
                                }
                                Text(
                                    text = "1 jam yang lalu",
                                    modifier = Modifier.wrapContentSize(),
                                    color = ColorGrey, fontSize = 13.sp,fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }

        }
    }
}

