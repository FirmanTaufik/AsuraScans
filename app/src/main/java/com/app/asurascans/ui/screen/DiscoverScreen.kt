package com.app.asurascans.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.app.asurascans.ui.item.CommentItem
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun DiscoverScreen() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxKVE0_t9tDX7Vdp1yFMnJRgd-7x2Kz88SaA&s",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(ColorTransparent, Color.Black)
                        ),
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    ),
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(10.dp)
            ) {
                Text(
                    text = "A Dragonslayer’s Peerless Regression", fontStyle = FontStyle.Normal,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold, color = ColorWhite
                )
                Text(
                    text = " Zeke Draker, the first direct descendant of the Dragon Slayer family to...",
                    fontStyle = FontStyle.Normal,
                    fontSize = 13.sp,
                    letterSpacing = 1.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = ColorGrey
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "8.7", fontStyle = FontStyle.Normal,
                        fontSize = 13.sp,
                        maxLines = 2, overflow = TextOverflow.Ellipsis, color = ColorWhite
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = backgroundItemColor),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Yuk donasi sekarang, dan nikmati keuntungan Donasi~",
                    modifier = Modifier.weight(1f), color = ColorWhite
                )
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                ) {
                    Text(
                        text = "Donasi", color = ColorBlack, fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        //comment section
        Row {
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 1.dp, color = primaryColor),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(15.dp),
                contentPadding = PaddingValues(vertical = 0.dp, horizontal = 5.dp)
            ) {
                Text(text = "Komentar populer", color = primaryColor)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 1.dp, color = Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(15.dp),
                contentPadding = PaddingValues(vertical = 0.dp, horizontal = 5.dp)
            ) {
                Text(text = "Komentar terbaru", color = ColorWhite)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {

            items(10) {
                CommentItem(
                    profileImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSBZh2UpzLj8efScUh-KXZcfKbIaJeF4P7uQ&s",
                    username = "Noordin M Top",
                    level = 4045,
                    title = "Ep 234 • Solo Leveling",
                    comment = "Man life back then must've Sucked Balls if many People thought like oczy does...",
                    timeAgo = "17 Jam yang lalu",
                    likes = 1,
                    onLikeClick = { /* Handle like click */ }
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)) {
                Text(
                    text = "Perpustakaan MangaEvo",
                    color = ColorWhite,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(15.dp))
                Divider(thickness = 1.dp, color = ColorWhite)
                Spacer(modifier = Modifier.height(15.dp))

                Row {
                    Card(modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = ColorButtonRefreshReadChapter)
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.padding(5.dp)){
                            Text(text = "Genre", modifier = Modifier.weight(1f))
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_bottom), contentDescription =null )
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = ColorButtonRefreshReadChapter)
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.padding(5.dp)){
                            Text(text = "Status", modifier = Modifier.weight(1f))
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_bottom), contentDescription =null )
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = ColorButtonRefreshReadChapter)
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.padding(5.dp)){
                            Text(text = "Type", modifier = Modifier.weight(1f))
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_bottom), contentDescription =null )
                        }
                    }
                }


                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Text(
                        text = "Cari", color = ColorBlack, fontWeight = FontWeight.Bold,
                        fontSize = 18.sp, textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "*yang perlu diisi cuma satu form, terlalu banyak form yang diisi bisa kosong hasil\n" +
                            "pencariannya", color = ColorWhite, fontSize = 18.sp
                )
            }
        }
    }
}

