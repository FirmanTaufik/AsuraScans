package com.app.asurascans.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorIcon
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.backgroundItemColor

@Composable
fun GenreItem(modifier: Modifier = Modifier, genre: String) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(5.dp)
    ) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = backgroundItemColor, contentColor = ColorWhite),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .wrapContentSize() ) {
            Text(
                text = genre, modifier = Modifier
            )
        }
    }
}