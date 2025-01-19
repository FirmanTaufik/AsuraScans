package com.app.asurascans.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.asurascans.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlphabetItem(modifier: Modifier = Modifier, text :String) {
    Box (
        modifier
            .wrapContentSize()
            .padding(vertical = 20.dp)
    ){
        Card(onClick = { /*TODO*/ },
            colors = CardDefaults.cardColors(containerColor = primaryColor, contentColor = primaryColor),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
        ) {
            Box(
                modifier=Modifier.fillMaxSize()) {
                Text(
                    text = text, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}