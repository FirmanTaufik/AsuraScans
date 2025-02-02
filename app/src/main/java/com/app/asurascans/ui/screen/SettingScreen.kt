package com.app.asurascans.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.item.StarRatingBar
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.grayColor
import com.app.asurascans.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen() {
    val state =  rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state)
            .fillMaxSize()
            .padding(15.dp)
    ) {
        HeaderProfile()
        Spacer(modifier = Modifier.height(15.dp))
        SettingArea()
        Spacer(modifier = Modifier.height(15.dp))
        NotifArea()
        Spacer(modifier = Modifier.height(15.dp))
        AboutArea()
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
private fun AboutArea() {
    Text(text = "About", fontWeight = FontWeight.Bold,
        fontSize = 18.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Email", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "mangaevo@gmail.com", fontSize = 18.sp,  )
        }
    }


    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Release Version", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "V 1.0.10", fontSize = 18.sp, )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bantu Rating", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            StarRatingBar(
                maxStars = 5,
                rating = 5.0f,
                onRatingChanged = {

                }
            )
         }
    }
}

@Composable
private fun NotifArea() {
    Text(text = "Notifikasi", fontWeight = FontWeight.Bold,
        fontSize = 18.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Vertical follow", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Switch(
                checked = true,
                onCheckedChange = {   },
                colors = SwitchDefaults.colors(checkedThumbColor = ColorWhite,
                    checkedTrackColor = primaryColor)
            )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bookmark New Chapter", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Switch(
                checked = true,
                onCheckedChange = {   },
                colors = SwitchDefaults.colors(checkedThumbColor = ColorWhite,
                    checkedTrackColor = primaryColor)
            )
        }
    }


    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Replay Comment", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Switch(
                checked = false,
                onCheckedChange = {   },
                colors = SwitchDefaults.colors(checkedThumbColor = ColorWhite,
                    checkedTrackColor = primaryColor, uncheckedThumbColor = ColorWhite,
                    uncheckedTrackColor = ColorGrey)
            )
        }
    }
}

@Composable
private fun SettingArea() {
    Text(text = "Pengaturan Baca", fontWeight = FontWeight.Bold,
        fontSize = 18.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = grayColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Vertical follow", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(containerColor = primaryColor),
                modifier = Modifier
                    .padding(0.dp)
                    .size(30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_bottom_setting),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                        .padding(0.dp),
                    tint = ColorBlack
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HeaderProfile() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = grayColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Box(modifier = Modifier.height(60.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .align(Alignment.Center)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "  Lv. : 67  ",
                        color = ColorWhite,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(5.dp)
                            )
                    )

                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "No Name", fontSize = 18.sp, color = ColorWhite)
                    Text(text = "noname@gmail.com", fontSize = 13.sp, color = ColorWhite)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Duke", fontSize = 18.sp, color = ColorWhite)
                }

                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.padding(top = 0.dp)) {
                    Card(shape = RoundedCornerShape(5.dp),
                        onClick = {

                        }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_logout),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = primaryColor),
                shape = RoundedCornerShape(5.dp),
            ) {
                Text(
                    text = "Donatur", color = ColorBlack,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 8.dp)
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}
