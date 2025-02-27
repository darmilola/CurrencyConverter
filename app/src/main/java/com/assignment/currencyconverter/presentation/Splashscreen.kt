package com.assignment.currencyconverter.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.assignment.currencyconverter.R
import com.assignment.currencyconverter.ui.AppTheme
import kotlinx.coroutines.delay

class Splashscreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LaunchedEffect(key1 = true) {
                    delay(3000L)
                    startActivity(Intent(this@Splashscreen, MainActivity::class.java))
                }
            }
        }

    }
}