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
fun SkewedImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        // Gambar dengan bentuk miring

        AsyncImage(
            model = imageUrl,
            contentDescription = "Slanted Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.7f)  // Rasio tinggi:lebar yang lebih tinggi
                .graphicsLayer {
                    clip = true
                    shape = GenericShape { size, _ ->
                        // Membuat bentuk dengan sisi kiri miring
                        val slantWidth = size.width * 0.15f // Seberapa jauh kemiringan

                        // Urutan titik:
                        moveTo(slantWidth, 0f)        // Kiri atas (mulai dari titik yang sudah dimiring)
                        lineTo(size.width, 0f)        // Kanan atas (lurus)
                        lineTo(size.width, size.height) // Kanan bawah (lurus)
                        lineTo(0f, size.height)       // Kiri bawah
                        close()
                    }
                },
            contentScale = ContentScale.Crop
        )
    }
}