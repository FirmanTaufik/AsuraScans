package com.app.asurascans.ui.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
 import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.asurascans.R
import com.app.asurascans.ui.component.CustomCommentField
import com.app.asurascans.ui.item.ItemComment
import com.app.asurascans.ui.theme.ColorGrey
import com.app.asurascans.ui.theme.ColorIcon
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.ShimmerColor
import com.app.asurascans.ui.theme.grayColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Comments(showBottomSheet: (Boolean) ->Unit) {
    val sheetState = rememberModalBottomSheetState(true)
    val coroutineScope = rememberCoroutineScope()
    val keyboardHeight = WindowInsets.ime.getBottom(LocalDensity.current)
    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet.invoke ( false)
        },
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = grayColor,
        tonalElevation = 16.dp,
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .width(50.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(50))
                    .background(ColorGrey)
            )
        }
    ) {
        Column(modifier = Modifier
            .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top))
            .imePadding()
            .fillMaxWidth()
            .wrapContentHeight()) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "Komentar", fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "240",  fontSize = 13.sp, modifier = Modifier.padding(top = 5.dp))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "Sort by", fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                    IconButton(onClick = { /*TODO*/ },
                        Modifier
                            .background(color = Color.Transparent)
                            .padding(0.dp)
                            .size(13.dp)) {
                        Icon(painter = painterResource(id = R.drawable.ic_short_comments),
                            contentDescription =null , modifier = Modifier.padding(0.dp)
                                )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
                        coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet .invoke( false)
                            }
                        }
                                         },
                        Modifier
                            .background(color = Color.Transparent)
                            .padding(0.dp) ) {
                        Icon(painter = painterResource(id = com.ireward.htmlcompose.R.drawable.ic_m3_chip_close),
                            contentDescription =null , modifier = Modifier.padding(0.dp)
                        )
                    }
                }
            }
            Divider(
                Modifier
                    .height(1.dp)
                    .fillMaxWidth(), color = ColorGrey)

            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                items(10){
                    ItemComment()
                }
            }
            Divider(
                Modifier
                    .height(1.dp)
                    .fillMaxWidth(), color = ColorGrey)

            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 10.dp)){
                AsyncImage(
                    model = "https://images.genius.com/e86a0fabc1709ea8d56e994584ced53d.1000x1000x1.png",
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Comment Input Field
                CustomCommentField(
                    Modifier
                        .weight(1f)
                        .height(40.dp))

                Spacer(modifier = Modifier.width(8.dp))

                // Spoiler Button
                Button(
                    onClick = { /* Handle Spoiler Action */ },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(40.dp)
                        .padding(0.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Spoiler", fontSize = 16.sp)
                }
            }
        }


        /*Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Book Your Flight", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet .invoke( false)
                    }
                }
            }) {
                Text("Hide Bottom Sheet")
            }
        }*/
    }

}