package com.app.asurascans.ui.item

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.asurascans.Greeting
import com.app.asurascans.R
import com.app.asurascans.ui.theme.AsuraScansTheme

@Composable
fun BottomSlider(modifier: Modifier = Modifier) {
    /*Box(modifier = modifier
        .background(shape = Round)){


    }*/
}

@Composable
fun RoundedImageWithShadow(painter: Painter= painterResource(id = R.drawable.ic_small_app)) {
    val triangleShape = GenericShape { size, _ ->
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
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoundedImageWithShadow()
}