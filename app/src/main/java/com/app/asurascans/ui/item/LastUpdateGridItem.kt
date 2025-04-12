package com.app.asurascans.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.app.asurascans.helper.getDeviceWidthInDp
import com.app.asurascans.ui.screen.home.UpdateModelResponse
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorTransparent

@Composable
fun LastUpdateGridItem(modifier: Modifier = Modifier, showChapter : Boolean ?= true,
                       data : UpdateModelResponse.List ?= UpdateModelResponse. List(), onClick :(String) ->Unit ?={} ) {
    Column(
        modifier = Modifier
            .width((getDeviceWidthInDp() / 3.1).dp)
            .clickable {
                onClick.invoke(data?.seriesId ?: "")
            }
            .wrapContentHeight()
            .padding(horizontal = 5.dp,),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            AsyncImage(
                model = data?.coverImageUrl ?: "" ,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop,
            )

            if (showChapter == true) {

                Box(
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(ColorTransparent, Color.Black)
                            ),
                            shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                        ),
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 5.dp, start = 5.dp, top = 5.dp),
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
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = data?.userRating.toString(), color = Color.White, fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_korea), contentDescription = null,
                    modifier = Modifier.size(25.dp)
                        .border(width = 1.dp, color = ColorBlack, RoundedCornerShape(1.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            if (showChapter == true) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
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
                            .padding(5.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = ColorTransparent, shape = RoundedCornerShape(4.dp))
                        ) {
                            Text(
                                text = "CH 69", color = Color.White,
                                fontSize = 13.sp, maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Text(
                            text = "1 menit", color = Color.White,
                            fontSize = 13.sp
                        )
                    }

                    //Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
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
                                text = "CH 609", color = Color.White,
                                fontSize = 13.sp, maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Text(
                            text = "1 menit", color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }

        }


        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = data?.title ?: "", color = Color.White, fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}