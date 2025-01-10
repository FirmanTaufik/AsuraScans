package com.app.asurascans.ui.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.ui.theme.primaryColor
import com.app.asurascans.ui.theme.primaryColorSelected

@Composable
fun TextSelectedItem(value: String ?= "this") {
    Column(modifier = Modifier.wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text =value ?: "", color = primaryColorSelected, fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 5.dp),)
        Divider(thickness = 3.dp,
            color = primaryColor,
            modifier = Modifier.width(10.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewText() {
    TextSelectedItem()
}