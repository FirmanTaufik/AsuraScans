package com.app.asurascans.ui.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.asurascans.ui.theme.grayColor
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun TopSliderItem(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(7.dp),
            colors = CardDefaults.cardColors(contentColor = primaryColor, containerColor = primaryColor)
        ) { }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(130.dp)) {
            Spacer(modifier = Modifier.width(3.dp))
            Card(
                modifier = Modifier
                    .fillMaxSize() ,
                shape = RoundedCornerShape(7.dp),
                colors = CardDefaults.cardColors(contentColor = grayColor)
            ) { }
        }
    }
}