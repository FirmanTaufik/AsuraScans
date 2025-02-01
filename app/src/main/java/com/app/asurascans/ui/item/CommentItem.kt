package com.app.asurascans.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun CommentItem(
    profileImage: String,
    username: String,
    level: Int,
    title: String,
    comment: String,
    timeAgo: String,
    likes: Int,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(200.dp)
    ) {
        Card(
            modifier = modifier
                .width(470.dp)
                .height(180.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Box {
                DiagonalSplitImage(
                    imageUrl2 = "https://areajugones.sport.es/wp-content/uploads/2019/09/OnePiecePoster.jpg",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(180.dp)
                        .align(Alignment.CenterEnd)
                        .aspectRatio(1f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        // Profile Image
                        Box(modifier = Modifier.height(60.dp)) {
                            AsyncImage(
                                model = profileImage,
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(45.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Lv. $level",
                                color = ColorBlack,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(5.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            // User Info Row
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = username,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                            // Title
                            Text(
                                text = title,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 14.sp
                            )


                        }
                    }

                    // Comment
                    Text(
                        text = comment,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Bottom Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = onLikeClick,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Like",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Text(
                            text = likes.toString(),
                            modifier = Modifier.padding(start = 4.dp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = "•",
                            modifier = Modifier.padding(horizontal = 8.dp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = timeAgo,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Row(modifier = Modifier.align(Alignment.BottomEnd)) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = ColorGrey),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp)
            ) {
                Text(text = "Duke", color = ColorBlack, fontWeight = FontWeight.Bold,
                    fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp)
            ) {
                Text(text = "Donatur", color = ColorBlack, fontWeight = FontWeight.Bold,
                    fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.width(50.dp))
        }
    }
}