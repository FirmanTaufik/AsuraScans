package com.app.asurascans.ui.item

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.screen.ReadActivity
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailItem() {
    val context = LocalContext.current
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight(), color = primaryColor
            )
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                onClick = {
                    context.startActivity(Intent(context, ReadActivity::class.java))
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Cover Image
                    AsyncImage(
                        model = "https://imgsrv.crunchyroll.com/cdn-cgi/image/fit=contain,format=auto,quality=85,width=480,height=720/catalog/crunchyroll/323c82257b2f6567fabbb7bd55bfa753.jpg",
                        contentDescription = "Manga Cover",
                        modifier = Modifier
                            .width(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    // Text Content
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp)
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Chapter 69",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = "1 jam yang lalu",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }


                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(40.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    contentColor = ColorBlack,
                                    containerColor = ColorButtonRefreshReadChapter
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_download_read_chapter),
                                    contentDescription = null,
                                    tint = ColorWhite,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            // Continue Button
                            Card(
                                onClick = {},
                                colors = CardDefaults.cardColors(
                                    containerColor = primaryColor,
                                    contentColor = ColorBlack
                                ),
                            ) {
                                Text(
                                    "Baca sekarang", fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(
                                        vertical = 5.dp,
                                        horizontal = 8.dp
                                    )
                                )
                            }
                        }
                    }


                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}