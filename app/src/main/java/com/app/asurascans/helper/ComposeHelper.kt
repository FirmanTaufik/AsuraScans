package com.app.asurascans.helper

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
fun CustomScrollbar(
    state: ScrollState,
    contentHeight: Dp,
    modifier: Modifier = Modifier,
    indicatorContent: (@Composable (Float) -> Unit)? = null
) {
    val targetAlpha = if (state.isScrollInProgress) 1f else 0f
    val duration = if (state.isScrollInProgress) 150 else 1000

    val alpha by animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = tween(durationMillis = duration),
        label = "scrollbar"
    )

    val showScrollbar by remember {
        derivedStateOf { state.isScrollInProgress }
    }

    Box(
        modifier = modifier.height(contentHeight),
        contentAlignment = Alignment.CenterEnd
    ) {
        if (showScrollbar || alpha > 0f) {
            Box(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .height(contentHeight)
                    .width(8.dp)
                    .alpha(alpha)
            ) {
                // Background track
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.3f))
                        .align(Alignment.CenterEnd)
                )

                // Scrollbar thumb
                Box(
                    modifier = Modifier
                        .fillMaxHeight(
                            fraction = if (state.maxValue > 0) {
                                val viewportRatio = state.maxValue.toFloat() / (state.maxValue + state.value)
                                viewportRatio.coerceIn(0.1f, 1f)
                            } else 1f
                        )
                        .width(10.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .align(Alignment.TopEnd)
                        .offset(y = calculateScrollThumbOffset(state))
                )

                // Indicator
                indicatorContent?.let { content ->
                    Box(
                        modifier = Modifier
                            .offset(x = (-40).dp)
                            .alpha(alpha)
                    ) {
                        val progress = if (state.maxValue > 0) {
                            state.value.toFloat() / state.maxValue.toFloat()
                        } else 0f
                        content(progress)
                    }
                }
            }
        }
    }
}

@Composable
fun RequestPermissions(
    permissions: Array<String>,
    onResult: (Boolean) -> Unit
) {
    var allGranted by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        allGranted = result.all { it.value }
        onResult(allGranted)
    }

    LaunchedEffect(Unit) {
        launcher.launch(permissions)
    }
}


private fun calculateScrollThumbOffset(state: ScrollState): Dp {
    if (state.maxValue == 0) return 0.dp

    val scrollPercentage = state.value.toFloat() / state.maxValue.toFloat()
    return (state.maxValue * scrollPercentage).dp
}

