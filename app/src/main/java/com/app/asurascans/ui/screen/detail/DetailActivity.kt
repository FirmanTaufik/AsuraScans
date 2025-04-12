package com.app.asurascans.ui.screen.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.app.asurascans.BuildConfig
import com.app.asurascans.R
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.core.UIState
import com.app.asurascans.helper.Constant
import com.app.asurascans.helper.fromObjectToJson
import com.app.asurascans.helper.launchActivity
import com.app.asurascans.helper.rememberCallbackActivityLauncher
import com.app.asurascans.helper.shareTextAction
import com.app.asurascans.ui.bottomsheet.Comments
import com.app.asurascans.ui.item.ChapterDetailItem
import com.app.asurascans.ui.screen.read.ReadActivity
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.ColorIcon
import com.app.asurascans.ui.theme.ColorTransparent
import com.app.asurascans.ui.theme.ColorWhite
import com.app.asurascans.ui.theme.backgroundItemColor
import com.app.asurascans.ui.theme.primaryColor

class DetailActivity : BaseActivity() {

    private lateinit var commentResponse: CommentModelResponse

    override fun viewModel(): DetailVM {
        val viewModel: DetailVM by viewModels()
        return viewModel
    }


    @Composable
    override fun BaseBottomsheet() {

        Comments(commentResponse.data) {
            viewModel().setBottomSheetSate(it)
        }
    }

    @Composable
    override fun OnInitViewCompose() {
        return LaunchedEffect(key1 = true) {
            viewModel().showFab(true)
        }
    }


    @Composable
    override fun BaseFloatingActionButton() {
        IconButton(
            onClick = {
                viewModel().getComments()
            },
            modifier = Modifier
                .size(70.dp),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = ColorBlack,
                containerColor = primaryColor
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = null,
                tint = ColorBlack,
                modifier = Modifier.size(50.dp)
            )
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun BaseContent(
        paddingValues: PaddingValues
    ) {
        val seriesId = intent.getStringExtra(Constant.SERIES_ID)
        LaunchedEffect(true) {
            viewModel().getDetail(seriesId)

        }

        val state by viewModel().commentState.collectAsStateWithLifecycle()

        when (state) {
            is UIState.OnError -> {
                LaunchedEffect(key1 = true) {
                    viewModel().showLoading(false)
                    viewModel().showSnackbar("tidak bisa load komentar", true)
                }

            }

            is UIState.OnLoading -> {
                LaunchedEffect(key1 = true) {
                    viewModel().showLoading(true)
                }
            }

            is UIState.OnSuccess<*> -> {
                LaunchedEffect(key1 = true) {
                    viewModel().showLoading(false)
                    val data = (state as UIState.OnSuccess<*>).data as CommentModelResponse
                    commentResponse = data
                    viewModel().setBottomSheetSate(true)
                }

            }

            UIState.OnIdle -> Unit
        }

        val detailState by viewModel().detailState.collectAsStateWithLifecycle()

        Box(
            modifier = Modifier
                .imePadding()
                .fillMaxSize()
        ) {
            when (detailState) {
                is UIState.OnError -> {
                    val message = (detailState as UIState.OnError)?.message
                    Text(
                        text = message ?: "",
                        Modifier.align(Alignment.Center),
                        color = ColorWhite
                    )
                }

                UIState.OnIdle -> Unit
                UIState.OnLoading -> CircularProgressIndicator(
                    color = ColorWhite,
                    modifier = Modifier.align(Alignment.Center)
                )

                is UIState.OnSuccess<*> -> {
                    val dataSuccess =
                        (detailState as UIState.OnSuccess<*>).data as DetailModelResponse
                    SuccessContent(dataSuccess.data)
                }
            }


        }
    }

    @Composable
    private fun SuccessContent(data: DetailModelResponse.Data?) {
        val launcher = rememberCallbackActivityLauncher()
        AsyncImage(
            model = data?.coverImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(ColorTransparent, Color.Black)
                        ),
                    ),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = ColorBlack,
                    ),
            )
        }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                HeaderDetail(data)
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                PosterAndTitle(data)
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                GenreSlider(data?.taxonomy?.Genre)
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                HiglightComment(data)
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                ListChapterArea()
                Spacer(modifier = Modifier.height(15.dp))
            }
            itemsIndexed(data?.chapters?.toList() ?: listOf()) { index, item ->
                ChapterDetailItem(item) {
                    val bundle = Bundle().apply {
                        putString(Constant.CHAPTER_ITEM, item.fromObjectToJson())
                        putString(Constant.DETAIL_DATA, data.fromObjectToJson())
                    }

                    launchActivity<ReadActivity>(launcher, bundle)
                }
            }
        }


    }

    @Composable
    private fun PosterAndTitle(data: DetailModelResponse.Data?) {
        val image = if (data?.portraitImageUrl.isNullOrEmpty()) data?.coverImageUrl
        else data?.portraitImageUrl
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(180.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = data?.title ?: "", color = Color.White, fontSize = 15.sp)

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HeaderDetail(data: DetailModelResponse.Data?) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier
                    //  .background(color = ColorTransparent, shape = CircleShape)
                    .size(50.dp)
                    .align(Alignment.TopStart), onClick = { finish() },
                colors = CardDefaults.cardColors(containerColor = ColorTransparent),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.detail_ic_row_back),
                    contentDescription = null,
                    modifier = Modifier.background(color = Color.Transparent)
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
                        .background(color = ColorTransparent, shape = CircleShape)
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
                        Text(
                            text = data?.bookmarkCount.toString(),
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = ColorTransparent, shape = CircleShape)
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

    @Composable
    private fun ListChapterArea() {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(width = 1.dp, color = ColorIcon),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = "Cari Chapter", color = ColorIcon)
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sort_chapter_default),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))


        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HiglightComment(data: DetailModelResponse.Data?) {
        var isExpand by remember { mutableStateOf(false) }

        Box {
            Box(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(15.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Box(modifier = Modifier.weight(1f)) {
                                    Button(
                                        onClick = { /*TODO*/ },
                                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                                    ) {
                                        Text(
                                            text = "Read Now",
                                            color = ColorBlack,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp
                                        )

                                    }
                                }

                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .size(50.dp),
                                    colors = IconButtonDefaults.iconButtonColors(
                                        contentColor = ColorBlack,
                                        containerColor = ColorButtonRefreshReadChapter
                                    )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_bookmark),
                                        contentDescription = null,
                                        tint = ColorWhite,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                IconButton(
                                    onClick = {
                                        val textShare =
                                            "Ayo Baca Komik ${data?.title} di Aplikasi ${
                                                resources.getString(R.string.app_name)
                                            } downoload di https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
                                        viewModel().context.shareTextAction(textShare)

                                    },
                                    modifier = Modifier
                                        .size(50.dp),
                                    colors = IconButtonDefaults.iconButtonColors(
                                        contentColor = ColorBlack,
                                        containerColor = ColorButtonRefreshReadChapter
                                    )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_share),
                                        contentDescription = null,
                                        tint = ColorWhite,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_star),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = data?.userRating.toString() ?: "0",
                                    fontStyle = FontStyle.Normal,
                                    fontSize = 18.sp,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    color = ColorWhite
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "(3 Voted)",
                                    fontStyle = FontStyle.Normal,
                                    fontSize = 13.sp,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    color = ColorWhite
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Apa pendapatmu tentang\nkomik ini?",
                                    fontSize = 15.sp,
                                    modifier = Modifier.weight(1f),
                                    color = ColorWhite,

                                    )
                                Card(
                                    onClick = {},
                                    shape = CircleShape
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_bad),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(8.dp), contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Card(
                                    onClick = {},
                                    shape = CircleShape
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_normal),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(8.dp), contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Card(
                                    onClick = {},
                                    shape = CircleShape
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_amazing),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(8.dp), contentDescription = null
                                    )
                                }
                            }

                            AnimatedVisibility(visible = isExpand) {
                                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus aliquam et nunc ac imperdiet. Nunc blandit enim et efficitur tincidunt. Sed ac malesuada sapien. Sed scelerisque, ante vitae accumsan malesuada, nisi leo malesuada ex, non tincidunt arcu dolor ac ligula. Nulla ac vehicula sem, laoreet molestie libero. Fusce elementum et elit at ornare. Nulla eleifend tristique congue. Integer nisl dui, posuere non nisi vitae, scelerisque sodales orci. Quisque feugiat libero augue, eget congue nisi blandit a. Nam pretium tincidunt tellus nec vehicula. Nulla lobortis nibh tortor, nec aliquet felis consectetur id. Nullam sed scelerisque mi, non eleifend nibh. Morbi nec semper ante, in efficitur augue. Vivamus porta nisi vitae tellus convallis faucibus.")
                            }
                        }
                    }
                }


            }
            
            Column(modifier = Modifier
                .align(Alignment.BottomCenter)) {
               Spacer(modifier = Modifier.height(150.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = primaryColor),
                    onClick = {
                        isExpand = !isExpand
                    },
                    modifier = Modifier,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Selengkapnya", color = ColorBlack,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }

    }


    @Composable
    private fun GenreSlider(genres: ArrayList<DetailModelResponse.Genre>?) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center),
                contentPadding = PaddingValues(5.dp)
            ) {
                itemsIndexed(genres?.toList() ?: listOf()) { index, item ->
                    Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = backgroundItemColor)
                        ) {
                            Text(
                                text = item.name ?: "",
                                color = ColorWhite,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(150.dp)
                    .align(Alignment.CenterStart)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(ColorBlack, Color.Transparent),
                            start = Offset(0f, 0f),  // Starting point of the gradient (left)
                            end = Offset(Float.POSITIVE_INFINITY, 0f) // Ending point (right)
                        )
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(15.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(30.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = ColorBlack,
                        containerColor = ColorIcon
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_genre),
                        contentDescription = null
                    )
                }
            }

            Row(
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(150.dp)
                    .align(Alignment.CenterEnd)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(ColorBlack, Color.Transparent),
                            start = Offset(
                                Float.POSITIVE_INFINITY,
                                0f
                            ),  // Starting point of the gradient (left)
                            end = Offset(0f, 0f) // Ending point (right)
                        )
                    ),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(30.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = ColorBlack,
                        containerColor = ColorIcon
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right_genre),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }

}



