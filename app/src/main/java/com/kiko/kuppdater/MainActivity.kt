package com.kiko.kuppdater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.kuppdater.data.states.rememberUpdateSheet
import com.kiko.kuppdater.ui.sheet.UpdateSheet
import com.kiko.kuppdater.ui.theme.KuppdaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuppdaterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val updateSheet =
                        rememberUpdateSheet(jsonUrl = "https://wearssl.ru/update.json")
                    UpdateSheet(LocalContext.current, updateSheet)
                }
            }
        }
    }
}