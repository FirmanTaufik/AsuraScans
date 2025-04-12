package com.app.asurascans.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.SolidColor

@Composable
fun CustomCommentField(modifier: Modifier) {
    var comment by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = modifier
            .background(Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp) // Custom padding
    ) {
        if (comment.text.isEmpty()) {
            Text(
                text = "Tambahkan komentar...",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
        BasicTextField(
            value = comment,
            onValueChange = { comment = it },
            modifier = Modifier.fillMaxSize(),
            textStyle = LocalTextStyle.current.copy(
                color = Color.White,
                fontSize = 14.sp
            ),
            singleLine = true,
            cursorBrush = SolidColor(Color.White)
        )
    }
}
