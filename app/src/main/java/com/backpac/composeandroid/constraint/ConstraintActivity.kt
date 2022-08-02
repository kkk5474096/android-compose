package com.backpac.composeandroid.constraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme

class ConstraintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {

            }
        }
    }
}

@Composable
fun ConstraintContent() {
    ConstraintLayout {
        val (button, text) = createRefs()

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button")
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
        })
    }
}

@Preview
@Composable
fun Preview() {
    ComposeAndroidTheme {
        ConstraintContent()
    }
}
