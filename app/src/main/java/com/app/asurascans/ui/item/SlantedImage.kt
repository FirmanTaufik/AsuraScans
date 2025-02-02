package com.app.asurascans.ui.item

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SlantedImage(
    imageUrl: String?= "https://cdn1-production-images-kly.akamaized.net/Ub7pJzOcjsabp9WPoYE45FRSH10=/1200x1200/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/926057/original/020156700_1436610918-film_chibi_marukoedit-1.jpg",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Slanted Image",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .aspectRatio(0.8f)  // Rasio tinggi:lebar untuk gambar portrait
                .graphicsLayer {

                    clip = true
                    shape = GenericShape { size, _ ->
                        // Membuat bentuk dengan sisi kiri miring dari bawah ke atas
                        val slantOffset = size.width * 0.90f  // Seberapa jauh kemiringan di sisi kiri

                        // Menggambar bentuk:
                        moveTo(0f, 0f)                // Kiri atas
                        lineTo(size.width, 0f)        // Kanan atas (lurus)
                        lineTo(size.width, size.height) // Kanan bawah (lurus)
                        lineTo(slantOffset, size.height) // Kiri bawah (dimulai dari titik yang dimiring)
                        close()
                    }
                },
            contentScale = ContentScale.Crop
        )
    }
}