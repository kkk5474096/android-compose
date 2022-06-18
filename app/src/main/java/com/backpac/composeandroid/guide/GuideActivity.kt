package com.backpac.composeandroid.guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.backpac.composeandroid.R
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
    Row(Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "android",
            Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(msg.body)
        }
    }

}

@Preview
@Composable
private fun PreviewMessageCard() {
    MessageCard(Message("Android", "Jetpack Compose"))
}