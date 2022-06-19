package com.backpac.composeandroid.guide

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.backpac.composeandroid.R
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme

class GuideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {
                Conversation(SampleData.conversationSample)
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
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "android",
            Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(msg.body, Modifier.padding(all = 4.dp), style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
private fun Conversation(message: List<Message>) {
    LazyColumn{
        items(message) { msg ->
            MessageCard(msg = msg)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMessageCard() {
    Conversation(SampleData.conversationSample)
}