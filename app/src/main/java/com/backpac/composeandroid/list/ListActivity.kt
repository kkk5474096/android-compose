package com.backpac.composeandroid.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme
import kotlinx.coroutines.launch

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {
                ListApp()
            }
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://avatars.githubusercontent.com/u/56147398?v=4"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}


@Composable
fun ListApp() {
    val itemSize = 1000
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Scroll to the top")
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(itemSize - 1)
                    }
                },
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(state = scrollState) {
            items(1000) {
                ImageListItem(index = it)
            }
        }
    }
}
