package com.app.asurascans.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.datas.LevelItemData
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun Leveltem(position: Int, sizeIndex: Int) {
    val isLastIndex = position == sizeIndex - 1
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            //.padding(10.dp)
        .height(170.dp)) {
            Column(
                modifier = Modifier
                    .width(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bangsawan\nmenengah",
                    color = ColorWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Lv. 1", color = ColorGrey, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_level_penguasa),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_line_level),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center)
                    )

                    if (position == 0) {

                        Divider(
                            color = primaryColor, modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .width(40.dp)
                                .height(1.dp)
                        )
                    } else {
                        if (isLastIndex) {

                            Divider(
                                color = primaryColor, modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .width(40.dp)
                                    .height(1.dp)
                            )
                        } else {
                            Divider(
                                color = primaryColor, modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .width(40.dp)
                                    .height(1.dp)
                            )
                            Divider(
                                color = primaryColor, modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .width(40.dp)
                                    .height(1.dp)
                            )
                        }

                    }

                }

            }
            if (isLastIndex) {
                AsyncImage(
                    model = "https://images.genius.com/e86a0fabc1709ea8d56e994584ced53d.1000x1000x1.png",
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .clip(CircleShape)
                        .size(30.dp)
                )
            }
        }
    }
}