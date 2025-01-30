package com.app.asurascans.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.ui.theme.grayColor

class ReadActivity : BaseActivity() {
    @Composable
    override fun ScreenContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
                Text(text = "Chapter 200", modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null
                    )
                }
                
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()) {
                    Text(text = "Favoritkan komik ini kalau kamu mau menerima notifikasi update dengan cara mengklik tombol LOVE",
                        textAlign = TextAlign.Center)
                    Row (modifier = Modifier.fillMaxWidth()){
                        Column(modifier = Modifier.weight(1f)) {

                        }
                    }
                }
            }
        }
    }
}