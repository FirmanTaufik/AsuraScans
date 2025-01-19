package com.app.asurascans.ui.item

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.ui.screen.DetailActivity
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun MostViewItem() {
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
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .wrapContentSize()
                .align(Alignment.TopEnd)) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(color = BackroundColor, CircleShape)
                        .padding(top = 10.dp, start = 3.dp, end = 3.dp)
                ) {
                    Text(
                        text = "1", modifier = Modifier.wrapContentSize(),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
}

