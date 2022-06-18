package com.backpac.composeandroid.guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme

class GuideActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

@Composable
private fun MessageCard(msg: Message) {
    Column {
        Text(msg.author, fontSize = 30.sp)
        Text(msg.body)
    }
}

@Preview
@Composable
private fun PreviewMessageCard() {
    MessageCard(Message("Android", "Jetpack Compose"))
}