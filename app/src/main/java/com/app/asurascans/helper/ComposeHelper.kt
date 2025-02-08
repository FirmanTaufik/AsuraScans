package com.app.asurascans.helper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.app.asurascans.ui.theme.primaryColor

@Composable
fun getDeviceWidthInDp(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}

@Composable
fun tittleBoard(title:String, modifier: Modifier) {
    if (title.isEmpty()) return
    val firstChar = title.first()
    val otherChar = title.drop(1)
   return Row(modifier = modifier,
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center) {
       Text(text = firstChar.toString(), color = primaryColor,
           modifier = Modifier ,
           textAlign = TextAlign.Center,
           fontSize = 23.sp, fontWeight = FontWeight.Bold)

       Text(text = otherChar  , color = Color.White,
           modifier = Modifier ,
           textAlign = TextAlign.Center,
           fontSize = 23.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun getContext()  = LocalContext.current

@Composable
fun startNewActivity() {
    val context = LocalContext.current

}