package com.app.asurascans.ui.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.primaryColor
import com.app.asurascans.ui.theme.primaryColorSelected

@Composable
fun TextSelectedItem(value: String? = "this", index:Int, indexSelected: Int, onClick : (Int) ->Unit ?={}) {
    Column(modifier = Modifier.wrapContentWidth().clickable {
        onClick.invoke(index)
    },
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text =value ?: "", color = if (index==indexSelected) primaryColorSelected else BackroundColor, fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 5.dp),)
        Divider(thickness = 3.dp,
            color = primaryColor,
            modifier = Modifier.width(10.dp))
    }
}

