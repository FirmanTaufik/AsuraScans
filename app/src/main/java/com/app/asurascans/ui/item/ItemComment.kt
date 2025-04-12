package com.app.asurascans.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.app.asurascans.ui.screen.detail.CommentModelResponse
import com.app.asurascans.ui.theme.ColorRed
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun ItemComment(data : CommentModelResponse.Data, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = data.commentUser?.userImage,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier.fillMaxWidth()) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_level_penguasa),
                                contentDescription = null,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "@${data.commentUser?.userName} •", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = data.createdAt ?: "", fontSize = 15.sp)
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = data.commentUser?.userBadge ?: "",
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = ColorWhite,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .padding(vertical = 1.dp, horizontal = 5.dp),
                                fontSize = 13.sp, color = ColorWhite
                            )
                            Spacer(modifier = Modifier.width(5.dp))


                            Text(
                                text = data.commentUser?.userLv.toString() ?: "",
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = ColorRed,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .padding(vertical = 1.dp, horizontal = 5.dp),
                                fontSize = 13.sp, color = ColorRed
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            if (data.commentUser?.userPremium == true) {
                                Text(
                                    text = "Donatur",
                                    modifier = Modifier
                                        .border(
                                            width = 1.dp,
                                            color = primaryColor,
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                        .padding(vertical = 1.dp, horizontal = 5.dp),
                                    fontSize = 13.sp,
                                    color = primaryColor
                                )
                            }
                        }

                    }

                    IconButton(onClick = { /*TODO*/ },
                        Modifier.size(30.dp)) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                    }
                }


                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = data.content ?: "",
                    fontSize = 15.sp,
                    lineHeight = 15.sp
                )

                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(13.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_love_empty),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = data.like.toString(), fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Balas  • ${data.replies.toString()}", fontSize = 13.sp)
                }

            }
        }
    }
}