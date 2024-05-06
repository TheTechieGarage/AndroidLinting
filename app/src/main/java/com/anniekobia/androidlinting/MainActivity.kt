package com.anniekobia.androidlinting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anniekobia.androidlinting.ui.theme.AndroidLintingTheme

/**
 * Entry point, displays success message text
 */
class MainActivity : ComponentActivity() {
    // Fixed failing lint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLintingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting(number = 3, topic = "\"Linting in Android\"")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    number: Int,
    topic: String,
) {
    Box(
        modifier =
            Modifier.fillMaxSize()
                .padding(30.dp),
        contentAlignment = Alignment.Center,
    ) {
        val text =
            buildAnnotatedString {
                append("You successfully ran ")
                withStyle(style = SpanStyle(color = Color.Magenta)) {
                    append("The Techie Garage Episode $number")
                }
                append(" demo app on ")
                withStyle(style = SpanStyle(color = Color.Magenta)) {
                    append(topic)
                }
            }
        Text(
            text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidLintingTheme {
        Greeting(number = 2, topic = "\"Linting in Android\"")
    }
}
