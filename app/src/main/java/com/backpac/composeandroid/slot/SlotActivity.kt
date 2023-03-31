package com.backpac.composeandroid.slot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.backpac.composeandroid.R
import com.backpac.composeandroid.stagger.padding
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme

class SlotActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var linearSelected by remember { mutableStateOf(true) }
    var imageSelected by remember { mutableStateOf(true) }

    val onLinerClick = { value: Boolean ->
        linearSelected = value
    }

    val onTitleClick = { value: Boolean ->
        imageSelected = value
    }

    ScreenContent(
        linearSelected = linearSelected,
        imageSelected = imageSelected,
        onLinearClick = onLinerClick,
        onTitleClick = onTitleClick,
        titleContent = {
            if (imageSelected) {
                TitleImage(drawing = R.drawable.cloud)
            } else {
                Text(
                    text = "Downloading",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(30.dp)
                )
            }
        },
        progressContent = {
            if (linearSelected) {
                LinearProgressIndicator(Modifier.height(40.dp))
            } else {
                CircularProgressIndicator(Modifier.size(200.dp), strokeWidth = 18.dp)
            }
        })
}

@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        titleContent()
        progressContent()
        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onLinearClick = onLinearClick,
            onTitleClick = onTitleClick
        )
    }
}

@Composable
fun CheckBoxes(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = imageSelected, onCheckedChange = onTitleClick)
        Text("Image Title")
        Spacer(modifier = Modifier.width(20.dp))
        Checkbox(checked = linearSelected, onCheckedChange = onLinearClick)
        Text("Linear Progress")
    }
}

@Composable
fun TitleImage(drawing: Int) {
    Image(painter = painterResource(id = drawing), contentDescription = "title image")
}

@Preview(showSystemUi = true)
@Composable
fun DemoPreview() {
    ComposeAndroidTheme {
         MainScreen()
    }
}