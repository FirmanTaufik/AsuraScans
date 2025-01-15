package com.app.asurascans.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.ui.theme.ColorTransaprent
import com.app.asurascans.ui.theme.primaryColor

class DetailActivity : BaseActivity() {

    @Composable
    override fun ScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            IconButton(modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopStart), onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.detail_ic_row_back),
                    contentDescription = null
                )
            }

            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.TopEnd)
            ) {

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = ColorTransaprent, shape = CircleShape)
                ) {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bookmark),
                            contentDescription = null,
                            tint = primaryColor
                        )
                        Text(text = "123", color = Color.White, fontSize = 15.sp)
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = ColorTransaprent, shape = CircleShape)
                ) {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_comment),
                            contentDescription = null,
                            tint = primaryColor
                        )
                        Text(text = "123", color = Color.White, fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

