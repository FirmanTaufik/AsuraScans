package com.app.asurascans.ui.item

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.asurascans.Greeting
import com.app.asurascans.R
import com.app.asurascans.ui.theme.AsuraScansTheme

@Composable
fun BottomSlider(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
        .paint(painter = painterResource(id = R.drawable.bg_bottom_slider))
        .height(130.dp)){


        AsyncImage(model ="https://upload.wikimedia.org/wikipedia/id/4/46/Jujutsu_kaisen.jpg" , contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .width(130.dp)
                .align(Alignment.TopEnd),
            contentScale = ContentScale.Crop)
       /* Row (modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.bg_bottom_slider), contentDescription =null,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),)
            Spacer(modifier = Modifier.width(65.dp))
        }*/
    }
}

@Composable
fun RoundedImageWithShadow(painter: Painter= painterResource(id = R.drawable.ic_small_app)) {

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