package com.app.asurascans.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.theme.ColorTransparent

@Composable
fun LastUpdateItem(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/id/thumb/d/db/Boruto_manga_vol_1.jpg/220px-Boruto_manga_vol_1.jpg",
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .width(110.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop,
            )

            Box(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .width(110.dp)
                    .height(150.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(ColorTransparent, Color.Black)
                        ),
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    ),
            )

            Row(
                modifier = Modifier
                    .width(110.dp)
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(color = ColorTransparent, shape = RoundedCornerShape(4.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(1.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "7.5", color = Color.White, fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_korea), contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(ColorTransparent, Color.Black)
                        ),
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    )
                    .align(Alignment.BottomCenter)
            ) {

                Row(
                    modifier = Modifier
                        .width(110.dp)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(color = ColorTransparent, shape = RoundedCornerShape(4.dp))
                    ) {
                        Text(
                            text = "CH 6009", color = Color.White, fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                    }

                    Text(
                        text = "1 menit", color = Color.White, fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier
                        .width(110.dp)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(color = ColorTransparent, shape = RoundedCornerShape(4.dp))
                    ) {
                        Text(
                            text = "CH 6009", color = Color.White, fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                    }

                    Text(
                        text = "1 menit", color = Color.White, fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = "Solo Leveling", color = Color.White, fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}