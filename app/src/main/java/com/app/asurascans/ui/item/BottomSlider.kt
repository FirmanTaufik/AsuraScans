package com.app.asurascans.ui.item

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.Greeting
import com.app.asurascans.R
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorWhite

@Composable
fun BottomSlider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(130.dp)
    ) {

        Box (modifier = Modifier.height(140.dp)){

            Card(
                modifier = Modifier.fillMaxWidth()
                    .height(130.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "New UI MangaEvo~",
                            color = ColorWhite,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Card(
                            border = BorderStroke(1.dp, color = ColorGrey),
                            shape = RoundedCornerShape(5.dp),
                            colors = CardDefaults.cardColors(containerColor = ColorBlack)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_time_ago),
                                    contentDescription = null,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(text = "3 jam yang lalu", fontSize = 13.sp, color = ColorGrey)
                            }
                        }
                    }
                    Box(modifier = Modifier.width(130.dp)) {

                        SlantedImage(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .height(140.dp)
                        )
                        AsyncImage(
                            model = "https://cdn1-production-images-kly.akamaized.net/Ub7pJzOcjsabp9WPoYE45FRSH10=/1200x1200/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/926057/original/020156700_1436610918-film_chibi_marukoedit-1.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .border(width = 2.dp, color = ColorWhite)
                                .width(80.dp)
                                .height(100.dp)
                                .align(Alignment.CenterStart),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_flag_slider_bottom),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 30.dp, width = 50.dp)
                    .align(Alignment.TopStart),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun RoundedImageWithShadow(painter: Painter = painterResource(id = R.drawable.ic_small_app)) {

    Canvas(
        modifier = Modifier
            .size(20.dp)
            .background(color = Color.Magenta)
    ) {
        drawCircle(
            color = Color.White,
            center = Offset(
                x = size.height,
                y = size.width
            ),
        )
    }

    /* val triangleShape = GenericShape { size, _ ->
         moveTo(0f, 0f,) // Top-left corner
         lineTo(size.width, 0f) // Top-right corner
         lineTo(0f, size.height) // Bottom-left corner
         close() // Complete the triangle
     }

     // Use the shape to clip the image
     Box(
         modifier = Modifier
             .size(200.dp) // Adjust size as needed
             .background(Color.Black) // Background for visibility
     ) {
         Image(
             painter = painter,
             contentDescription = "Image with Triangle Mask",
             modifier = Modifier
                 .fillMaxSize()
                 .clip(triangleShape) // Apply triangular clip
         )
     }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoundedImageWithShadow()
}