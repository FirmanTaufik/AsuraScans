package com.app.asurascans.ui.item

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubItemHistory(
    coverUrl: String,
    title: String,
    chapter: String,
    timeAgo: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(5.dp))
        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(135.dp), color = primaryColor
        )

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            ),
            onClick = onItemClick
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Cover Image
                AsyncImage(
                    model = coverUrl,
                    contentDescription = "Manga Cover",
                    modifier = Modifier
                        .size(width = 90.dp, height = 120.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Text Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(12.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = chapter,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = timeAgo,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        // Continue Button
                        Button(
                            onClick = onItemClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryColor
                            ),
                            modifier = Modifier
                                .padding(start = 8.dp)
                        ) {
                            Text("Lanjut", fontWeight = FontWeight.Bold)
                        }
                    }
                }


            }
        }
    }
}