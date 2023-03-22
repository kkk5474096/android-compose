package com.backpac.composeandroid.local

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.backpac.composeandroid.ui.theme.ComposeAndroidTheme

class CompositionLocalActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTheme {
                Composable1()
            }
        }
    }
}

val LocalColor = staticCompositionLocalOf { Color(0xFFffdbcf) }

@Composable
fun Composable1() {
    var color = if (isSystemInDarkTheme()) {
        Color(0xFFa08d87)
    } else {
        Color(0xFFffdbcf)
    }

    Column {
        Composable2()

        CompositionLocalProvider(LocalColor provides color) {
            Composable3()
        }

    }
}

@Composable
fun Composable2() {
        Composable4()
}

@Composable
fun Composable3() {
    Text(text = "Composable 3", modifier = Modifier.background(LocalColor.current))

    CompositionLocalProvider(LocalColor provides Color.Red) {
        Composable5()
    }
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {
    Text(text = "Composable 5", modifier = Modifier.background(LocalColor.current))

    CompositionLocalProvider(LocalColor provides Color.Green) {
        Composable7()
    }
    CompositionLocalProvider(LocalColor provides Color.Yellow) {
        Composable8()
    }
}

@Composable
fun Composable6() {
    Text(text = "Composable 6", modifier = Modifier.background(LocalColor.current))
}

@Composable
fun Composable7() {
}

@Composable
fun Composable8() {
    Text(text = "Composable 8", modifier = Modifier.background(color = LocalColor.current))
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    ComposeAndroidTheme {
        Composable1()
    }
}