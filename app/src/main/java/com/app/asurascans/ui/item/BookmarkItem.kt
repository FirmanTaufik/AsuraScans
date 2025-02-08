package com.app.asurascans.ui.item

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.helper.startNewActivity
import com.app.asurascans.ui.screen.DetailActivity
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.backgroundItemColor

@Composable
fun BookmarkItem() {

    val context = LocalContext.current
    Box (modifier = Modifier
        .wrapContentSize()
        .padding(end = 10.dp)){
        Column(
            modifier = Modifier
                .width(110.dp)
                .wrapContentHeight()
                .clickable {
                    context.startActivity(Intent(context, DetailActivity::class.java))
                }
                .background(color = backgroundItemColor, RoundedCornerShape(6.dp))
        ) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/id/4/46/Jujutsu_kaisen.jpg",
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(6))

                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "dkankdnakdnakdnkaknda dkajdka",
                maxLines = 1, color = Color.White,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 15.dp)
            )

        }
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
    }
}