package com.app.asurascans.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor
import com.ireward.htmlcompose.HtmlText

class LoginActivity : BaseActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun ScreenContent() {
        LoginContent()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = BackroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_liquid_melt),
            contentDescription = null,
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null,
                modifier = Modifier.size(180.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.welcome), color = Color.White,
                fontSize = 30.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.app_name), color = primaryColor,
                fontSize = 30.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            HtmlText(text = stringResource(id = R.string.login_intruction))
            Card(
                onClick = { /*TODO*/ },
                colors = CardDefaults.cardColors(
                    containerColor = primaryColor,
                    contentColor = primaryColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.height(60.dp)
                    .fillMaxWidth()
            ) {
                Box(modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight()) {
                    Image(
                        modifier = Modifier.align(Alignment.Center)
                            .size(230.dp),
                        painter = painterResource(id = R.drawable.login_google),
                        contentDescription = null
                    )
                }
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = stringResource(id = R.string.alert_privacy), color = Color.White,
                fontSize = 18.sp, textAlign = TextAlign.Center
            )

            HtmlText(
                text = stringResource(id = R.string.privacy_policy_and_terms_of_service),
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginContent()
}