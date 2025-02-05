package com.app.asurascans.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.helper.getDeviceWidthInDp
import com.app.asurascans.ui.theme.ColorIcon
import com.app.asurascans.ui.theme.grayColor
import com.app.asurascans.ui.theme.primaryColor
import com.app.asurascans.ui.theme.primaryColorSelected

@Composable
fun TopSliderItem(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .width((getDeviceWidthInDp()-30) .dp)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(7.dp),
            colors = CardDefaults.cardColors(contentColor = primaryColor, containerColor = primaryColor)
        ) {  }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(130.dp)) {
            Spacer(modifier = Modifier.width(3.dp))
            Card(
                modifier = Modifier
                    .fillMaxSize() ,
                shape = RoundedCornerShape(7.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Box (modifier = Modifier.fillMaxSize()){

                    SkewedImage(imageUrl = "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p185776_b_v8_ad.jpg",
                        Modifier.align(Alignment.CenterEnd))

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                        verticalArrangement = Arrangement.Center) {
                        Text(text = "Completed", color = primaryColorSelected)
                        Text(text = "Dan da Dan", color = ColorIcon, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Chap 700", color = ColorIcon)
                        Text(text = "Action Shounen Super Powe", color = primaryColorSelected)
                    }
                }

            }
        }

    }
}