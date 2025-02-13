package com.app.asurascans.ui.screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.datas.LevelItemData
import com.app.asurascans.ui.item.Leveltem
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

class ProfileActivity : BaseActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun ScreenContent() {
        val levels by remember { mutableStateListOf(LevelItemData("","",1)) }

        Scaffold( ) {
            Box(modifier = Modifier.imePadding()) {
                AsyncImage(
                    model = "https://images.genius.com/e86a0fabc1709ea8d56e994584ced53d.1000x1000x1.png",
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

                ContentArea()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ContentArea() {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "Hi~ I’m\nBlazing Guy", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                onClick = { /*TODO*/ },
                colors = CardDefaults.cardColors(containerColor = primaryColor),
            ) {
                Text(
                    text = "Donatur", color = ColorBlack, fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row (modifier = Modifier
                .wrapContentSize() ,
                verticalAlignment = Alignment.CenterVertically){
                AsyncImage(
                    model = "https://images.genius.com/e86a0fabc1709ea8d56e994584ced53d.1000x1000x1.png",
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                   Row (verticalAlignment = Alignment.CenterVertically){
                       Image(
                           painter = painterResource(id = R.drawable.ic_level_penguasa),
                           contentDescription = null,
                           modifier = Modifier.size(15.dp)
                       )
                       Spacer(modifier = Modifier.width(5.dp))
                       Text(text = "@blazing_guy",
                           color = primaryColor
                           , fontWeight = FontWeight.Bold, fontSize = 13.sp)

                   }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Emperor",
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = ColorWhite,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(vertical = 1.dp, horizontal = 5.dp),
                        fontSize = 13.sp,
                        color = ColorWhite
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Level : 829", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Text(text = "Bergabung : 2024-02-16", fontWeight = FontWeight.Bold, fontSize = 13.sp)

                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp) ,
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundItemColor )
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        items(5) {
                            Leveltem()
                        }
                    }
                }
            }
        }
    }
}